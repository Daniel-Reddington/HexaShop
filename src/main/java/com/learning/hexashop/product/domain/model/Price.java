package com.learning.hexashop.product.domain.model;

import java.math.BigDecimal;

public record Price(BigDecimal value) {

    public Price{
        if (value == null || value.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price must be positive");
        }
    }

}
