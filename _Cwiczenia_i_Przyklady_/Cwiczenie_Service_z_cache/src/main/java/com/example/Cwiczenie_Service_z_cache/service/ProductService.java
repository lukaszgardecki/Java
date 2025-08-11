package com.example.Cwiczenie_Service_z_cache.service;

import com.example.Cwiczenie_Service_z_cache.model.Category;
import com.example.Cwiczenie_Service_z_cache.model.Product;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProductService {
    Optional<BigDecimal> calculateAveragePriceByCategory(Category category);
    EnumMap<Category, List<Product>> getProductsGroupedByCategory();
    Map<Boolean, List<Product>> getProductsPartitionedByVegetable();
    EnumMap<Category, List<Product>> findMostExpensiveProductsByCategory();
}
