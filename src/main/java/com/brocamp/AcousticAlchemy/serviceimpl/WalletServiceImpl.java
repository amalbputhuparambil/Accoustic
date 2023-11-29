package com.brocamp.AcousticAlchemy.serviceimpl;

import com.brocamp.AcousticAlchemy.enums.TransactionType;
import com.brocamp.AcousticAlchemy.model.Wallet;
import com.brocamp.AcousticAlchemy.repository.WalletRepository;
import com.brocamp.AcousticAlchemy.service.WalletService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class WalletServiceImpl implements WalletService {
    private WalletRepository walletRepository;
    @Override
    public List<Wallet> findAllByUserId(long id) {
        return walletRepository.findByUsersId(id);
    }

    @Override
    public double findSumOfWalletAmount(long id) {
        double creditAmount = walletRepository.findCreditedAmount(id);
        double debitedAmount = walletRepository.findDebitedAmount(id);
        double amountInWallet = creditAmount-debitedAmount;
        return amountInWallet;
    }

    @Override
    public void save(Wallet wallet) {
        walletRepository.save(wallet);
    }

    @Override
    public Wallet findByUserId(long userid) {
       Wallet wallet= walletRepository.findWaletByUsersId(userid);
        return wallet;
    }

    @Override
    public Boolean existWaletById(long userid) {
        Boolean value=walletRepository.existsWalletByUserId(userid);
        return value;
    }

    @Override
    public void addTransaction(long userid, Double finalAmount) {

            Wallet wallet=new Wallet();
            wallet.setTransactionType(TransactionType.CREDITED);
            wallet.setAmount(finalAmount);
            wallet.setUpdateOn(new Date());
            wallet.setUsersId(userid);
            walletRepository.save(wallet);

    }
}
