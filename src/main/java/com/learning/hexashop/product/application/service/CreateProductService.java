package com.learning.hexashop.product.application.service;

import com.learning.hexashop.product.application.CreateProductRequest;
import com.learning.hexashop.product.domain.model.Product;
import com.learning.hexashop.product.domain.port.in.CreateProductUseCase;
import com.learning.hexashop.product.domain.port.out.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateProductService implements CreateProductUseCase {

    private final ProductRepository repository;

    @Override
    public Product create(CreateProductRequest request) {
        Product product = new Product(request.name(), request.price());
        return repository.save(product);
    }
}
