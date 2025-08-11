package com.example.Cwiczenie_Service_z_cache.service.impl;

import com.example.Cwiczenie_Service_z_cache.model.Category;
import com.example.Cwiczenie_Service_z_cache.model.Product;
import com.example.Cwiczenie_Service_z_cache.repository.ProductRepository;
import com.example.Cwiczenie_Service_z_cache.service.ProductService;

import java.math.BigDecimal;
import java.util.*;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class ProductServiceImpl implements ProductService {
    private final boolean useCashe;
    private final ProductRepository productRepository;
    private final Cache cache;

    public ProductServiceImpl(ProductRepository productRepository, boolean useCashe) {
        this.useCashe = useCashe;
        this.productRepository = productRepository;
        this.cache = useCashe ? new Cache(productRepository.findAll()) : null;
    }

    @Override
    public Optional<BigDecimal> calculateAveragePriceByCategory(Category category) {
        if (category == null)  {
            throw new IllegalArgumentException("Category is null.");
        }

        if (useCashe) {
            return Optional.ofNullable(cache.averagePriceByCategory.get(category));
        }
        return productRepository
                .findAll()
                .stream()
                .filter(product -> product.hasCategory(category))
                .map(product -> product.price().doubleValue())
                .collect(collectingAndThen(
                        averagingDouble(Double::doubleValue),
                        avg -> Optional.of(BigDecimal.valueOf(avg))
                ));
    }

    @Override
    public EnumMap<Category, List<Product>> getProductsGroupedByCategory() {
        if (useCashe) {
            return cache.groupedByCategory;
        }
        return fetchProductsGroupedByCategory();
    }

    @Override
    public Map<Boolean, List<Product>> getProductsPartitionedByVegetable() {
        if (useCashe) {
            return cache.partitionedByVegetable;
        }

        return productRepository
                .findAll()
                .stream()
                .collect(partitioningBy(Product::isVegetable));
    }

    @Override
    public EnumMap<Category, List<Product>> findMostExpensiveProductsByCategory() {
        if (useCashe) {
            return cache.groupedByCategory;
        }
        EnumMap<Category, List<Product>> productsGroupedByCategory = fetchProductsGroupedByCategory();
        return productsGroupedByCategory
                .entrySet()
                .stream()
                .collect(toMap(
                        Map.Entry::getKey,
                        entry -> entry
                                .getValue()
                                .stream()
                                .map(Product::price)
                                .max(naturalOrder())
                                .map(maxPrice -> entry
                                        .getValue()
                                        .stream()
                                        .filter(p -> p.hasPrice(maxPrice))
                                        .toList()
                                ).orElse(List.of()),
                        (a, b) -> a,
                        () -> new EnumMap<>(Category.class)
                ));
    }

    private EnumMap<Category, List<Product>> fetchProductsGroupedByCategory() {
        return productRepository
                .findAll()
                .stream()
                .collect(groupingBy(
                        Product::category,
                        () -> new EnumMap<>(Category.class),
                        toList()
                ));
    }

    private static class Cache {
        final List<Product> products;
        final EnumMap<Category, List<Product>> groupedByCategory;
        final Map<Boolean, List<Product>> partitionedByVegetable;
        final EnumMap<Category, BigDecimal> averagePriceByCategory;
        final EnumMap<Category, List<Product>> mostExpensiveByCategory;

        public Cache(List<Product> products) {
            this.products = products;
            this.groupedByCategory = products
                    .stream()
                    .collect(groupingBy(
                            Product::category,
                            () -> new EnumMap<>(Category.class),
                            toList()
                    ));
            this.partitionedByVegetable = products
                    .stream()
                    .collect(partitioningBy(Product::isVegetable));
            this.averagePriceByCategory = groupedByCategory
                    .entrySet()
                    .stream()
                    .collect(toMap(
                            Map.Entry::getKey,
                            entry -> entry
                                    .getValue()
                                    .stream()
                                    .map(product -> product.price().doubleValue())
                                    .collect(collectingAndThen(
                                            averagingDouble(Double::doubleValue),
                                            BigDecimal::valueOf
                                    )),
                            (a, b) -> a,
                            () -> new EnumMap<>(Category.class)
                    ));
            this.mostExpensiveByCategory = groupedByCategory
                    .entrySet()
                    .stream()
                    .collect(toMap(
                            Map.Entry::getKey,
                            entry -> entry
                                    .getValue()
                                    .stream()
                                    .map(Product::price)
                                    .max(naturalOrder())
                                    .map(maxPrice -> entry
                                            .getValue()
                                            .stream()
                                            .filter(p -> p.hasPrice(maxPrice))
                                            .toList()
                                    ).orElse(List.of()),
                            (a, b) -> a,
                            () -> new EnumMap<>(Category.class)
                    ));
        }
    }
}
