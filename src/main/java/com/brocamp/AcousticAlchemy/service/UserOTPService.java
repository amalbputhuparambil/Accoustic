package com.brocamp.AcousticAlchemy.service;

import com.brocamp.AcousticAlchemy.model.UserOTP;

public interface UserOTPService {
    void saveOrUpdate(UserOTP userOTP);

    boolean existsByEmail(String email);

    UserOTP findByEmail(String email);
}
