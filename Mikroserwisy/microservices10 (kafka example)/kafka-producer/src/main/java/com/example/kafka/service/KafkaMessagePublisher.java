package com.example.kafka.service;

import com.example.kafka.dto.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class KafkaMessagePublisher {
    private final KafkaTemplate<String, Object> template;

    public void sendMessageToTopic(String message) {
        CompletableFuture<SendResult<String, Object>> future = template.send("Temat1", message);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.printf("PANIE! WIADOMOŚĆ WYSŁANA =[%s] Z OFSETEM =[%s]%n", message, result.getRecordMetadata().offset());
            } else {
                System.out.printf("PANIE! NIE DA SIĘ WYSŁAĆ! =[%s] Z POWODU : %s%n", message, ex.getMessage());
            }
        });
    }

    public void sendEventsToTopic(Customer customer) {
        CompletableFuture<SendResult<String, Object>> future = template.send("Temat1", customer);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.printf("PANIE! WIADOMOŚĆ WYSŁANA =[%s] Z OFSETEM =[%s]%n", customer.toString(), result.getRecordMetadata().offset());
            } else {
                System.out.printf("PANIE! NIE DA SIĘ WYSŁAĆ! =[%s] Z POWODU : %s%n", customer.toString(), ex.getMessage());
            }
        });
    }

}
