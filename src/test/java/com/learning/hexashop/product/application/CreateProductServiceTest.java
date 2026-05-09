package com.learning.hexashop.product.application;

import com.learning.hexashop.product.application.service.CreateProductService;
import com.learning.hexashop.product.domain.model.Product;
import com.learning.hexashop.product.domain.command.CreateProductCommand;
import com.learning.hexashop.product.domain.port.out.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateProductServiceTest {

    @Mock
    ProductRepository repository;

    @InjectMocks
    CreateProductService service;

    @Test
    void should_create_product(){

        CreateProductCommand command = new CreateProductCommand("Phone",100);

        when(repository.save(any(Product.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        Product product = service.create(command);

        assertNotNull(product);
        assertEquals("Phone", product.getName());
        assertEquals(100, product.getPrice());
        assertNotNull(product.getId());

        verify(repository).save(any(Product.class));

    }
}
