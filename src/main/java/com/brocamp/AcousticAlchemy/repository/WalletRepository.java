package com.brocamp.AcousticAlchemy.repository;

import com.brocamp.AcousticAlchemy.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletRepository extends JpaRepository<Wallet,Long> {
    List<Wallet> findByUsersId(long id);

    @Query("select COALESCE(sum(w.amount),0) from Wallet w where w.usersId=?1")
    double findSumOfWalletAmount(long id);

    @Query("select COALESCE(sum(w.amount),0) from Wallet w where w.transactionType=0 and w.usersId=?1")
    double findCreditedAmount(long id);

    @Query("select COALESCE(sum(w.amount),0) from Wallet w where w.transactionType=1 and w.usersId=?1")
    double findDebitedAmount(long id);
@Query("select w from Wallet w where w.usersId=:userid")
    Wallet findWaletByUsersId(long userid);
    @Query("select exists (select w from Wallet w where w.usersId=:userid)")
    Boolean existsWalletByUserId(long userid);

}
