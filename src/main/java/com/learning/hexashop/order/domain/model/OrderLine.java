package com.learning.hexashop.order.domain.model;

import com.learning.hexashop.product.domain.model.Price;
import com.learning.hexashop.product.domain.model.ProductId;

public class OrderLine {

    private final ProductId productId;
    private final Price price;
    private final int quantity;

    public  OrderLine(ProductId productId, Price price, int quantity) {

        if(quantity < 0) {
            throw new IllegalArgumentException("quantity must be positive");
        }
        
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
    }
}
