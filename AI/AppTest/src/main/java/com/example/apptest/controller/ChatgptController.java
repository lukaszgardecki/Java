package com.example.apptest.controller;

import com.example.apptest.model.ChatgptRequest;
import com.example.apptest.model.ChatgptResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1")
public class ChatgptController {

    @Value("${chatgpt.model}")
    private String model;

    @Value("${chatgpt.api.url}")
    private String apiUrl;

    @Value("${chatgpt.api.key}")
    private String apiKey;

    private static RestTemplate restTemplate = new RestTemplate();

    @GetMapping(value = "/ask", produces = MediaType.APPLICATION_JSON_VALUE)
    public String ask(@RequestParam String query) {
        ChatgptRequest request = new ChatgptRequest(model, query);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + apiKey);
        ChatgptResponse chatgptResponse = restTemplate.postForObject(apiUrl, new HttpEntity<>(request, headers), ChatgptResponse.class);
        return chatgptResponse.getChoices().get(0).getMessage().getContent();
    }
}
