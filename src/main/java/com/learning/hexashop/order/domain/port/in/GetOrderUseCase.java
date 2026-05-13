package com.learning.hexashop.order.domain.port.in;

import com.learning.hexashop.order.domain.model.Order;

import java.util.UUID;

public interface GetOrderUseCase {
    Order getOrder(UUID orderId);
}
