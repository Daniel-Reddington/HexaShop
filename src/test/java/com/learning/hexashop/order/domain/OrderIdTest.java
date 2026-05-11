package com.learning.hexashop.order.domain;

import com.learning.hexashop.order.domain.model.OrderId;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OrderIdTest {

    @Test
    void should_generate_order_id() {
        var id = OrderId.generate();
        assertNotNull(id);
    }

    @Test
    void should_create_order_id_from_uuid() {
        var uuid = java.util.UUID.randomUUID();
        var id = OrderId.of(uuid);
        assertNotNull(id);
    }
}
