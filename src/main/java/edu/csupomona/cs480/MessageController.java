package edu.csupomona.cs480;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


@Controller
public class MessageController {

    @MessageMapping("/send")
    @SendTo("/receive")
    public Message passMessage(Message message) throws Exception {
        return message;
    } 
}
