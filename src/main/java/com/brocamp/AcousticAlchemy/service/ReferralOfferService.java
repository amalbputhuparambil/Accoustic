package com.brocamp.AcousticAlchemy.service;

import com.brocamp.AcousticAlchemy.model.ReferralOffer;

public interface ReferralOfferService {
    void saveReferral(long id, String token,String email);

    ReferralOffer findByReferralCode(String token);

    void addReferralAmount(String email);

    boolean existsByEmail(String email);

    ReferralOffer findBySenderMail(String email);

    void update(ReferralOffer referralOffer);
}
