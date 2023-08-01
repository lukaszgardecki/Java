package com.example.employeeservice.feignclient;

import feign.Feign;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

// LoadBalancer ze swoją klasą konfiguracyjną
//@LoadBalancerClient(value = "address-service", configuration = MyCustomLoadBalancerConfiguration.class)

// LoadBalancer z domyślną klasą konfiguracyjną
@LoadBalancerClient(value = "address-service")
public class AddressServiceLoadBalancer {

    @Bean
    @LoadBalanced
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }
}
