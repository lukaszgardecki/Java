package com.example.przyklad_4.domain.product.port;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
interface ProductJpaRepository {

    Optional<ProductEntity> findByUuid(UUID productUUID);

    List<ProductEntity> findAllByUuidIn(Set<UUID> productList);

    List<ProductEntity> findALlByIdIn(Set<Long> productList);
}
