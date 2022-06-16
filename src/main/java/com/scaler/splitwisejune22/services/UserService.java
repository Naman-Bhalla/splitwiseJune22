package com.scaler.splitwisejune22.services;

import com.scaler.splitwisejune22.models.User;
import com.scaler.splitwisejune22.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User registerUser(String phoneNUmber,
                             String password,
                             String username) {
        User user = new User();
        user.setUsername(username);
        user.setPhoneNumber(phoneNUmber);
        user.setHashedPassword(password);

        User user1 = userRepository.save(user);

        return user1;
    }
}
