package com.learning.hexashop.product.adapter.in.web.dto;

import com.learning.hexashop.product.domain.command.CreateProductCommand;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record CreateProductRequest(
        @NotBlank(message = "Product name must not be blank")
        String name,

        @Positive(message = "Price must be positive")
        double price) {

    public CreateProductCommand toCommand(){
        return new CreateProductCommand(name, price);
    }
}
