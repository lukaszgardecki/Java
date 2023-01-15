package com.example.masterspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String hello(@RequestParam(name = "name", required = false, defaultValue = "paniczu") String name, Model model) {
        model.addAttribute("message", String.format("Siema %s!", name));
        return "resultPage";
    }
}
