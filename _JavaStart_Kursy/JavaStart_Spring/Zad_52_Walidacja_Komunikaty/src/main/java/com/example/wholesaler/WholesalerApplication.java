package com.example.wholesaler;

import com.example.wholesaler.constraint.SerialNoValidator;
import com.example.wholesaler.model.Equipment;
import com.example.wholesaler.model.Product;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Locale;
import java.util.Set;

@SpringBootApplication
public class WholesalerApplication {

    public static void main(String[] args) {
        Locale.setDefault(new Locale("pl"));

        ConfigurableApplicationContext context = SpringApplication.run(WholesalerApplication.class, args);
        Validator validator = context.getBean(Validator.class);

        Product product1 = new Product("Dell XPS 15", "Laptop 15 calowy z 2021 roku", "P5L12345");
        Set<ConstraintViolation<Product>> productViolations = validator.validate(product1);
        if (!productViolations.isEmpty()) {
            System.out.println("Nieprawidłowy produkt, złamane ograniczenia:");
            productViolations.stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
        }

        Equipment equipment1 = new Equipment("iPhone 13", "KARNOW124", "EQ1234");
        Set<ConstraintViolation<Equipment>> equipmentViolations = validator.validate(equipment1);
        if (!equipmentViolations.isEmpty()) {
            System.out.println("Nieprawidłowe wyposażenie, złamane ograniczenia:");
            equipmentViolations.stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
        }
    }

}
