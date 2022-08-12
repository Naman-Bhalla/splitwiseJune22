package com.scaler.splitwisejune22.commands;

import com.scaler.splitwisejune22.commands.RegisterUserCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class CommandRegistry {
    private List<Command> commands = new ArrayList<>();

    @Autowired
    public CommandRegistry(RegisterUserCommand registerUserCommand) {
        commands.add(registerUserCommand);
    }

    public boolean registerCommand(Command command) {
        if (commands.contains(command)) { // O(N)
            return false;
        }

        commands.add(command);
        return true;
    }

    public boolean unregister(Command command) {
        commands.remove(command);
        return true;
    }

    public void execute(String input) {
        for (Command command: commands) {
            if (command.canExecute(input)) {
                command.execute(input);
                return;
            }
        }
    }
}
