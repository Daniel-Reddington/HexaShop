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

    @Test
    void should_add_product_to_order(){
        Order order = Order.create();

        var productId = ProductId.generate();
        var price = Price.of(100);

        order.addProduct(productId, price, 2);

        assertEquals(1, order.getLines().size());
    }

    @Test
    void should_not_allow_negative_quantity(){
        Order order = Order.create();
        var productId = ProductId.generate();
        var price = Price.of(100);

        assertThrows(IllegalArgumentException.class, () -> order.addProduct(productId, price, -1));
    }

    @Test
    void shloud_calculate_total_of_order(){
        Order order = Order.create();
        var productId1 = ProductId.generate();
        var productId2 = ProductId.generate();

        order.addProduct(productId1, Price.of(100), 2);
        order.addProduct(productId2, Price.of(50), 1);

        var total = order.total();

        assertEquals(BigDecimal.valueOf(250), total);
    }
}
