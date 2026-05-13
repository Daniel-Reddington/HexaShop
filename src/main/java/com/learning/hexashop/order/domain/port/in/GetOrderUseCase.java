package com.learning.hexashop.order.domain.port.in;

import com.learning.hexashop.order.domain.model.Order;

public interface GetOrderUseCase {
    Order getOrder(int orderId);
}
