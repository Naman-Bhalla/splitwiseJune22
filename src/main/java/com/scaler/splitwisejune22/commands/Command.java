package com.scaler.splitwisejune22.commands;

public interface Command {

    boolean canExecute(String input);

    void execute(String input);
}
