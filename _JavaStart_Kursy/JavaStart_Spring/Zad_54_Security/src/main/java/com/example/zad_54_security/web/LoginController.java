package com.example.zad_54_security.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/logowanie")
    String loginForm() {
        return "login-form";
    }
}
