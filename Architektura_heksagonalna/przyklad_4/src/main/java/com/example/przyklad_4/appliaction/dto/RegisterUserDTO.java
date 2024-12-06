package com.example.przyklad_4.appliaction.dto;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class RegisterUserDTO {
    private UUID uuid;
    private BigDecimal realAmount;
    private BigDecimal freeAmount;
    private AddressDTO address;
}
