package com.rakovets.course.design.practice.solid.view.impl;

import com.rakovets.course.design.practice.solid.controller.Controller;
import com.rakovets.course.design.practice.solid.controller.ControllerProvider;
import com.rakovets.course.design.practice.solid.model.Pizza;
import com.rakovets.course.design.practice.solid.view.MainViewer;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public final class MainViewerImpl implements MainViewer {
    private static final String REGEX = "[1-5]";
    private static final Logger LOGGER = Logger.getLogger("MainViewerImpl");

    private final LocalDateTime startTime = LocalDateTime.now();

    private final Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

    @Override
    public String showMenu() {
        return String.format("Choose a pizza: %n1 - %s%n2 - %s%n3 - %s%n4 - %s%n5 - %s%n", "Pizza from the chef",
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

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

        return "Pizza name: " +
                pizza.getName() +
                String.format("%nPrice: %.2f$", pizza.getPrice()) +
                String.format("%nPizza weight: %.2f", pizza.getWeight()) +
                String.format("%n\t\t\tPizza Ingredients") +
                pizza +
                String.format("%nOrder time: ") +
                startTime.format(dateTimeFormatter);
    }

    @Override
    public String choosePaymentMethod() {
        return String.format("%nSelect a payment Method: %n6 - %s%n7 - %s%n8 - %s%n", "Payment by card",
                "Online payment", "Cash payment");
    }
}