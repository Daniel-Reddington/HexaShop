package com.learning.hexashop.product.domain.port.out;

import com.learning.hexashop.product.domain.model.Product;

public interface ProductRepository {

    Product save(Product product);
}

