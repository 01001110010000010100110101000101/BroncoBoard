package edu.csupomona.cs480;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


@Controller
public class MessageController {

    @MessageMapping("/send/cs480")
    @SendTo("/receive/cs480")
    public Message passMessage(Message message) throws Exception {
        System.out.println(message.getName() + "'s message is: " + message.getMessage());
        return message;
    } 

}
