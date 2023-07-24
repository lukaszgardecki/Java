package com.example.userservice.controller;

import com.example.userservice.dto.OrderDto;
import com.example.userservice.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user-service")
@RequiredArgsConstructor
public class UserController {
    private static final String BASEURL = "http://localhost:9191/orders";
    private static final String USER_SERVICE = "userService";
    private final RestTemplate restTemplate;
    private final UserService userService;
    private int attempt = 1;

    @GetMapping("/displayOrders")
    @CircuitBreaker(name = USER_SERVICE, fallbackMethod = "getAllAvailableProducts")
//    @Retry(name = USER_SERVICE, fallbackMethod = "getAllAvailableProducts")
    public List<OrderDto> displayOrders(@RequestParam String category) {
        String url = category == null ? BASEURL : BASEURL + "/" + category;
        System.out.println("retry method called " + attempt++ + " times at " + new Date());
        return restTemplate.getForObject(url, ArrayList.class);
    }

    public List<OrderDto> getAllAvailableProducts(Exception e){
        return userService.findAllAvailableProducts();
    }
}
