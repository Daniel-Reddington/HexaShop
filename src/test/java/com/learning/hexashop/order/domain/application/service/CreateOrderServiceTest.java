package com.learning.hexashop.order.domain.application.service;

import com.learning.hexashop.order.application.service.CreateOrderService;
import com.learning.hexashop.order.domain.command.CreateOrderCommand;
import com.learning.hexashop.order.domain.command.OrderItemCommand;
import com.learning.hexashop.order.domain.port.out.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateOrderServiceTest {

    @Mock
    OrderRepository repository;

    @InjectMocks
    CreateOrderService service;

    @Test
    void should_create_order_with_item(){
        var command = new CreateOrderCommand(List.of(
                new OrderItemCommand(UUID.randomUUID(), 100, 2),
                new OrderItemCommand(UUID.randomUUID(), 50, 1)
        ));

        when(repository.save(any())).thenAnswer(i -> i.getArgument(0));

        var order =  service.createOrder(command);

        assertEquals(2, order.getLines().size());
        assertEquals(250, order.total().intValue());
    }
}
