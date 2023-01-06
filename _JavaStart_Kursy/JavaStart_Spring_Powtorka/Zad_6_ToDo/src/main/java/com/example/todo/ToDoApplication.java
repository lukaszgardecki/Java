package com.example.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class ToDoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ToDoApplication.class, args);
        TaskController controller = context.getBean(TaskController.class);
        controller.loop();
    }

    @Bean
    Scanner scanner() {
        return new Scanner(System.in);
    }

}
