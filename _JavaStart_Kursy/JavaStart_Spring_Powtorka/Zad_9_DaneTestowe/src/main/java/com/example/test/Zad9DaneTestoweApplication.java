package com.example.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Zad9DaneTestoweApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Zad9DaneTestoweApplication.class, args);
        UserRepository repository = context.getBean(UserRepository.class);
        repository.findAll().forEach(System.out::println);
    }

}
