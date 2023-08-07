package com.example.service.controller;

import com.example.service.dto.ProductEvent;
import com.example.service.entity.Product;
import com.example.service.service.ProductCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductCommandController {
    private final ProductCommandService productCommandService;

    @PostMapping
    public Product createProduct(@RequestBody ProductEvent productEvent) {
        return productCommandService.createProduct(productEvent);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody ProductEvent productEvent) {
        return productCommandService.updateProduct(id, productEvent);
    }
}

