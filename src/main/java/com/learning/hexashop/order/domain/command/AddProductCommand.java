package com.learning.hexashop.order.domain.command;

import java.util.UUID;

public record AddProductCommand(
        UUID orderId,
        UUID productId,
        double price,
        int quantity
) {
}
