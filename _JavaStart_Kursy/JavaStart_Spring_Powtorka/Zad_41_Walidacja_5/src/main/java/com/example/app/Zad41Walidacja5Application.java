package com.example.app;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Set;

@SpringBootApplication
public class Zad41Walidacja5Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Zad41Walidacja5Application.class, args);
        ClientService clientService = context.getBean(ClientService.class);

        Client client = new Client("Jan", "Kowalski", "kowaljan@abc.com", 10);

        try {
            clientService.register(client);
            System.out.println("Rejestracja powiodła się: " + client);
        } catch (ConstraintViolationException e) {
            System.out.printf("Rejestracja nie powiodła się %s%n", client);
            Set<ConstraintViolation<?>> errors = e.getConstraintViolations();
            errors.stream()
                    .map(error -> String.format(" >%s %s %s", error.getPropertyPath(), error.getInvalidValue(), error.getMessage()))
                    .forEach(System.out::println);

        }
    }

}
