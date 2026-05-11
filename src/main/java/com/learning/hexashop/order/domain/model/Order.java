package com.learning.hexashop.order.domain.model;

import com.learning.hexashop.product.domain.model.Price;
import com.learning.hexashop.product.domain.model.ProductId;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private final List<OrderLine> lines;

    private Order(List<OrderLine> lines) {
        this.lines = lines;
    }

    public static Order create() {
        return new Order(new ArrayList<>());
    }

    public List<OrderLine> getLines() {
        return List.copyOf(lines);
    }

    public void addProduct(ProductId  productId, Price price, int quantity) {
        lines.add(new OrderLine(productId, price, quantity));
    }

    public BigDecimal total() {
        return lines.stream().map(OrderLine::total).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
