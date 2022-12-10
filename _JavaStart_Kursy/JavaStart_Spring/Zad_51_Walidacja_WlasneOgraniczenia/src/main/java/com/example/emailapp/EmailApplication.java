package com.example.emailapp;

import org.apache.logging.log4j.message.Message;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class EmailApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(EmailApplication.class, args);
        EmailMessage message = new EmailMessage(
                "abc@abc.com",
                "zxc@zxc.pl",
                "Hejo! Co tam kurka u Ciebie słychać?"
        );
        EmailService service = context.getBean(EmailService.class);
        service.sendMessage(message);
    }

}
