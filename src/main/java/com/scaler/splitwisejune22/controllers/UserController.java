package com.scaler.splitwisejune22.controllers;

import com.scaler.splitwisejune22.dtos.RegisterUserRequestDto;
import com.scaler.splitwisejune22.dtos.RegisterUserResponseDto;
import com.scaler.splitwisejune22.dtos.UpdateProfileRequestDto;
import com.scaler.splitwisejune22.dtos.UpdateProfileResponseDto;
import com.scaler.splitwisejune22.models.User;
import com.scaler.splitwisejune22.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // /users/get/{id} -> @PathVariable
    @PostMapping("/users/register")
    public RegisterUserResponseDto registerUser(@RequestBody RegisterUserRequestDto request) {
        User user = userService.registerUser(
                request.getPhoneNumber(),
                request.getPassword(),
                request.getUsername()
        );

        RegisterUserResponseDto registerUserResponseDto = new RegisterUserResponseDto();
        registerUserResponseDto.setUser(user);
        return registerUserResponseDto;
    }

    @PutMapping("/users/update")
    public UpdateProfileResponseDto updateProfile(@RequestBody UpdateProfileRequestDto request) {
        User user = userService.updateProfile(
                request.getUserId(),
                request.getNewPassword()
        );

        UpdateProfileResponseDto response = new UpdateProfileResponseDto();
        response.setUser(user);
        return response;
    }

}
