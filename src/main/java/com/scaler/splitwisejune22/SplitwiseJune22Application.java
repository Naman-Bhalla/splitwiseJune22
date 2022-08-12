package com.scaler.splitwisejune22;

import com.scaler.splitwisejune22.commands.CommandRegistry;
import com.scaler.splitwisejune22.commands.RegisterUserCommand;
import com.scaler.splitwisejune22.commandsOld.Command;
import com.scaler.splitwisejune22.commandsOld.UpdateProfileCommand;
import com.scaler.splitwisejune22.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@EnableJpaAuditing
public class SplitwiseJune22Application {
//    @Autowired
//    private CommandRegistry commandRegistry;
//    @Autowired
//    private RegisterUserCommand registerUserCommand;
//    @Autowired
//    private UpdateProfileCommand updateProfileCommand;

//    @Autowired
//    private RegisterUserCommand registerUserCommand;

    @Autowired
    private CommandRegistry commandRegistry;

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseJune22Application.class, args);
    }

//    @Override
//    public void run(String[] args) throws Exception {
//        commandRegistry.registerCommand(registerUserCommand);
//        commandRegistry.registerCommand(updateProfileCommand);
//
////        String input = "Register namanbhalla 999 password";
//        String input = "5 UpdateProfile strongpassword";
//        commandRegistry.executeCommandLine(input);
////        while (true) {
////            String input = "INPUT FROM COMMAND LINE";
////
////            commandRegistry.executeCommandLine(input);
////        }
//    }

//    @Override
//    public void run(String[] args) throws Exception {
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//            String input = scanner.nextLine();
//
//            commandRegistry.execute(input);
//        }
//    }
}
