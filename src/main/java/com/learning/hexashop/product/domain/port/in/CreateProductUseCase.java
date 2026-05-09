package com.learning.hexashop.product.domain.port.in;

import com.learning.hexashop.product.domain.model.Product;
import com.learning.hexashop.product.domain.command.CreateProductCommand;

public interface CreateProductUseCase {
    Product create(CreateProductCommand command);
}
