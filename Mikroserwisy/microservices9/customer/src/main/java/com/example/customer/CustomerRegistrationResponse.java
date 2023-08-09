package com.example.customer;

import lombok.Builder;

@Builder
public record CustomerRegistrationResponse(
        Long id,
        String firstName,
        String lastName,
        String email) {

}
