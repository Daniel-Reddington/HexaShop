package com.learning.hexashop.product.adapter.out.persistence;

import com.learning.hexashop.product.domain.model.Product;
import com.learning.hexashop.product.domain.model.ProductId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductRepositoryAdapterTest {

    @Autowired
    ProductRepositoryAdapter repository;

    @Test
    void should_save_product(){
        Product product = Product.create("Laptop", new BigDecimal("100"));

        Product saved = repository.save(product);

        assertNotNull(saved);
        assertEquals("Laptop", saved.getName().value());
        assertEquals(new BigDecimal("100"), saved.getPrice().value());
    }

    @Test
    void should_find_product_by_id(){
        Product product = repository.save(Product.create("Laptop", new BigDecimal("100")));

        Optional<Product> found = repository.findById(product.getId());
        assertTrue(found.isPresent());
        assertEquals("Laptop", found.get().getName().value());
        assertEquals(new BigDecimal("100.00"), found.get().getPrice().value());
    }

    @Test
    void should_return_empty_when_not_found(){
        ProductId fakeId = ProductId.generate();
        Optional<Product> found = repository.findById(fakeId);
        assertTrue(found.isEmpty());
    }

    @Test
    void should_find_all_products_with_pagination(){
        repository.save(Product.create("Laptop", new BigDecimal("100")));
        repository.save(Product.create("Phone", new BigDecimal("200")));
        repository.save(Product.create("Keyboard", new BigDecimal("300")));

        Page<Product> page = repository.findAll(PageRequest.of(0, 2));
        assertNotNull(page);
        assertEquals(2, page.getContent().size());
        assertEquals(3, page.getTotalElements());
    }
}
