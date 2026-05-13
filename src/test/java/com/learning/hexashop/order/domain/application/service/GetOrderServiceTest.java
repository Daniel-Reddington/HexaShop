package com.learning.hexashop.order.domain.application.service;

import com.learning.hexashop.order.application.service.GetOrderService;
import com.learning.hexashop.order.domain.model.Order;
import com.learning.hexashop.order.domain.model.OrderId;
import com.learning.hexashop.order.domain.port.out.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GetOrderServiceTest {

    @Mock
    OrderRepository repository;

    @InjectMocks
    GetOrderService service;

    @Test
    void should_get_order(){
        var orderId = OrderId.generate();
        var order = Order.create();

        when(repository.findById(orderId)).thenReturn(Optional.of(order));
        var result = service.getOrder(orderId.value());

        assertNotNull(result);
    }
}
