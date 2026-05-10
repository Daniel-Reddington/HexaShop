package com.learning.hexashop.order.domain;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderTest {

    void should_create_empty_order(){
        Order order = Order.create();

        assertNull(order);
        assertTrue(order.getLines().isEmpty());
    }
}
