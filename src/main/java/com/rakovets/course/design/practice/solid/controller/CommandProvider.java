package com.rakovets.course.design.practice.solid.controller;

import com.rakovets.course.design.practice.solid.controller.impl.CardPayment;
import com.rakovets.course.design.practice.solid.controller.impl.CashPayment;
import com.rakovets.course.design.practice.solid.controller.impl.MakePizzaFromTheChef;
import com.rakovets.course.design.practice.solid.controller.impl.MakePizzaMargaritta;
import com.rakovets.course.design.practice.solid.controller.impl.MakePizzaPepperoni;
import com.rakovets.course.design.practice.solid.controller.impl.MakePizzaPesto;
import com.rakovets.course.design.practice.solid.controller.impl.MakePizzaVegetarian;
import com.rakovets.course.design.practice.solid.controller.impl.OnlinePayment;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {
    private final Map<String, Command> commands;

    public CommandProvider() {
        commands = new HashMap<>();
        commands.put("1", new MakePizzaFromTheChef<>());
        commands.put("2", new MakePizzaMargaritta<>());
        commands.put("3", new MakePizzaPepperoni<>());
        commands.put("4", new MakePizzaPesto<>());
        commands.put("5", new MakePizzaVegetarian<>());
        commands.put("6", new CardPayment());
        commands.put("7", new OnlinePayment());
        commands.put("8", new CashPayment());
    }

    public Command getCommand(String command) {
        return commands.get(command);
    }
}
