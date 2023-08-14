package com.example.web;

import com.example.jparelacje.laptop.LaptopService;
import com.example.jparelacje.laptop.dto.LaptopRequest;
import com.example.jparelacje.laptop.dto.LaptopResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/laptops")
@RequiredArgsConstructor
public class LaptopController {
    private final LaptopService laptopService;

    @PostMapping
    public LaptopResponse save(@RequestBody LaptopRequest laptop) {
        return laptopService.saveLaptop(laptop);
    }

    @GetMapping
    public List<LaptopResponse> findAll() {
        return laptopService.findAllLaptops();
    }

    @GetMapping("/{laptopId}")
    public LaptopResponse findLaptopById(@PathVariable Long laptopId) {
        return laptopService.findLaptopById(laptopId)
                .orElseThrow();
    }
}
