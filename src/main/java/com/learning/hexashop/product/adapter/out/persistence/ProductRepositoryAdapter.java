package com.learning.hexashop.product.adapter.out.persistence;

import com.learning.hexashop.product.adapter.out.persistence.entity.ProductEntity;
import com.learning.hexashop.product.adapter.out.persistence.mapper.ProductMapper;
import com.learning.hexashop.product.adapter.out.persistence.repository.JpaProductRepository;
import com.learning.hexashop.product.domain.model.Product;
import com.learning.hexashop.product.domain.port.out.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryAdapter implements ProductRepository {

    private final JpaProductRepository jpaProductRepository;

    @Override
    public Product save(Product product) {

        ProductEntity entity = ProductMapper.toEntity(product);
        ProductEntity savedEntity = jpaProductRepository.save(entity);

        return ProductMapper.toDomain(savedEntity);
    }
}
