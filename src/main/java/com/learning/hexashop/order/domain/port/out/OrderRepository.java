package com.learning.hexashop.order.domain.port.out;

import com.learning.hexashop.order.domain.model.Order;
import com.learning.hexashop.order.domain.model.OrderId;

import java.util.Optional;

public interface OrderRepository {
    Order save(Order order);
    Optional<Order> findById(OrderId id);
}
