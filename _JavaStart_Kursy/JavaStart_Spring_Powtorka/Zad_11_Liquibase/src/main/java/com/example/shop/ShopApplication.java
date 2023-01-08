package com.example.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ShopApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ShopApplication.class, args);
        ProductRepository repository = context.getBean(ProductRepository.class);
        repository.findAll().forEach(System.out::println);
    }

}
