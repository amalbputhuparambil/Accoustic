package com.brocamp.AcousticAlchemy.dto;

import com.brocamp.AcousticAlchemy.model.OrderDetails;
import com.brocamp.AcousticAlchemy.model.Product;
import lombok.Data;

@Data
public class OrderProductsDTO {
    private long id;
    private OrderDetails orderDetails;
    private Product product;
    private long quantity;
    private double individualRate;
    private double totalRate;
}
