package com.learning.hexashop.product.domain.model;

import java.math.BigDecimal;

public record Price(BigDecimal value) {

    public Price{
        if (value == null || value.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price must be positive");
        }
    }

    public static Price of(BigDecimal value) {
        return new Price(value);
    }

    public static Price of(double value) {
        return new Price(new BigDecimal(value));
    }

}
