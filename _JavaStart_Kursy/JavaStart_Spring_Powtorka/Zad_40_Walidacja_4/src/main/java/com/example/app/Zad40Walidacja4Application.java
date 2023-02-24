package com.example.app;

import com.example.app.model.Equipment;
import com.example.app.model.Product;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Set;

@SpringBootApplication
public class Zad40Walidacja4Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Zad40Walidacja4Application.class, args);
        Validator validator = context.getBean(Validator.class);

        Product product1 = new Product("Dell XPS 15", "Laptop 15 calowy z 2021 roku", "P7L13243");
        Set<ConstraintViolation<Object>> violations = validator.validate(product1);

        if (!violations.isEmpty()) {
            System.out.println("Nieprawidłowy produkt, złamane ograniczenia:");
            violations.stream().map(ConstraintViolation::getMessage).forEach(System.out::println);
        }

        Equipment equipment1 = new Equipment("iPhone 13", "KARNOW123", "EQ7986");
        Set<ConstraintViolation<Object>> violations1 = validator.validate(equipment1);

        if (!violations1.isEmpty()) {
            System.out.println("Nieprawidłowe wyposażenie, złamane ograniczenia:");
            violations1.stream().map(ConstraintViolation::getMessage).forEach(System.out::println);
        }

    }

}
