package com.example.textstats;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TextStatsController {
    private final TextStatsService textService;

    public TextStatsController(TextStatsService textService) {
        this.textService = textService;
    }

    @GetMapping("/")
    String home() {
        return "index";
    }

    @PostMapping("/stats")
    String text(@RequestParam(required = false) String text,
                @RequestParam(required = false) boolean textLength,
                @RequestParam(required = false) boolean words,
                @RequestParam(required = false) boolean palindrome,
                @RequestParam(required = false) boolean mostFamousWord,
                Model model) {

        if (text == null || text.isEmpty()) {
            return "errorPage";
        }

        TextStatsDto stats = textService.getTextStats(text, textLength, words, palindrome, mostFamousWord);
        model.addAttribute(stats);
        return "successPage";
    }
}
