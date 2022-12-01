package com.example.textstatistics;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TextStatController {
    private final TextStatService service;

    public TextStatController(TextStatService service) {
        this.service = service;
    }

    @GetMapping("/")
    String home() {
        return "index";
    }

    @PostMapping("/stats")
    String checkText(@RequestParam(required = false) String text,
                     @RequestParam(required = false) boolean length,
                     @RequestParam(required = false) boolean words,
                     @RequestParam(required = false) boolean palindrome,
                     @RequestParam(required = false) boolean mostPopularWord,
                     Model model) {

        if (text == null || text.isEmpty()) {
            return "empty-text";
        }
        TextStatDto textStats = service.getTextStats(text, length, words, palindrome, mostPopularWord);
        model.addAttribute("textStats", textStats);
        return "stats";
    }
}
