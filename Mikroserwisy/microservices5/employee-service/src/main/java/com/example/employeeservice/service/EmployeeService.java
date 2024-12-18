package com.example.employeeservice.service;

import com.example.employeeservice.dto.AddressResponse;
import com.example.employeeservice.dto.EmployeeResponse;
import com.example.employeeservice.mapper.EmployeeMapper;
import com.example.employeeservice.repository.EmployeeRepository;
import com.netflix.appinfo.InstanceInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final RestTemplate restTemplate;
    private final WebClient webClient;
    @Value("${addressservice.base.url}")
    private String addressBaseURL;
    private DiscoveryClient discoveryClient;
    private LoadBalancerClient loadBalancerClient;

    public Optional<EmployeeResponse> getEmployeeById(Long id) {
        AddressResponse employeeAddress = getAddressByEmployeeIdWithRestTemplate(id);
        Optional<EmployeeResponse> employeeOptional = employeeRepository.findById(id).map(EmployeeMapper::mapToDto);
        if (employeeOptional.isPresent()) {
            EmployeeResponse employee = employeeOptional.get();
            employee.setAddress(employeeAddress);
            return Optional.of(employee);
        }
        return Optional.empty();
    }

    private AddressResponse getAddressByEmployeeIdWithRestTemplate(Long id) {
        return restTemplate.getForObject( "http://address-service/address-service/api/address/{id}", AddressResponse.class, id);
    }

    private AddressResponse getAddressByEmployeeIdWithWebClient(Long id) {
        return webClient.get()
                .uri("/address/" + id)
                .retrieve()
                .bodyToMono(AddressResponse.class)
                .block();
    }


}
