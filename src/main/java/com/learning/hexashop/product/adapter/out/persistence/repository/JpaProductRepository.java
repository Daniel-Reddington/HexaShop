package com.learning.hexashop.product.adapter.out.persistence.repository;

import com.learning.hexashop.product.adapter.out.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaProductRepository extends JpaRepository<ProductEntity, UUID> {
}
