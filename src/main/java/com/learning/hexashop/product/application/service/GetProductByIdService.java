package com.learning.hexashop.product.application.service;

import com.learning.hexashop.product.domain.model.Product;
import com.learning.hexashop.product.domain.model.ProductId;
import com.learning.hexashop.product.domain.port.in.GetProductByIdUseCase;
import com.learning.hexashop.product.domain.port.out.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetProductByIdService implements GetProductByIdUseCase {

    private final ProductRepository repository;

    @Override
    public Optional<Product> getById(ProductId id) {
        return repository.findById(id);
    }
}
