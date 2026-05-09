package com.learning.hexashop.product.application;

import com.learning.hexashop.product.domain.model.Product;
import com.learning.hexashop.product.domain.port.out.ProductRepository;

public class InMemoryProductRepository implements ProductRepository {

    @Override
    public Product save(Product product) {
        return product;
    }
}
