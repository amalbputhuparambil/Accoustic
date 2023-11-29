package com.brocamp.AcousticAlchemy.service;

import com.brocamp.AcousticAlchemy.model.PaymentMethods;

import java.util.List;

public interface PaymentMethodsService {
    List<PaymentMethods> findAllPaymentMethods();

    PaymentMethods findById(long paymentMethodsId);

    void createPaymentMethodsIfNotExists();
}
