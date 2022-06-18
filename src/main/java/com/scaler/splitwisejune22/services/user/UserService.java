package com.scaler.splitwisejune22.services.user;

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

    public User updateProfile(Long userId, String newPassword) {
        User user = userRepository.findUserById(userId);
        user.setHashedPassword(newPassword);
        User savedUser = userRepository.save(user);
        return savedUser;
    }
}
