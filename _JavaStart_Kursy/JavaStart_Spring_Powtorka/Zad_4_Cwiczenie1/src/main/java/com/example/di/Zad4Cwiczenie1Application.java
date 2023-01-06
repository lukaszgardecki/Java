package com.example.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.security.sasl.SaslClient;
import java.util.Scanner;

@SpringBootApplication
public class Zad4Cwiczenie1Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Zad4Cwiczenie1Application.class, args);
        LinguController controller = context.getBean(LinguController.class);
        controller.mainLoop();
    }

    @Bean
    Scanner scanner() {
        return new Scanner(System.in);
    }

}
