package com.learning.hexashop.order.domain.port.in;

import com.learning.hexashop.order.domain.command.AddProductCommand;
import com.learning.hexashop.order.domain.model.Order;

public interface AddProductUseCase {

    Order addProduct(AddProductCommand command);
}
