package com.learning.hexashop.product.domain.model;

public class Product {
    private final String name;
    private final double price;

    public Product(String name, double price) {

        if (name == null ||name.isBlank()) {
            throw new IllegalArgumentException("Invalid product name");
        }

        if (price <= 0) {
            throw new IllegalArgumentException("Invalid product price");
        }

        this.name = name;
        this.price = price;
    }

    public String getName() {return name;}

    public double getPrice() {return price;}

}
