package com.rakovets.course.design.practice.solid.pizza.controller;

import com.rakovets.course.design.practice.solid.pizza.view.StarterViewConsole;
import com.rakovets.course.design.practice.solid.pizza.view.StorageUtilityViewConsole;

import java.io.IOException;
import java.util.Scanner;

public class PizzaController {
    private static final StarterViewConsole starterViewConsole;
    private final PizzaOrderController pizzaOrderController = new PizzaOrderController();
    private static final CreatePizzaController createPizzaController;
    private static final OrderStatisticsController orderStatisticsController;
    private static final StorageUtilityViewConsole storageUtilityViewConsole;

    static {

        starterViewConsole = new StarterViewConsole();
        createPizzaController = new CreatePizzaController();
        orderStatisticsController = new OrderStatisticsController();
        storageUtilityViewConsole = new StorageUtilityViewConsole();

    }

    public PizzaController() throws IOException {
    }

    public void start() throws IOException {
        starterViewConsole.displayOperations();
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                pizzaOrderController.start();
                pizzaOrderController.choosePizza();
                pizzaOrderController.addPizzaQuestion();
                addChoiceQuestion();
                break;
            case 2:
                createPizzaController.start();
                createPizzaController.chooseDough();
                createPizzaController.chooseIngredients();
                createPizzaController.addIngredientsQuestion();
                addChoiceQuestion();
                break;
            case 3:
                orderStatisticsController.start();
                addChoiceQuestion();
                break;
            default:
                storageUtilityViewConsole.displayStorage();
                storageUtilityViewConsole.showLackOfIngredients();
                addChoiceQuestion();
                break;
        }
    }

    public void addChoiceQuestion() throws IOException {
        starterViewConsole.chooseOtherOperations();
        Scanner scan = new Scanner(System.in);
        char ch = scan.next().charAt(0);
        if (ch == 'Y' || ch == 'y') {
            start();
        }
    }
}
