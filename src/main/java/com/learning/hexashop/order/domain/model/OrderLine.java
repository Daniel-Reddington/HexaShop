package com.learning.hexashop.order.domain.model;

import com.learning.hexashop.product.domain.model.Price;
import com.learning.hexashop.product.domain.model.ProductId;

import java.math.BigDecimal;

public class OrderLine {

    private final ProductId productId;
    private final Price price;
    private int quantity;

    public  OrderLine(ProductId productId, Price price, int quantity) {

        if(quantity < 0) {
            throw new IllegalArgumentException("quantity must be positive");
        }
        
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
    }

    public BigDecimal total() {
        return price.value().multiply(BigDecimal.valueOf(quantity));
    }

    public void increaseQuantity(int quantity) {
        if(quantity < 0) {
            throw new IllegalArgumentException("quantity must be positive");
        }
        this.quantity += quantity;
    }

    public ProductId getProductId() {
        return productId;
    }

    public Price getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

}
