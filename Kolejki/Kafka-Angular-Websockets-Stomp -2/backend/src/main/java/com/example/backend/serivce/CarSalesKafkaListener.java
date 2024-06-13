package com.example.backend.serivce;

import com.example.backend.model.DataModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CarSalesKafkaListener {
    private final DemoMongoDBRepository demoRepository;


    // the kafka listener will listen and read all the incoming stream data from demo-topic and insert them into DB.
    @KafkaListener(topics = "${spring.kafka.topic.demo}")
    public void readDataStream(@Payload String record) {
        if(record!=null && record.length()>0) {
            DataModel object;
            try {
                object = new ObjectMapper().readValue(record, DataModel.class);
                demoRepository.save(object);
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
