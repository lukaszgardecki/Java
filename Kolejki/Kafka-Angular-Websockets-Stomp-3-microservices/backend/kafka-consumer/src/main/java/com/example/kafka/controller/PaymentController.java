package com.example.kafka.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PaymentController {
    private final SimpMessagingTemplate template;
    private int count = 0;

    @GetMapping("/notify")
    public String greet() {
        template.convertAndSend("/ordertopic/hello", "Payment: " + ++count);
        return "Client reload";
    }
}
