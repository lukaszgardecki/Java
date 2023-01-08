package com.example.todo;

import com.example.todo.dto.NewTaskDto;
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
        TaskService service = context.getBean(TaskService.class);
        populateTestData(service);
        controller.loop();
    }

    private static void populateTestData(TaskService service) {
        service.saveTask(new NewTaskDto("Nauka Springa", "Nauczyć się obsługiwać bazy danych w Springu", 90));
        service.saveTask(new NewTaskDto("Poprawić budżet domowy", "Sprawdzić arkusz, który błędnie liczy budżet domowy", 50));
        service.saveTask(new NewTaskDto("Auto do mechanika", "Umówić i zawieźć auto do mechanika na przegląd", 80));
        service.saveTask(new NewTaskDto("Zaplanować wakacje", "Wyszukać i zaklepać wakacje w biurze podróży", 70));
        service.saveTask(new NewTaskDto("Kupić farbę", "Kupić białą farbę do odmalowania mieszkania", 30));
        service.startTask(1L);
        service.completeTask(1L);
        service.startTask(3L);
        service.completeTask(3L);
    }

    @Bean
    Scanner scanner() {
        return new Scanner(System.in);
    }

}
