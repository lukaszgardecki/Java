package com.example.constraints;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


import java.time.LocalDate;
import java.util.Set;

@SpringBootApplication
public class ValidationApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ValidationApplication.class, args);
        Validator validator = context.getBean(Validator.class);
        Person person = new Person(
                "Jan",
                "Kowalski",
                "87041277815",
                LocalDate.of(2033, 4, 12),
                "jankowalski.pl",
                "Qwer",
                "https//kowalski.pl"
        );
        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        if (!constraintViolations.isEmpty()) {
            System.out.println("Obiekt nieprawidłowy. Złamane ogrzniczenia:");
            for (ConstraintViolation<Person> violation : constraintViolations) {
                System.out.printf(" > %s %s (%s)\n",
                        violation.getPropertyPath(),
                        violation.getMessage(),
                        violation.getInvalidValue()
                        );
            }
        } else {
            System.out.println("Dane osoby są poprawne");
        }
    }

}
