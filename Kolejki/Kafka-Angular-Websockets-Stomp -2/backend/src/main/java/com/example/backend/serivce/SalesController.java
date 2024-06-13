package com.example.backend.serivce;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping("/carsales")
public class SalesController {
    private final DataService service;

    @GetMapping("/last30days")
    public ResponseEntity<String> findLast30DaysSales(){
        try {
            return ResponseEntity.ok(service.getLast30DaysCarSalesData());
        }catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
