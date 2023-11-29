package com.brocamp.AcousticAlchemy.service;

import com.brocamp.AcousticAlchemy.dto.OfferDTO;
import com.brocamp.AcousticAlchemy.model.Offer;

import java.util.List;

public interface OfferService {
    List<Offer> findAllOffers();

    Offer SaveOffer(OfferDTO offerDTO);

    Offer findById(long id);

    Offer update(Offer offer);

    void disable(long id);

    void enable(long id);

    void deleteOffer(long id);
}
