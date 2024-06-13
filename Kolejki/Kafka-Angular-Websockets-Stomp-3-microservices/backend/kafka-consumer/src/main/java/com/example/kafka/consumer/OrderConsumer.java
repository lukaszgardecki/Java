package com.example.kafka.consumer;

import com.example.kafka.OrderDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderConsumer {
    private final ObjectMapper objectMapper;
//    @KafkaListener(topics = "Temat1", groupId = "grupa1")
//    public void consumeEvents(Customer customer) {
//        log.info("PANIE! JAKIŚ OBIEKT DOTARŁ! OTO ON: {}", customer.toString());
//    }

    @KafkaListener(topics = "Temat1", groupId = "grupa1")
    public void consume(String message) {
        try {
            OrderDetails order = objectMapper.readValue(message, OrderDetails.class);

            log.info("Order placed: %s :: %s".formatted(order.getProduct(), order.getStatus()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
