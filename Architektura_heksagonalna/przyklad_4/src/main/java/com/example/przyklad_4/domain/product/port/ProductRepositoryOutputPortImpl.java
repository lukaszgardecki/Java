package com.example.przyklad_4.domain.product.port;

import com.example.przyklad_4.domain.product.port.port.ProductRepositoryOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.UUID;


@RequiredArgsConstructor
class ProductRepositoryOutputPortImpl implements ProductRepositoryOutputPort {
    private final ProductJpaRepository productJpaRepository;

    @Override
    public ProductEntity getByUUID(UUID productUUID) {
        return productJpaRepository.findByUuid(productUUID)
                .orElseThrow(EntityNotFoundException::new);
    }
    @Override
    public List<ProductEntity> findAllByUUIDin(Set<UUID> productList) {
        return productJpaRepository.findAllByUuidIn(productList);
    }
    @Override
    public List<ProductEntity> findAllByIdIn(Set<Long> productList) {
        return productJpaRepository.findALlByIdIn(productList);
    }
}
