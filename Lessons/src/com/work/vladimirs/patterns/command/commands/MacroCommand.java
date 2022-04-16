package com.work.vladimirs.patterns.command.commands;

/**
 * Маркрокоманда это новая разновидность команд, которая может выполнять другие команды.
 * Причем сразу несколько.
 */
public class MacroCommand implements Command {

    private Command[] commands;

    public MacroCommand(Command[] commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        for (int i = 0; i < commands.length; i++) {
            // При выполнении макрокоманды все команды будут последовательно выполнены.
            commands[i].execute();
        }
    }
}
