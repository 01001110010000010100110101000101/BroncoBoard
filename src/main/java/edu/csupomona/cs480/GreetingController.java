package edu.csupomona.cs480;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {
	private String userName;
	private String receivedMessage;
	
	//stompClient connected over socket in html file.
	//calls stompClient.send("/app/userName").
	//stompClient is subscribed to topic/greetings and will pick up the return
	//object
    @MessageMapping("/userName")
    @SendTo("/topic/greetings")
    public Greeting userName(HelloMessage message) throws Exception {
    	userName = message.getName();
        return new Greeting("Username is: " + userName +".");
    }
    
    //stompClient connected over socket in html file.
    //calls stompClient.send("/app/userMessage") .
    //stompClient is subscribed to topic/greetings and will pick up the return
  	//object
    @MessageMapping("/userMessage")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        receivedMessage = message.getMessage();
        return new Greeting(userName + " message: " + receivedMessage);
    } 
    

}
