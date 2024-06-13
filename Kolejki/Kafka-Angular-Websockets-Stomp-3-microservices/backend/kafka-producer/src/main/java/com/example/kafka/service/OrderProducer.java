package com.example.kafka.service;

import com.example.kafka.OrderDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class OrderProducer {
    private final KafkaTemplate<String, Object> template;
    private final ObjectMapper objectMapper;

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

    public void publishOrder(OrderDetails orderDetails) {
        try {
            String orderString = objectMapper.writeValueAsString(orderDetails);
            template.send("Temat1", orderString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

//    public void sendEventsToTopic(Customer customer) {
//        CompletableFuture<SendResult<String, Object>> future = template.send("Temat1", customer);
//        future.whenComplete((result, ex) -> {
//            if (ex == null) {
//                System.out.printf("PANIE! WIADOMOŚĆ WYSŁANA =[%s] Z OFSETEM =[%s]%n", customer.toString(), result.getRecordMetadata().offset());
//            } else {
//                System.out.printf("PANIE! NIE DA SIĘ WYSŁAĆ! =[%s] Z POWODU : %s%n", customer.toString(), ex.getMessage());
//            }
//        });
//    }

}
