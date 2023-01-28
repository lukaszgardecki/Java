package com.example.sessions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CounterController {
    private VisitCounter visitCounter;

    public CounterController(VisitCounter visitCounter) {
        this.visitCounter = visitCounter;
    }

    @GetMapping("/")
    String counter() {
        visitCounter.increment();
        return "index";
    }
}
