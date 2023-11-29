package com.brocamp.AcousticAlchemy.repository;

import com.brocamp.AcousticAlchemy.model.PaymentMethods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodsRepository extends JpaRepository<PaymentMethods,Long> {
}
