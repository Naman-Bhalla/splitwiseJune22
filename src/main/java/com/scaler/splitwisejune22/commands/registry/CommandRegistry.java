package com.scaler.splitwisejune22.commands.registry;

import com.scaler.splitwisejune22.commands.Command;

public interface CommandRegistry {

    void registerCommand(Command command);

    Command getCommand(String commandLine);

    void removeCommand(Command command);

    boolean executeCommandLine(String commandLine);

//    // Upd
//    String suggestCommandBasedOnPrefix(String commandPrefix);
}
