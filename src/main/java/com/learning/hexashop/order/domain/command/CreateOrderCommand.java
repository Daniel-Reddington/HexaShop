package com.learning.hexashop.order.domain.command;

import java.util.List;

public record CreateOrderCommand(
        List<OrderItemCommand> items
) {
}
