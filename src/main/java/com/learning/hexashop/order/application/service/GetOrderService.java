package com.learning.hexashop.order.application.service;

import com.learning.hexashop.order.domain.exception.InvalidOrderException;
import com.learning.hexashop.order.domain.model.Order;
import com.learning.hexashop.order.domain.model.OrderId;
import com.learning.hexashop.order.domain.port.in.GetOrderUseCase;
import com.learning.hexashop.order.domain.port.out.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class GetOrderService implements GetOrderUseCase {

    private final OrderRepository repository;

    @Override
    public Order getOrder(UUID orderId) {
        return repository.findById(OrderId.of(orderId))
                .orElseThrow(() -> new InvalidOrderException("Order Not Found"));
    }
}
