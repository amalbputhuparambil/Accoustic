package com.brocamp.AcousticAlchemy.dto;

import com.brocamp.AcousticAlchemy.model.Address;
import com.brocamp.AcousticAlchemy.model.OrderProducts;
import com.brocamp.AcousticAlchemy.model.PaymentMethods;
import com.brocamp.AcousticAlchemy.model.Users;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderDetailsDTO {
    private long id;
    private String orderStatus;
    private Date orderDate;
    private Date deliveryDate;
    private double orderAmount;
    private Users users;
    private long addressId;
    private long paymentMethodsId;
    private Address address;
    private PaymentMethods paymentMethods;
    private List<OrderProducts> orderProducts;
    private long couponId;
    private double discount;
    private double finalAmount;
}
