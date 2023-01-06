package com.example.todo;

import com.example.todo.dto.NewTaskDto;
import com.example.todo.dto.TaskDurationDto;
import com.example.todo.exception.TaskAlreadyCompletedException;
import com.example.todo.exception.TaskAlreadyStartedException;
import com.example.todo.exception.TaskNotFoundException;
import com.example.todo.exception.TaskNotStartedException;
import org.springframework.stereotype.Controller;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Scanner;

@Controller
public class TaskController {
    private final TaskService service;
    private final Scanner scanner;

    public TaskController(TaskService service, Scanner scanner) {
        this.service = service;
        this.scanner = scanner;
    }

    public void loop() {
        Option option;
        do {
            printOptions();
            option = chooseOption();
            evaluateOption(option);
        } while (option != Option.EXIT);
    }

    private void printOptions() {
        System.out.println("\nWybierz opcję:");
        for (Option option : Option.values()) {
            System.out.println(option);
        }
    }

    private Option chooseOption() {
        int optionNumber = scanner.nextInt();
        scanner.nextLine();
        return Option.fromInt(optionNumber);
    }

    private void evaluateOption(Option option) {
        try {
            switch (option) {
                case ADD -> addTask();
                case PRINT_SINGLE -> printTask();
                case START -> startTask();
                case END -> endTask();
                case EXIT -> exit();

            }
        } catch (TaskNotFoundException e) {
            System.out.println("Brak zadania ze wskazanym identyfikatorem");
        }
    }

    private void startTask() {
        System.out.println("Podaj id zadania, które chcesz wystartować:");
        Long id = scanner.nextLong();
        scanner.nextLine();

        try {
            LocalDateTime taskStartTime = service.startTask(id);
            System.out.println("Czas rozpoczęcia zadania: " + taskStartTime);
        } catch (TaskAlreadyStartedException e) {
            System.out.println("Zadanie zostało już wcześniej wystartowane.");
        }
    }

    private void endTask() {
        System.out.println("Podaj id zadania, które chcesz zakończyć:");
        Long id = scanner.nextLong();
        scanner.nextLine();

        try {
            TaskDurationDto taskDuration = service.completeTask(id);
            System.out.println(taskDuration);
        } catch (TaskAlreadyCompletedException e) {
            System.out.println("Zadanie zostało już wcześniej zakończone.");
        } catch (TaskNotStartedException e) {
            System.out.println("Wystartuj zadanie zanim je zakończysz.");
        }

    }

    private void addTask() {
        System.out.println("Podaj tytuł zadania:");
        String title = scanner.nextLine();
        System.out.println("Opis zadania:");
        String description = scanner.nextLine();
        System.out.println("Priorytet (wyższa liczba = wyższy priorytet):");
        int priority = scanner.nextInt();
        scanner.nextLine();
        NewTaskDto task = new NewTaskDto(title, description, priority);
        Long savedTaskId = service.saveTask(task);
        System.out.println("Zadanie zapisane z identyfikatorem " + savedTaskId);
    }

    private void printTask() {
        System.out.println("Podaj identyfikator zadania:");
        long taskId = scanner.nextLong();
        scanner.nextLine();
        service.getTaskInfo(taskId)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Brak wpisu o takim id")
                );
    }

    private void exit() {
        System.out.println("Koniec programu!");
    }

    private enum Option {
        ADD(1, "Dodaj nowe zadanie"),
        PRINT_SINGLE(2, "Wyświetl zadanie"),
        START(3, "Wystartuj zadanie"),
        END(4, "Zakończ zadanie"),
        EXIT(3, "Koniec programu");

        private final int number;
        private final String name;

        Option(int number, String name) {
            this.number = number;
            this.name = name;
        }

        static Option fromInt(int option) {
            return values()[option - 1];
        }

        @Override
        public String toString() {
            return number + " - " + name;
        }
    }
}
