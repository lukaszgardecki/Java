package com.example.zad_54_security.web;

import com.example.zad_54_security.message.WelcomeMessageService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    private final WelcomeMessageService service;

    public HomeController(WelcomeMessageService service) {
        this.service = service;
    }

    @GetMapping("/")
    String home(@RequestParam(defaultValue = "en") String lang, Model model) {
        String welcomeMessage = service.getWelcomeMessage(lang);
        model.addAttribute("welcomeMessage", welcomeMessage);
        return "index";
    }



    // aby pobrać nazwę użytkownika:
//    @GetMapping("/")
//    String home(Authentication authentication, Model model) {
//        model.addAttribute("username", authentication.getName());
//        return "index";
//    }

    //to samo inaczej:
//    @GetMapping("/")
//    String home(@CurrentSecurityContext(expression = "authentication.name") String username, Model model) {
//        model.addAttribute("username", username);
//        return "index";
//    }
}
