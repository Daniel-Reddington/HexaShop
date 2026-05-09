package com.learning.hexashop.product.domain.model;

public class Product {

    private final ProductId id;
    private final String name;
    private final double price;

    public Product(ProductId id, String name, double price) {

        if (name == null ||name.isBlank()) {
            throw new IllegalArgumentException("Invalid product name");
        }

        if (price <= 0) {
            throw new IllegalArgumentException("Invalid product price");
        }

        this.id = id;
        this.name = name;
        this.price = price;
    }

    public static Product create(String name, double price) {
        return new Product(ProductId.generate(), name, price);
    }

    public ProductId getId() {return id;}

    public String getName() {return name;}

    public double getPrice() {return price;}

}
