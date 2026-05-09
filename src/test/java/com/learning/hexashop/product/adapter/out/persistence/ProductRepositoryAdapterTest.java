package com.learning.hexashop.product.adapter.out.persistence;

import com.learning.hexashop.product.domain.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ProductRepositoryAdapterTest {

    @Autowired
    ProductRepositoryAdapter repository;

    @Test
    void should_save_product(){
        Product product = new Product("Laptop", 100);

        Product saved = repository.save(product);

        assertNotNull(saved);
        assertEquals("Laptop", saved.getName());
        assertEquals(100, saved.getPrice());
    }
}
