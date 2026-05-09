package com.learning.hexashop.product.domain.port.in;

import com.learning.hexashop.product.domain.model.Product;
import com.learning.hexashop.product.domain.model.ProductId;

import java.util.Optional;

public interface GetProductByIdUseCase {

    Optional<Product> getById(ProductId id);
}
