package com.learning.hexashop.product.domain;

import com.learning.hexashop.product.domain.model.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductTest {

    @Test
    void should_create_valid_product(){
        Product product = Product.create("Laptop", new BigDecimal("100"));

        assertEquals("Laptop", product.getName().value());
        assertEquals(new BigDecimal("100"), product.getPrice().value());
    }

    @Test
    void should_fail_when_price_is_negative(){
        assertThrows(IllegalArgumentException.class, () -> Product.create("Laptop", new BigDecimal("-100")));
    }

    @Test
    void should_fail_when_name_is_empty(){
        assertThrows(IllegalArgumentException.class, () -> Product.create("", new BigDecimal("100")));
    }
}
