package com.learning.hexashop.product.domain.port.in;

import com.learning.hexashop.product.domain.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GetProductsUseCase {

    Page<Product> getProducts(Pageable pageable);
}
