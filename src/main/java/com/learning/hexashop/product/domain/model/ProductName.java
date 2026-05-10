package com.learning.hexashop.product.domain.model;

public record ProductName(String value) {

    public ProductName{
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Product name cannot be empty");
        }
    }

}
