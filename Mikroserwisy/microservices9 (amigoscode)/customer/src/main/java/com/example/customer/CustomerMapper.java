package com.example.customer;

public class CustomerMapper {

    static Customer map(CustomerRegistrationRequest request) {
        return Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
    }

    static CustomerRegistrationResponse map(Customer customer) {
        return CustomerRegistrationResponse.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .build();
    }
}
