package com.example.mostfamousnames;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Zad10NajpopularniejszeImionaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Zad10NajpopularniejszeImionaApplication.class, args);
        NameStatRepository repository = context.getBean(NameStatRepository.class);

        System.out.println(">>> 10 najpopularniejszych imion:");
        repository.find10MostFamousNames().forEach(System.out::println);
    }

}
