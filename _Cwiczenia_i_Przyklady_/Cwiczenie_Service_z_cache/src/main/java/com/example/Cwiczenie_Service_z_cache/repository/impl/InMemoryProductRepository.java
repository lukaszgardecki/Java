package com.example.Cwiczenie_Service_z_cache.repository.impl;

import com.example.Cwiczenie_Service_z_cache.model.Product;
import com.example.Cwiczenie_Service_z_cache.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.example.Cwiczenie_Service_z_cache.model.Category.FRUIT;
import static com.example.Cwiczenie_Service_z_cache.model.Category.VEGETABLE;

public class InMemoryProductRepository implements ProductRepository {
    private final List<Product> products;

    public InMemoryProductRepository() {
        this.products = new ArrayList<>(List.of(
                new Product("APPLE", new BigDecimal("10"), FRUIT),
                new Product("CARROT", new BigDecimal("30"), VEGETABLE),
                new Product("BANANA", new BigDecimal("20"), FRUIT),
                new Product("CUCUMBER", new BigDecimal("40"), VEGETABLE),
                new Product("ORANGE", new BigDecimal("45"), FRUIT),
                new Product("POTATO", new BigDecimal("25"), VEGETABLE),
                new Product("PEACH", new BigDecimal("15"), FRUIT)
        ));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
