package com.learning.hexashop.product.adapter.in.web.dto;

import com.learning.hexashop.product.domain.model.Product;

public record ProductResponse(String id, String name, double price) {

    public static ProductResponse from(Product product) {
        return new ProductResponse(product.getId().toString(), product.getName(), product.getPrice());
    }
}
