package com.learning.hexashop.product.application.service;

import com.learning.hexashop.product.domain.model.Product;
import com.learning.hexashop.product.domain.port.in.GetProductsUseCase;
import com.learning.hexashop.product.domain.port.out.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetProductsService implements GetProductsUseCase {

    private final ProductRepository repository;

    @Override
    public Page<Product> getProducts(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
