package com.rakovets.course.design.practice.solid.controller.impl;

import com.rakovets.course.design.practice.solid.controller.Command;
import com.rakovets.course.design.practice.solid.controller.CommandProvider;
import com.rakovets.course.design.practice.solid.controller.Controller;

public final class ControllerImpl implements Controller {
    private final CommandProvider commandProvider;

    public ControllerImpl() {
        commandProvider = new CommandProvider();
    }

    @Override
    public <T> T doOperations(String operation) {
        Command command = commandProvider.getCommand(operation);

        return command.execute();
    }
}
