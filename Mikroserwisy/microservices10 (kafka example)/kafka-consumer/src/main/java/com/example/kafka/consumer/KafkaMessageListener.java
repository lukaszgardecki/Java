package com.example.kafka.consumer;

import com.example.kafka.dto.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaMessageListener {
    @KafkaListener(topics = "Temat1", groupId = "grupa1")
    public void consumeEvents(Customer customer) {
        log.info("PANIE! JAKIŚ OBIEKT DOTARŁ! OTO ON: {}", customer.toString());
    }

    @KafkaListener(topics = "Temat1", groupId = "grupa1")
    public void consume(String message) {
        log.info("PANIE! NADESZŁA WIADOMOŚĆ. OTO JEJ TREŚĆ: {}", message);
    }
}
