package com.learning.hexashop.product.adapter.in.web.dto;

import com.learning.hexashop.product.domain.model.Product;
import com.learning.hexashop.product.domain.model.ProductId;

public record ProductResponse(ProductId id, String name, double price) {

    public static ProductResponse from(Product product) {
        return new ProductResponse(product.getId(), product.getName(), product.getPrice());
    }
}
