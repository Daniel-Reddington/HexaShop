package com.learning.hexashop.product.domain.port.in;

import com.learning.hexashop.product.application.CreateProductRequest;
import com.learning.hexashop.product.domain.model.Product;

public interface CreateProductUseCase {
    Product create(CreateProductRequest request);
}
