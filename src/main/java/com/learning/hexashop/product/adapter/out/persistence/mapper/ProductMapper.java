package com.learning.hexashop.product.adapter.out.persistence.mapper;

import com.learning.hexashop.product.adapter.out.persistence.entity.ProductEntity;
import com.learning.hexashop.product.domain.model.Product;
import com.learning.hexashop.product.domain.model.ProductId;

public class ProductMapper {

    public static ProductEntity toEntity(Product product) {
        return new ProductEntity(product.getId().value(), product.getName(), product.getPrice());
    }

    public static Product toDomain(ProductEntity entity) {
        return new Product(ProductId.of(entity.getId()), entity.getName(), entity.getPrice());
    }
}
