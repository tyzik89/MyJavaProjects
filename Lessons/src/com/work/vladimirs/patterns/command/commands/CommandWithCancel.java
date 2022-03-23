package com.work.vladimirs.patterns.command.commands;

public interface CommandWithCancel extends Command{
    void undo();
}
