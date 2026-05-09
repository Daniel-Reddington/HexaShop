package com.learning.hexashop.product.domain.port.in;

import com.learning.hexashop.product.domain.model.Product;

public interface CreateProductUseCase {
    Product create(CreateProductCommand command);
}
