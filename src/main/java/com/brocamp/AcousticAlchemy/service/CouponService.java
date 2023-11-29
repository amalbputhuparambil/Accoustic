package com.brocamp.AcousticAlchemy.service;

import com.brocamp.AcousticAlchemy.dto.CouponDTO;
import com.brocamp.AcousticAlchemy.model.Coupon;

import java.time.LocalDate;
import java.util.List;

public interface CouponService {
    void saveCoupon(CouponDTO couponDTO) throws Exception;

    List<Coupon> findActiveCoupon() throws Exception;

    void activateCoupon(long id);

    void deactivateCoupon(long id);

    void deleteCoupon(long id);

    Coupon findById(long couponId);

    List<Coupon> findCurrentCoupons(Double cartTotal, LocalDate date);

    void updateCoupon(CouponDTO couponDTO) throws Exception;

    Double checkCouponApplicableAMount(long couponId, double cartTotal);
}
