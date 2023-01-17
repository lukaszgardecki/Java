package com.example.lektury;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class BookController {
    private final BooksService booksService;

    public BookController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("/")
    public String home(Model model) {
        BookDto[] bookDtos = booksService.getBooks();
        model.addAttribute("books", bookDtos);
        Arrays.stream(bookDtos).forEach(System.out::println);

        booksService.saveAll(bookDtos);

        return "bookPage";
    }
}
