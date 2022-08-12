package com.scaler.splitwisejune22.commandsOld;

import com.scaler.splitwisejune22.controllers.UserController;
import com.scaler.splitwisejune22.dtos.UpdateProfileRequestDto;
import com.scaler.splitwisejune22.dtos.UpdateProfileResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UpdateProfileCommand implements Command {
    private UserController userController;

    @Autowired
    public UpdateProfileCommand(UserController userController) {
        this.userController = userController;
    }

    @Override
    public boolean parse(String commandLine) {
        List<String> commandTokens = Arrays.stream(commandLine.split(" ")).toList();

        if (commandTokens.size() != 3) {
            System.out.println("This is not a UpdateProfile command");
            return false;
        }

        if (!commandTokens.get(1).equalsIgnoreCase(CommandKeywords.UPDATE_PROFILE_COMMAND)) {
            System.out.println("This is not a UpdateProfile command");
            return false;
        }

        System.out.println("This is a UpdateProfile command");
        return true;
    }

    @Override
    public void execute(String commandLine) {
        List<String> commandTokens = Arrays.stream(commandLine.split(" ")).toList();
        Long userId = Long.parseLong(commandTokens.get(0));
        String newPassword = commandTokens.get(2);

        UpdateProfileRequestDto request = new UpdateProfileRequestDto();
        request.setNewPassword(newPassword);
        request.setUserId(userId);

        UpdateProfileResponseDto response = userController.updateProfile(request);

        System.out.println(response.getUser());
    }
}
