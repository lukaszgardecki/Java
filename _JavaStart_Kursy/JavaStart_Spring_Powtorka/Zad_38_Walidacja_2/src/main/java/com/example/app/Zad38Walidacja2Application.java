package com.example.app;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


import java.time.LocalDate;
import java.util.Set;

@SpringBootApplication
public class Zad38Walidacja2Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Zad38Walidacja2Application.class, args);
        Validator validator = context.getBean(Validator.class);
        Person person = new Person(
                "Jan",
                "Kowalski",
                "87041277815",
                LocalDate.of(1987, 4, 12),
                "jan@kowalski.xyz",
                "Qwerty87",
                "https://kowalski.xyz"
        );

        Person person2 = new Person(
                null,
                "Kowalski",
                "987041277815",
                LocalDate.of(2030, 4, 12),
                "jan@kowalski.xyz",
                "asd",
                "https://kowalski.xyz"
        );

        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person2);

        if (!constraintViolations.isEmpty()) {
            System.out.println("Obiekt jest nieprawidłowy. Złamane ograniczenia:");
            for (ConstraintViolation<Person> violation : constraintViolations) {
                System.out.printf(" > %s %s (%s) %n",
                        violation.getPropertyPath(),
                        violation.getMessage(),
                        violation.getInvalidValue());
            }
        } else {
            System.out.println("Dane osoby są prawidłowe.");
        }
    }

}
