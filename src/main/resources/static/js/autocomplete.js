var substringMatcher = function(strs) {
  return function findMatches(q, cb) {
    var matches, substringRegex;

    // an array that will be populated with substring matches
    matches = [];

    // regex used to determine if a string contains the substring `q`
    substrRegex = new RegExp(q, 'i');

    // iterate through the pool of strings and for any string that
    // contains the substring `q`, add it to the `matches` array
    $.each(strs, function(i, str) {
      if (substrRegex.test(str)) {
        matches.push(str);
      }
    });

    cb(matches);
  };
};


var classes = [];
$(document).ready(function() {
    $.ajax({
        type: "GET",
        url: window.location.origin + '/classes',
        contentType: "application/json; charset=utf-8",
        async: false,
        success: function(data) {
            classes = data;
        }
    });
    $('#search').keydown(function(event) {
        if(event.keyCode == 13) {
            var board = document.getElementById('search');
            connect(board.value);
            board.form.reset();
         }
    });
});


$('#autocomplete .typeahead').typeahead({
  hint: true,
  highlight: true,
  minLength: 1
},
{
  name: 'classes',
  source: substringMatcher(classes)
});
