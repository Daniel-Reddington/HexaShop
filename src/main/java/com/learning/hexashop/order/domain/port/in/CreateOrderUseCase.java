package com.learning.hexashop.order.domain.port.in;

import com.learning.hexashop.order.domain.command.CreateOrderCommand;
import com.learning.hexashop.order.domain.model.Order;

public interface CreateOrderUseCase {
    Order createOrder(CreateOrderCommand command);
}
