package com.example.employeeservice.feignclient;

import com.example.employeeservice.dto.AddressResponse;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "address-service", path = "/address-service/api")
// jako name dobrze dawać nazwę aplikacji, do której się odwołujemy
//@RibbonClient(name = "address-service")
public interface AddressClient {

    @GetMapping("/address/{employeeId}")
    ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable Long employeeId);

    @GetMapping("/addresses")
    ResponseEntity<List<AddressResponse>> getAllAddresses();
}
