package com.example.context;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class MessagePrinterConfig {
    private final String decorator;

    public MessagePrinterConfig(@Value("${app.message.decorator}") String decorator) {
        this.decorator = decorator;
    }

    Function<String, String> getDecorator() {
        if (decorator.equalsIgnoreCase("UPPERCASE")) {
            return String::toUpperCase;
        } else if (decorator.equalsIgnoreCase("LOWERCASE")) {
            return String::toLowerCase;
        }
        throw new InvalidDecoratorException("No decorator found for " + decorator);
    }
}
