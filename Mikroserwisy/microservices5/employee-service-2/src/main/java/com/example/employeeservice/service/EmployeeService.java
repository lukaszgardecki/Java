package com.example.employeeservice.service;

import com.example.employeeservice.dto.AddressResponse;
import com.example.employeeservice.dto.EmployeeResponse;
import com.example.employeeservice.feignclient.AddressClient;
import com.example.employeeservice.mapper.EmployeeMapper;
import com.example.employeeservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final AddressClient addressClient;

    public Optional<EmployeeResponse> getEmployeeById(Long id) {
        ResponseEntity<AddressResponse> addressResponseEntity = addressClient.getAddressByEmployeeId(id);
        AddressResponse employeeAddress = addressResponseEntity.getBody();

        Optional<EmployeeResponse> employeeOptional = employeeRepository.findById(id).map(EmployeeMapper::mapToDto);
        if (employeeOptional.isPresent()) {
            EmployeeResponse employee = employeeOptional.get();
            employee.setAddress(employeeAddress);
            return Optional.of(employee);
        }
        return Optional.empty();
    }

    public List<EmployeeResponse> getAllEmployees() {
        List<EmployeeResponse> employees = employeeRepository.findAll().stream()
                .map(EmployeeMapper::mapToDto)
                .toList();
        List<AddressResponse> addresses = addressClient.getAllAddresses().getBody();

        employees.forEach(em ->  {
            for (AddressResponse address : addresses) {
                if (Objects.equals(address.getId(), em.getId())) {
                    em.setAddress(address);
                }
            }
        });

        return employees;
    }
}
