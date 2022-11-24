package com.mojastrona.zad_5_profile;

import com.mojastrona.zad_5_profile.producer.MessageProducer;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class MessagePrinter {
    private final MessageProducer messageProducer;

    public MessagePrinter(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    void printMessage() {
        String message = messageProducer.getMessage();
        System.out.println(message);
    }

}
