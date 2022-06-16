package com.scaler.splitwisejune22.controllers;

import com.scaler.splitwisejune22.dtos.RegisterUserRequestDto;
import com.scaler.splitwisejune22.dtos.RegisterUserResponseDto;
import com.scaler.splitwisejune22.dtos.UpdateProfileRequestDto;
import com.scaler.splitwisejune22.dtos.UpdateProfileResponseDto;
import com.scaler.splitwisejune22.models.User;
import com.scaler.splitwisejune22.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public RegisterUserResponseDto registerUser(RegisterUserRequestDto request) {
        User user = userService.registerUser(
                request.getPhoneNumber(),
                request.getPassword(),
                request.getUsername()
        );

        RegisterUserResponseDto registerUserResponseDto = new RegisterUserResponseDto();
        registerUserResponseDto.setUser(user);
        return registerUserResponseDto;
    }

    public UpdateProfileResponseDto updateProfile(UpdateProfileRequestDto request) {
        User user = userService.updateProfile(
                request.getUserId(),
                request.getNewPassword()
        );

        UpdateProfileResponseDto response = new UpdateProfileResponseDto();
        response.setUser(user);
        return response;
    }
}
