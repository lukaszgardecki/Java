package com.example.kafka.controller;

import com.example.kafka.OrderDetails;
import com.example.kafka.service.OrderProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class OrderController {
    private final OrderProducer producer;

    @PostMapping ("/send")
    public ResponseEntity<?> publishMessage(@RequestBody String message) {
        try {
            for (int i = 0; i <= 10; i++) {
                producer.sendMessageToTopic(message + " : " + i);
            }
            return ResponseEntity.ok("Wiadomość wysłana pomyślnie...");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PostMapping("/save")
    public OrderDetails saveOrder(@RequestBody OrderDetails order) {
        producer.publishOrder(order);
        return order;
    }
//    @PostMapping("/publish")
//    public void sendEvents(@RequestBody Customer customer) {
//        publisher.sendEventsToTopic(customer);
//    }
}
