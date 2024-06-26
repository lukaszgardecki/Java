package com.example.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(LibraryApplication.class, args);
        BookRepository repository = context.getBean(BookRepository.class);
        Book book1 = new Book("W pustyni i w puszczy", "Henryk Sienkiewicz", "Greg", 2002, 312);
        repository.save(book1);
        Book book2 = new Book("Wilk z Wallstreet", "Jordan Belfort", "Świat Książki", 2014, 512);
        repository.save(book2);
    }

}
