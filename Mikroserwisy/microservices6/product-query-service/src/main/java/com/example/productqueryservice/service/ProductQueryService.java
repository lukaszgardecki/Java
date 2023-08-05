package com.example.productqueryservice.service;

import com.example.productqueryservice.entity.Product;
import com.example.productqueryservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductQueryService {
    private final ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }
}
