package com.scaler.splitwisejune22.commands.registry;

import com.scaler.splitwisejune22.commands.Command;
import com.scaler.splitwisejune22.commands.CommandKeywords;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommandRegistryImpl implements CommandRegistry {
    private List<Command> commands = new ArrayList<>();

    @Override
    public void registerCommand(Command command) {
        commands.add(command);
    }

    // Register avbajg  122 skhkdhw  ykjhdjhbdnswd kwdkhyw
    @Override
    public Command getCommand(String commandLine) {
        for (Command command: commands) {
            if (command.parse(commandLine)) {
                return command;
            }
        }
        return null;
    }

    @Override
    public void removeCommand(Command command) {
        commands.remove(command);
    }

    @Override
    public boolean executeCommandLine(String commandLine) {
        for (Command command: commands) {
            if (command.parse(commandLine)) {
                command.execute(commandLine);
                return true;
            }
        }
        return false;
    }
}
