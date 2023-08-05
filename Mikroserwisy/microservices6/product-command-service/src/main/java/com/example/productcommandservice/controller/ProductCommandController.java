package com.example.productcommandservice.controller;

import com.example.productcommandservice.entity.Product;
import com.example.productcommandservice.service.ProductCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductCommandController {
    private final ProductCommandService productCommandService;

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productCommandService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productCommandService.updateProduct(id, product);
    }
}

