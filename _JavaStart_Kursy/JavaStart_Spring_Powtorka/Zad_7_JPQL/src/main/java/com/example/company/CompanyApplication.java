package com.example.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CompanyApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CompanyApplication.class, args);
        EmployeeRepository repository = context.getBean(EmployeeRepository.class);
        repository.save(new Employee(1L, "Jan", "Zenkiewicz", 2000.0));
        repository.save(new Employee(2L, "Marta", "Dudek", 13000.0));
        repository.save(new Employee(3L, "Paweł", "Adamczyk", 12500.0));
        repository.save(new Employee(4L, "Kasia", "Kowalska", 4000.0));

        System.out.println(">>> Pracownicy po podwyżce:");
        repository.giveRiseToAll();
        repository.findAll().forEach(System.out::println);

        System.out.println(">>> Bogaci pracownicy:");
        repository.findRichEmployees().forEach(System.out::println);

        System.out.println(">>> Pracownicy zarabiający pomiędzy 3000zł i 5000zł");
        repository.findBySalaryInRange(3000, 5000).forEach(System.out::println);
    }

}
