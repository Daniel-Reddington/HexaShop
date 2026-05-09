package com.learning.hexashop.product.application.service;

import com.learning.hexashop.product.domain.command.CreateProductCommand;
import com.learning.hexashop.product.domain.model.Product;
import com.learning.hexashop.product.domain.port.in.CreateProductUseCase;
import com.learning.hexashop.product.domain.port.out.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateProductService implements CreateProductUseCase {

    private final ProductRepository repository;

    @Override
    public Product create(CreateProductCommand command) {
        Product product = Product.create(command.name(), command.price());
        return repository.save(product);
    }
}
