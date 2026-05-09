package com.learning.hexashop.product.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ProductEntity {

    @Id
    private UUID id;
    private String name;
    private double price;


}
