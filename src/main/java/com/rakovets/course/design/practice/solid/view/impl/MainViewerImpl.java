package com.rakovets.course.design.practice.solid.view.impl;

import com.rakovets.course.design.practice.solid.controller.Controller;
import com.rakovets.course.design.practice.solid.controller.ControllerProvider;
import com.rakovets.course.design.practice.solid.model.Pizza;
import com.rakovets.course.design.practice.solid.view.MainViewer;

import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class MainViewerImpl implements MainViewer {
    private static final String REGEX = "[1-5]";
    private static final Logger LOGGER = Logger.getLogger("MainViewerImpl");
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String showMenu() {
        return String.format("Choose a pizza: %n1 - %s%n2 - %s%n3 - %s%n4 - %s%n5 - %s", "Pizza from the chef",
                "Pizza Margaritta", "Pizza Pepperoni", "Pizza Pesto", "Pizza Vegetarian");
    }

    @Override
    public String chooseOperation() {
        ControllerProvider controllerProvider = ControllerProvider.getINSTANCE();
        Controller controller = controllerProvider.getController();

        Pattern pattern = Pattern.compile(REGEX);

        while (!scanner.hasNext(pattern)) {
            LOGGER.info("Invalid value! Select from 1 to 5");
            scanner.next();
        }
        String operation = scanner.next();

        Pizza pizza = controller.doOperations(operation);

        return "Pizza name: " +
                pizza.getName() +
                String.format("%n") +
                String.format("Price: %.2f$", pizza.getPrice()) +
                String.format("%n") +
                String.format("Pizza weight: %.2f", pizza.getWeight()) +
                String.format("%n") +
                "\t\t\tPizza Ingredients" +
                pizza;
    }
}