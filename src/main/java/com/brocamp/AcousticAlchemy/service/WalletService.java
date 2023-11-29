package com.brocamp.AcousticAlchemy.service;

import com.brocamp.AcousticAlchemy.model.Wallet;

import java.util.List;

public interface WalletService {
    List<Wallet> findAllByUserId(long id);

    double findSumOfWalletAmount(long id);

    void save(Wallet wallet);

    Wallet findByUserId(long userid);

    Boolean existWaletById(long userid);

    void addTransaction(long userid, Double finalAmount);
}
