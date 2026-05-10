package com.learning.hexashop.product.adapter.out.persistence.mapper;

import com.learning.hexashop.product.adapter.out.persistence.entity.ProductEntity;
import com.learning.hexashop.product.domain.model.Price;
import com.learning.hexashop.product.domain.model.Product;
import com.learning.hexashop.product.domain.model.ProductId;
import com.learning.hexashop.product.domain.model.ProductName;

import java.math.BigDecimal;

public class ProductMapper {

    public static ProductEntity toEntity(Product product) {
        return new ProductEntity(
                product.getId().value(),
                product.getName().value(),
                product.getPrice().value());
    }

    public static Product toDomain(ProductEntity entity) {
        return new Product(
                ProductId.of(entity.getId()),
                new ProductName(entity.getName()),
                new Price(entity.getPrice()));
    }
}
