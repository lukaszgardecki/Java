package com.example.lektury;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
    private final BooksService booksService;

    public BookController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("/")
    public String home(Model model) {
        Book[] books = booksService.getBooks();
        model.addAttribute("books", books);
        return "bookPage";
    }
}
