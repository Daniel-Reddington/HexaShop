package com.learning.hexashop.product.domain.port.in.usecase;

import com.learning.hexashop.product.domain.model.Product;
import com.learning.hexashop.product.domain.port.in.CreateProductCommand;

public interface CreateProductUseCase {
    Product create(CreateProductCommand command);
}
