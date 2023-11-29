package com.brocamp.AcousticAlchemy.dto;

import com.brocamp.AcousticAlchemy.model.Product;
import com.brocamp.AcousticAlchemy.model.Users;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShoppingCartDTO {
    private long id;
    private Users users;
    private Product product;
    private long quantity;
    private double individualRate;
    private double totalRate;
}
