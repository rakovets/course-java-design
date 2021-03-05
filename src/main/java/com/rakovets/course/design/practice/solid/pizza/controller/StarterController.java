package com.rakovets.course.design.practice.solid.pizza.controller;

import com.rakovets.course.design.practice.solid.pizza.view.StarterViewConsole;
import com.rakovets.course.design.practice.solid.pizza.view.StorageUtilityViewConsole;

import java.io.IOException;
import java.util.Scanner;

public class StarterController {
    private final StarterViewConsole starterViewConsole = new StarterViewConsole();

    public void start() throws IOException {
        starterViewConsole.displayOperations();
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                PizzaOrderController pizzaOrderController = new PizzaOrderController();
                pizzaOrderController.start();
                pizzaOrderController.choosePizza();
                pizzaOrderController.addPizzaQuestion();
                addChoiceQuestion();
                break;
            case 2:
                CreatePizzaController createPizzaController = new CreatePizzaController();
                createPizzaController.start();
                createPizzaController.chooseDough();
                createPizzaController.chooseIngredients();
                createPizzaController.addIngredientsQuestion();
                addChoiceQuestion();
                break;
            case 3:
                OrderStatisticsController orderStatisticsController = new OrderStatisticsController();
                orderStatisticsController.start();
                addChoiceQuestion();
                break;
            default:
                StorageUtilityViewConsole storageUtilityViewConsole = new StorageUtilityViewConsole();
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
