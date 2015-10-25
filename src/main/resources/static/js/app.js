(function() {
    var app = angular.module('BroncoBoard', []);

    app.controller('BoardsController', ['$http', function($http) {
        var boards = this;
        boards.classes = [];
        boards.showClasses = function() { 
            if(boards.classes.length === 0) {
                $http.get('/classes').success(function(data) {
                    boards.classes = data;
                });
            }
        };
    }]);

})();
