package com.scaler.splitwisejune22.commandsOld.registry;

import com.scaler.splitwisejune22.commandsOld.Command;

public interface CommandRegistry {

    void registerCommand(Command command);

    Command getCommand(String commandLine);

    void removeCommand(Command command);

    boolean executeCommandLine(String commandLine);

//    // Upd
//    String suggestCommandBasedOnPrefix(String commandPrefix);
}
