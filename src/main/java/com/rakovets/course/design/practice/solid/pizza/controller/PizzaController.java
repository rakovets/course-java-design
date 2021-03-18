package com.rakovets.course.design.practice.solid.pizza.controller;

import com.rakovets.course.design.practice.solid.pizza.service.CreatePizzaService;
import com.rakovets.course.design.practice.solid.pizza.service.PizzaOrderService;
import com.rakovets.course.design.practice.solid.pizza.service.SupplyService;
import com.rakovets.course.design.practice.solid.pizza.view.StarterViewConsole;
import com.rakovets.course.design.practice.solid.pizza.view.StorageUtilityViewConsole;

import java.io.IOException;
import java.util.Scanner;

public class PizzaController {
    private static final StarterViewConsole starterViewConsole;
    private final PizzaOrderService pizzaOrderService = new PizzaOrderService();
    private static final CreatePizzaService createPizzaService;
    private static final OrderStatisticsController orderStatisticsController;
    private static final StorageUtilityViewConsole storageUtilityViewConsole;
    private static final SupplyService supplyService;

    static {
        starterViewConsole = new StarterViewConsole();
        createPizzaService = new CreatePizzaService();
        orderStatisticsController = new OrderStatisticsController();
        storageUtilityViewConsole = new StorageUtilityViewConsole();
        supplyService = new SupplyService();
    }

    public PizzaController() throws IOException {
    }

    public void start() throws IOException {
        starterViewConsole.displayOperations();
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                pizzaOrderService.start();
                pizzaOrderService.choosePizza();
                pizzaOrderService.addPizzaQuestion();
                addChoiceQuestion();
                break;
            case 2:
                createPizzaService.start();
                createPizzaService.chooseDough();
                createPizzaService.chooseIngredients();
                createPizzaService.addIngredientsQuestion();
                addChoiceQuestion();
                break;
            case 3:
                orderStatisticsController.start();
                addChoiceQuestion();
                break;
            case 4:
                storageUtilityViewConsole.displayStorage();
                storageUtilityViewConsole.showLackOfIngredients();
                addChoiceQuestion();
                break;
            default:
                supplyService.start();
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
