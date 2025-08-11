package com.example.Cwiczenie_Service_z_cache.repository;

import com.example.Cwiczenie_Service_z_cache.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
}
