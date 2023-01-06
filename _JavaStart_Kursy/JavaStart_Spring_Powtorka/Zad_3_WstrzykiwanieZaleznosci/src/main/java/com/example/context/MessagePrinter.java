package com.example.context;

import com.example.context.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class MessagePrinter {
    private final MessageProducer messageProducer;
    private final MessagePrinterConfig printerConfig;

    @Autowired
    public MessagePrinter(MessageProducer messageProducer, MessagePrinterConfig printerConfig) {
        this.messageProducer = messageProducer;
        this.printerConfig = printerConfig;
    }

    public void printMessage() {
        String message = messageProducer.getMessage();
        Function<String, String> decorator = printerConfig.getDecorator();
        String decoratedMessage = decorator.apply(message);
        System.out.println(decoratedMessage);
    }
}
