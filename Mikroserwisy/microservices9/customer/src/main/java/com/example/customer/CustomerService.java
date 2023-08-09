package com.example.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public CustomerRegistrationResponse registerCustomer(CustomerRegistrationRequest request) {
        Customer customerToSave = CustomerMapper.map(request);
        // TODO: 09.08.2023 check if email valid
        // TODO: 09.08.2023 check if email not taken
        Customer savedCustomer = customerRepository.saveAndFlush(customerToSave);
        // TODO: 09.08.2023 check if fraudster
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                savedCustomer.getId()
        );
        if (fraudCheckResponse.isFraudster()) throw new IllegalStateException("fraudster");



        return CustomerMapper.map(savedCustomer);
    }

}
