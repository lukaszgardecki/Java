package com.example.catalogservice.service;

import com.example.catalogservice.entity.Order;
import com.example.catalogservice.repository.OrderRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    @PostConstruct
    public void initOrdersTable() {
        orderRepository.saveAll(Stream.of(
                        new Order("mobile", "electronics", "white", new BigDecimal(20000)),
                        new Order("T-Shirt", "clothes", "black", new BigDecimal(999)),
                        new Order("Jeans", "clothes", "blue", new BigDecimal(1999)),
                        new Order("Laptop", "electronics", "gray", new BigDecimal(50000)),
                        new Order("digital watch", "electronics", "black", new BigDecimal(2500)),
                        new Order("Fan", "electronics", "black", new BigDecimal(50000))
                )
                .toList());
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public List<Order> findByCategory(String category) {
        return orderRepository.findByCategory(category);
    }
}
