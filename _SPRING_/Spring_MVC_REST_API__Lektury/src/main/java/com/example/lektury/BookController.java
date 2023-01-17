package com.example.lektury;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
    private final BooksService booksService;

    public BookController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("/")
    public String home(Model model) {
        // pobierz dane z zewnętrznego API:
        BookDto[] bookDtos = booksService.getBooks();
        // zapisz dane do modelu:
        model.addAttribute("books", bookDtos);
        // zapisz dane w bazie:
        booksService.saveAll(bookDtos);

        return "bookPage";
    }
}
