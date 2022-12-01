package com.example.formatterkodu;

import com.google.googlejavaformat.java.FormatterException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CodeFormatController {
    private final CodeFormatService service;

    public CodeFormatController(CodeFormatService service) {
        this.service = service;
    }

    @GetMapping("/")
    String home() {
        return "index";
    }

    @PostMapping("/format")
    String format(@RequestParam String code, Model model) {
        try {
            String formattedCode = service.format(code);
            model.addAttribute("formattedCode", formattedCode);
        } catch (FormatterException e) {
            return "errorPage";
        }
        model.addAttribute("unformattedCode", code);
        return "secondPage";
    }
}
