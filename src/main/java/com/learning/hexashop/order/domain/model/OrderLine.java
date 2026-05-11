package com.learning.hexashop.order.domain.model;

import com.learning.hexashop.order.domain.exception.InvalidOrderException;
import com.learning.hexashop.product.domain.model.Price;
import com.learning.hexashop.product.domain.model.ProductId;

import java.math.BigDecimal;

public class OrderLine {

    private final ProductId productId;
    private final Price price;
    private int quantity;

    public  OrderLine(ProductId productId, Price price, int quantity) {
        validateQuantity(quantity);
        
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
    }

    public BigDecimal total() {
        return price.value().multiply(BigDecimal.valueOf(quantity));
    }

    public void increaseQuantity(int quantity) {
        validateQuantity(quantity);
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

    public void validateQuantity(int quantity) {
        if(quantity < 0) {
            throw new InvalidOrderException("quantity must be positive");
        }
    }

}
