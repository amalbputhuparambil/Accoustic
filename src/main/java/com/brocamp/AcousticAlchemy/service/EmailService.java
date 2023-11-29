package com.brocamp.AcousticAlchemy.service;

import jakarta.mail.MessagingException;

import java.io.UnsupportedEncodingException;


public interface EmailService {

    String sendSimpleMail(String email, String otp);

    void sendReferralLink(String email, String referralLink) throws MessagingException, UnsupportedEncodingException;
}
