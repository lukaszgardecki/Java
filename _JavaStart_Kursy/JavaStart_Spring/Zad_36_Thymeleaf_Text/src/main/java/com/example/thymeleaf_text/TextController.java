package com.example.thymeleaf_text;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TextController {


    @GetMapping("/")
    String home(Model model) {
        // XSS Cross Site Scripting
//        model.addAttribute("dangerousCode", "<script>alert('Masz wirusa!');</script>");
        model.addAttribute("firstName", "Jan");
        model.addAttribute("lastName", "Kowalski");
        return "index";
    }
}
