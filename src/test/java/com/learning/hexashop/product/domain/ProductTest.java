package com.learning.hexashop.product.domain;

import com.learning.hexashop.product.domain.model.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductTest {

    @Test
    void should_create_valid_product(){
        Product product = Product.create("Laptop", 1000);

        assertEquals("Laptop", product.getName());
        assertEquals(1000, product.getPrice());
    }

    @Test
    void should_fail_when_price_is_negative(){
        assertThrows(IllegalArgumentException.class, () -> Product.create("Laptop", -100));
    }

    @Test
    void should_fail_when_name_is_empty(){
        assertThrows(IllegalArgumentException.class, () -> Product.create("", 100));
    }
}
