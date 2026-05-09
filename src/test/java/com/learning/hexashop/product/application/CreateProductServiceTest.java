package com.learning.hexashop.product.application;

import com.learning.hexashop.product.application.service.CreateProductService;
import com.learning.hexashop.product.domain.model.Product;
import com.learning.hexashop.product.domain.port.in.CreateProductUseCase;
import com.learning.hexashop.product.domain.port.out.ProductRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class CreateProductServiceTest {

    @Test
    void should_create_product(){

        ProductRepository repository = new InMemoryProductRepository();
        CreateProductUseCase useCase = new CreateProductService(repository);
        CreateProductRequest command = new CreateProductRequest("Phone",100);
        Product product = useCase.create(command);

        assertNotNull(product);
        assertEquals("Phone", product.getName());
        assertEquals(100, product.getPrice());

    }
}
