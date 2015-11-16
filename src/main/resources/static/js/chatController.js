$(document).ready(function() {
    $('#message').keydown(function(event) {
        if(event.keyCode == 13) {
            sendMessage();
         }
    });
});

var stompClient = null;
function connect(board) {
    var currentBoard = $('#current-board');
    currentBoard.html(board);
    var boardName = $('#board-name');
    boardName.html(' ' + board.toUpperCase());

    disconnect();
    var socket = new SockJS('/message');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/receive/'+board, 
            function(message){
                angular.element($('#chat-box')).scope().appendMessage(message);
                angular.element($('#chat-box')).scope().$apply();
            });
    });
}

function disconnect() {
    if(stompClient) {
        angular.element($('#chat-box')).scope().clear();
        angular.element($('#chat-box')).scope().$apply();
        stompClient.disconnect();
    }
}
            
function sendMessage() {
    var board = $('#current-board').html();
    var message = document.getElementById('message').value;
    // This prevents an empty message from being sent
    if(message === '') {
        return;
    }
    document.getElementById('message').value = '';
    stompClient.send('/app/send/'+board, {}, JSON.stringify({ 'name': 'user', 'message': message }));
}
