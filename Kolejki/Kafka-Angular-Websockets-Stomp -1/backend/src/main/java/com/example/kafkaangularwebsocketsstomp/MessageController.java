package com.example.kafkaangularwebsocketsstomp;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class MessageController {
    SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/application")
    @SendTo("/all/messages")
    public Message send(Message message) {
        return message;
    }

    @MessageMapping("/private")
    public void sendToSpecificUser(@Payload Message message) {
        simpMessagingTemplate.convertAndSendToUser(message.getTo(), "/specific", message);
    }


}
