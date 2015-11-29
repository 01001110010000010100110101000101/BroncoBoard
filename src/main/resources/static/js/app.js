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
                message: '@',
            },
            templateUrl: '/js/partials/message.html'
        };
    });

    app.controller('MessagingController', ['$scope', '$compile', function($scope, $compile) {
        $scope.appendMessage = function(message) {
            var m = angular.element(document.createElement("message"));
            if(message.body != null) {
                m.attr('name', JSON.parse(message.body).name);
                m.attr('message', JSON.parse(message.body).message);
                m.attr('time', JSON.parse(message.body).time);
                $("#chat-box").stop().animate({scrollTop:$("#chat-box")[0].scrollHeight}, 100);
            } else {
                m.attr('name', message.name);
                m.attr('message', message.message);
                m.attr('time', message.time);
            }
            $compile(m)($scope);
            angular.element(document.getElementById("chat")).append(m);
        };
        $scope.clear = function() {
            angular.element(document.getElementById("chat")).empty();
        };
    }]);

})();
