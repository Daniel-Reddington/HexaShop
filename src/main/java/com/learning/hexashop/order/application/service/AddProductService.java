package com.learning.hexashop.order.application.service;

import com.learning.hexashop.order.domain.command.AddProductCommand;
import com.learning.hexashop.order.domain.exception.InvalidOrderException;
import com.learning.hexashop.order.domain.model.Order;
import com.learning.hexashop.order.domain.model.OrderId;
import com.learning.hexashop.order.domain.port.in.AddProductUseCase;
import com.learning.hexashop.order.domain.port.out.OrderRepository;
import com.learning.hexashop.product.domain.model.Price;
import com.learning.hexashop.product.domain.model.ProductId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AddProductService implements AddProductUseCase {

    private final OrderRepository repository;

    @Override
    public Order addProduct(AddProductCommand command) {
        var order = repository.findById(OrderId.of(command.orderId()))
                .orElseThrow(() -> new InvalidOrderException("Order not found"));

        order.addProduct(
                ProductId.of(command.productId()),
                Price.of(command.price()),
                command.quantity()
        );
        return repository.save(order);
    }
}
