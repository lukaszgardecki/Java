package com.example.hello.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExampleController {

    @RequestMapping("/first")
    @ResponseBody
    String first() {
        return "Tekst z pierwszej metody.";
    }

    @RequestMapping("/second")
    @ResponseBody
    String second() {
        return "Tekst z drugiej metody.";
    }
}
