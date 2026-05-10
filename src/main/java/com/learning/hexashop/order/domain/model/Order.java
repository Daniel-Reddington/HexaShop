package com.learning.hexashop.order.domain.model;

import com.learning.hexashop.product.domain.model.Product;

import java.util.List;

public class Order {

    private final List<OrderLine> lines;

    private Order(List<OrderLine> lines) {
        this.lines = lines;
    }

    public static Order create() {
        return new Order(List.of());
    }

    public List<OrderLine> getProducts() {
        return lines;
    }}
}
