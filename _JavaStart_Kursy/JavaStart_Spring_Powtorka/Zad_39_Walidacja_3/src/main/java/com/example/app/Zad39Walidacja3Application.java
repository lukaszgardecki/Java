package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Zad39Walidacja3Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Zad39Walidacja3Application.class, args);
        EmailService service = context.getBean(EmailService.class);

        EmailMessage message = new EmailMessage(
                "abc@abc.com",
                "xyz@xyz.com",
                "Hejo! Co tam bs53 u Ciebie słychać wariacie? Pozdro"
        );

        service.sendMessage(message);
    }

}
