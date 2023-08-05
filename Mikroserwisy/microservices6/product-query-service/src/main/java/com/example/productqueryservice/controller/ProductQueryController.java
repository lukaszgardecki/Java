package com.example.productqueryservice.controller;

import com.example.productqueryservice.entity.Product;
import com.example.productqueryservice.service.ProductQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductQueryController {
    private final ProductQueryService productQueryService;

    @GetMapping
    public List<Product> fetchAllProducts() {
        return productQueryService.getProducts();
    }

}
