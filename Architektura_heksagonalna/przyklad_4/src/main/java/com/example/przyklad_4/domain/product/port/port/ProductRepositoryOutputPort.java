package com.example.przyklad_4.domain.product.port.port;

import com.example.przyklad_4.domain.product.port.ProductEntity;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface ProductRepositoryOutputPort {
    ProductEntity getByUUID(UUID productUUID);
    List<ProductEntity> findAllByUUIDin(Set<UUID> productList);
    List<ProductEntity> findAllByIdIn(Set<Long> productList);
}
