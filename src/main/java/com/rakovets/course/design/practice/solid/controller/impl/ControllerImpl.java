package com.rakovets.course.design.practice.solid.controller.impl;

import com.rakovets.course.design.practice.solid.controller.Command;
import com.rakovets.course.design.practice.solid.controller.CommandProvider;
import com.rakovets.course.design.practice.solid.controller.Controller;
import com.rakovets.course.design.practice.solid.model.ingredient.Ingredient;

import java.util.Collection;

public class ControllerImpl implements Controller {
    private final CommandProvider commandProvider;

    public ControllerImpl() {
        commandProvider = new CommandProvider();
    }

    @Override
    public <T extends Ingredient> Collection<T> doOperations(String operation) {
        Command command = commandProvider.getCommand(operation);

        return command.selectionsIngredients();
    }
}
