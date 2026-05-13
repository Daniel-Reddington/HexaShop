package com.learning.hexashop.order.domain.application.service;

import com.learning.hexashop.order.application.service.AddProductService;
import com.learning.hexashop.order.domain.command.AddProductCommand;
import com.learning.hexashop.order.domain.model.Order;
import com.learning.hexashop.order.domain.model.OrderId;
import com.learning.hexashop.order.domain.port.out.OrderRepository;
import com.learning.hexashop.product.domain.port.out.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AddProductServiceTest {

    @Mock
    private OrderRepository repository;

    @InjectMocks
    private AddProductService service;

    @Test
    void should_add_product_to_existing_order(){

        var orderId = OrderId.generate();

        var existingOrder = Order.create();

        when(repository.findById(orderId)).thenReturn(Optional.of(existingOrder));
        when(repository.save(any())).thenAnswer(i -> i.getArgument(0));

        var command = new AddProductCommand(
                orderId.value(),
                UUID.randomUUID(),
                100,
                2
        );

        var result =  service.addProduct(command);

        assertEquals(1, result.getLines().size());
        verify(repository).save(existingOrder);
    }
}
