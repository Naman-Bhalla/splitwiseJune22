package com.scaler.splitwisejune22;

import com.scaler.splitwisejune22.commands.RegisterUserCommand;
import com.scaler.splitwisejune22.commands.UpdateProfileCommand;
import com.scaler.splitwisejune22.commands.registry.CommandRegistry;
import com.scaler.splitwisejune22.commands.registry.CommandRegistryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SplitwiseJune22Application implements CommandLineRunner {
    @Autowired
    private CommandRegistry commandRegistry;
    @Autowired
    private RegisterUserCommand registerUserCommand;
    @Autowired
    private UpdateProfileCommand updateProfileCommand;

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseJune22Application.class, args);
    }

    @Override
    public void run(String[] args) throws Exception {
        commandRegistry.registerCommand(registerUserCommand);
        commandRegistry.registerCommand(updateProfileCommand);

        String input = "u1 UpdateProfile robinchwan";

        commandRegistry.executeCommandLine(input);
//        while (true) {
//            String input = "INPUT FROM COMMAND LINE";
//
//            commandRegistry.executeCommandLine(input);
//        }
    }
}
