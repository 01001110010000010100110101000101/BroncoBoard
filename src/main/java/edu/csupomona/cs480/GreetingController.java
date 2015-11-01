package edu.csupomona.cs480;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import edu.csupomona.cs480.data.User;

@Controller
public class GreetingController {
	private String userName = "TempUser";
	private String receivedMessage;
	
	//User userObject = new User();
	//userName = userObject.getName();
    
    //stompClient connected over socket in html file.
    //calls stompClient.send("/app/userMessage") .
    //stompClient is subscribed to topic/greetings and will pick up the return
  	//object
    @MessageMapping("/userMessage")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        receivedMessage = message.getMessage();
        
        System.out.println("Message is: " + receivedMessage);
        
        return new Greeting(userName + " message: " + receivedMessage);
    } 
    

}
