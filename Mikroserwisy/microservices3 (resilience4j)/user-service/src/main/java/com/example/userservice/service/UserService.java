package com.example.userservice.service;

import com.example.userservice.dto.OrderDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

@Service
public class UserService {

    public List<OrderDto> findAllAvailableProducts() {
        return Stream.of(
                new OrderDto(119L, "LED TV", "electronics", "white", new BigDecimal(45000)),
                new OrderDto(345L, "Headset", "electronics", "black", new BigDecimal(7000)),
                new OrderDto(475L, "Sound bar", "electronics", "black", new BigDecimal(13000)),
                new OrderDto(574L, "Puma Shoes", "foot wear", "black & white", new BigDecimal(4600)),
                new OrderDto(678L, "Vegetable chopper", "kitchen", "blue", new BigDecimal(999)),
                new OrderDto(532L, "Oven Gloves", "kitchen", "gray", new BigDecimal(745))
        ).toList();
    }
}
