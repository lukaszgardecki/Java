package com.example.backend.serivce;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class WebSocketStream {
    private final String stompTopic;
    private final SimpMessagingTemplate messagingTemplate;
    private final DataService service;

    public WebSocketStream(
            @Value("${stomp.topic}") String stompTopic,
            SimpMessagingTemplate messagingTemplate,
            DataService service
    ) {
        this.stompTopic = stompTopic;
        this.messagingTemplate = messagingTemplate;
        this.service = service;
    }

    /**
     * This class has a scheduling configuration to execute every 2 seconds to call the metrics service
     * and post it on STOMP topic /cars. So with this we have the service layer that has an exposed REST
     * end point to expose the metrics of the last 30 days. It also has a WebSocket configuration to pos
     * updated metrics every 2 seconds to the registered client.
     */

    //co 2 sekundy będzie wykonywana ta metoda
    @Scheduled(fixedRate = 2000)
    public void streamCarSalesData() {
        String jsonObject = service.getLast30DaysCarSalesData();
        messagingTemplate.convertAndSend(stompTopic,jsonObject);
    }
}
