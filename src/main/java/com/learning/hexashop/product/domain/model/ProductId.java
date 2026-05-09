package com.learning.hexashop.product.domain.model;

import java.util.UUID;

public record ProductId(UUID value) {

    public ProductId {
        if(value == null) throw new IllegalArgumentException("Product id cannot be null");

    }

    public static ProductId of(UUID value) {
        return new ProductId(value);
    }

    public static ProductId fromString(String id) {
        return new ProductId(UUID.fromString(id));
    }

    public static ProductId generate() {
        return new ProductId(UUID.randomUUID());
    }
}
