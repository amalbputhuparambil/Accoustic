package com.brocamp.AcousticAlchemy.model;

import com.brocamp.AcousticAlchemy.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
@Entity
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long usersId;
    private double amount;
    private TransactionType transactionType;
    private Date updateOn;


}
