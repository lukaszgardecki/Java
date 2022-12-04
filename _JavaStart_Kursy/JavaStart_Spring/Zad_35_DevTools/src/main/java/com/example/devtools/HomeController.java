package com.example.devtools;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    String home(Model model) {
        model.addAttribute("message", "To jest tekst z kontrolera przed zmianą");
        return "index";
    }
}
