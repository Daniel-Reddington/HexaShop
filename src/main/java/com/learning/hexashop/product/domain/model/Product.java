package com.learning.hexashop.product.domain.model;

import java.math.BigDecimal;

public class Product {

    private final ProductId id;
    private final ProductName name;
    private final Price price;

    public Product(ProductId id, ProductName name, Price price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public static Product create(String name, BigDecimal price) {
        return new Product(ProductId.generate(), new ProductName(name), new Price(price));
    }

    public ProductId getId() {return id;}

    public ProductName getName() {return name;}

    public Price getPrice() {return price;}

}
