package com.scaler.splitwisejune22.services.passwordencoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BCryptEncoder implements PasswordEncoder {
    private BCryptPasswordEncoder springBcryptEncoder = new BCryptPasswordEncoder();

    @Override
    public String getEncodedPassword(String realPassword) {
        return springBcryptEncoder.encode(realPassword);
    }

    @Override
    public boolean matches(String realPassword, String hashedPassword) {
        return springBcryptEncoder.matches(realPassword, hashedPassword);
    }
}
