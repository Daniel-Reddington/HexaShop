package com.learning.hexashop.order.domain.model;

import java.util.UUID;

public record OrderId(UUID value) {

    public OrderId {
        if(value == null){
            throw new NullPointerException("OrderId cannot be null");
        }
    }

    public static OrderId generate(){
        return new OrderId(UUID.randomUUID());
    }

    public static OrderId of(UUID value){
        return new OrderId(value);
    }
}
