package com.scaler.splitwisejune22.commands;

public interface Command {

    /**
     * Returns true if the commandLine
     * input is relevant for the current command.
     * Else returns false
     * @param commandLine
     * @return
     */
    boolean parse(String commandLine);

    void execute(String commandLine);
}
