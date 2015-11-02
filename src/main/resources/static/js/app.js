(function() {
    var app = angular.module('BroncoBoard', []);

    app.controller('TabController', function() {
        this.tab = 0;

        this.setTab = function(index) {
            this.tab = index;
        };

        this.isSet = function(index) {
            return this.tab === index;
        };
    });

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

    app.directive('messageBox',function(){
        return {
            restrict:'E',
            templateUrl: '/js/partials/message-box.html'
        };
    });

    app.directive('message',function(){
        return {
            restrict:'E',
            scope: {
                name: '@',
                time: '@',
                content: '@',
            },
            templateUrl: '/js/partials/message.html'
        };
    });

    app.controller('MessagingController', function() {

    });

})();
