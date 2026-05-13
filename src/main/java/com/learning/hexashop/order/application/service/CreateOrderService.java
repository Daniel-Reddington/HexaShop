package com.learning.hexashop.order.application.service;

import com.learning.hexashop.order.domain.command.CreateOrderCommand;
import com.learning.hexashop.order.domain.model.Order;
import com.learning.hexashop.order.domain.port.in.CreateOrderUseCase;
import com.learning.hexashop.order.domain.port.out.OrderRepository;
import com.learning.hexashop.product.domain.model.Price;
import com.learning.hexashop.product.domain.model.ProductId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateOrderService implements CreateOrderUseCase {

    private final OrderRepository repository;

    @Override
    public Order createOrder(CreateOrderCommand command) {
        var order = Order.create();

        command.items().forEach(item ->
                order.addProduct(
                        ProductId.of(item.productId()),
                        Price.of(item.price()),
                        item.quantity())
        );

        order.validate();
        
        return repository.save(order);
    }
}
