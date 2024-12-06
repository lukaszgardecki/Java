package com.example.przyklad_4.domain.product.port.port;

import com.example.przyklad_4.domain.product.port.ProductEntity;

import java.util.UUID;

public interface ProductRepositoryInputPort {
    void save(ProductEntity product);
    void delete(UUID productUUID);
}
