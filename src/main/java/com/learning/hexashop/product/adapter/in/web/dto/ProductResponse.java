package com.learning.hexashop.product.adapter.in.web.dto;

import com.learning.hexashop.product.domain.model.Product;

import java.math.BigDecimal;

public record ProductResponse(String id, String name, BigDecimal price) {

    public static ProductResponse from(Product product) {
        return new ProductResponse(
                product.getId().toString(),
                product.getName().value(),
                product.getPrice().value());
    }
}
