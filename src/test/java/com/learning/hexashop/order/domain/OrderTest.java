package com.learning.hexashop.order.domain;

import com.learning.hexashop.order.domain.model.Order;
import com.learning.hexashop.product.domain.model.Price;
import com.learning.hexashop.product.domain.model.ProductId;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


public class OrderTest {

    @Test
    void should_create_empty_order(){
        Order order = Order.create();

        assertNotNull(order);
        assertTrue(order.getLines().isEmpty());
    }

    void should_add_product_to_order(){
        Order order = Order.create();

        var productId = ProductId.generate();
        var price = Price.of(new BigDecimal(100));

        order.add(productId, price, 2);

        assertEquals(2, order.getLines().size());
    }
}
