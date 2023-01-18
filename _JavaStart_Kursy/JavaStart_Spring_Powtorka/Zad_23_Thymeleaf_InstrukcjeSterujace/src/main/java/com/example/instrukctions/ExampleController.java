package com.example.instrukctions;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExampleController {

    @GetMapping("/")
    String example(Model model) {
        model.addAttribute(new Person("Jan", "Kowalski", 19));
        model.addAttribute("lang", "es");
        return "example";
    }
}