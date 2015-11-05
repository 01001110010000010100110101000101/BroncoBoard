$(document).ready(function() {
    $('#message').keydown(function(event) {
        var msg = document.getElementById('message').value;
        if(event.keyCode == 13 && msg.match(/\S/)) {
            sendMessage();
         }
    });
});

var stompClient = null;
function connect() {
    var socket = new SockJS('/message');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/receive/cs480', 
            function(message){
                angular.element($('#chat-box')).scope().appendMessage(message);
                angular.element($('#chat-box')).scope().$apply();
            });
    });
}
            
function sendMessage() {
    var message = document.getElementById('message').value;
    document.getElementById('message').value = '';
    stompClient.send("/app/send/cs480", {}, JSON.stringify({ 'name': 'user', 'message': message }));
}