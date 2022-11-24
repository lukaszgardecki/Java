package com.mojastrona.zad_6_klasykonfiguracji;


import com.mojastrona.zad_6_klasykonfiguracji.producer.MessageProducer;
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
