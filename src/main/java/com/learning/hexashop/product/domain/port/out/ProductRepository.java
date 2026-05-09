package com.learning.hexashop.product.domain.port.out;

import com.learning.hexashop.product.domain.model.Product;
import com.learning.hexashop.product.domain.model.ProductId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductRepository {

    Product save(Product product);

    Optional<Product> findById(ProductId id);

    Page<Product> findAll(Pageable pageable);
}

