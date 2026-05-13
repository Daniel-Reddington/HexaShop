package com.learning.hexashop.order.domain.command;

import java.util.UUID;

public record OrderItemCommand(
        UUID productId,
        double price,
        int quantity
) {
}
