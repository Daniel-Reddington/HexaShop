package com.learning.hexashop.product.adapter.in.web.dto;

import com.learning.hexashop.product.domain.command.CreateProductCommand;

public record CreateProductRequest(String name, double price) {

    public CreateProductCommand toCommand(){
        return new CreateProductCommand(name, price);
    }
}
