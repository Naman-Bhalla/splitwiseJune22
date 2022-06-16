package com.scaler.splitwisejune22.commands;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UpdateProfileCommand implements Command {

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

    }
}
