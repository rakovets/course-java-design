package com.rakovets.course.design.practice.solid.pizza.controller;

import com.rakovets.course.design.practice.solid.pizza.service.CreatePizzaService;
import com.rakovets.course.design.practice.solid.pizza.service.PizzaOrderService;
import com.rakovets.course.design.practice.solid.pizza.service.SupplyService;
import com.rakovets.course.design.practice.solid.pizza.view.StarterViewConsole;
import com.rakovets.course.design.practice.solid.pizza.view.StorageUtilityViewConsole;

import java.io.IOException;
import java.util.Scanner;

public class PizzaController {
    private static final StarterViewConsole starterView;
    private final PizzaOrderService pizzaOrderService = new PizzaOrderService();
    private static final CreatePizzaService createPizzaService;
    private static final OrderStatisticsController orderStatisticsController;
    private static final StorageUtilityViewConsole storageUtilityView;
    private static final SupplyService supplyService;
    private static final EmployeeController employeeController;
    private static final Scanner scanner;
    public int enteredInt;
    public int operationChoice;
    private static boolean programOn;

    static {
        starterView = new StarterViewConsole();
        createPizzaService = new CreatePizzaService();
        orderStatisticsController = new OrderStatisticsController();
        storageUtilityView = new StorageUtilityViewConsole();
        supplyService = new SupplyService();
        employeeController = new EmployeeController();
        scanner = new Scanner(System.in);
        programOn = true;
    }

    public PizzaController() throws IOException {
    }

    public void start() throws IOException {
        while (programOn) {
            starterView.displayOperations();
            operationChoice = checkInt();
            switch (operationChoice) {
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
                    storageUtilityView.displayStorage();
                    storageUtilityView.showLackOfIngredients();
                    addChoiceQuestion();
                    break;
                case 5:
                    supplyService.start();
                    addChoiceQuestion();
                    break;
                case 6:
                    employeeController.start();
                    addChoiceQuestion();
                    break;
                case 7:
                    starterView.exitProgram();
                    programOn = false;
                    break;
                default:
                    starterView.noSuchOperation();
                    start();
                    break;
            }
        }
    }

    public void addChoiceQuestion() throws IOException {
        starterView.chooseOtherOperations();
        Scanner scan = new Scanner(System.in);
        char ch = scan.next().charAt(0);
        if (ch == 'Y' || ch == 'y') {
            start();
        }
    }

    public int checkInt() {
        do {
            while (!scanner.hasNextInt()) {
                starterView.invalidInput();
                scanner.next();
            }
            enteredInt = scanner.nextInt();
        } while (enteredInt <= 0);
        return enteredInt;
    }
}
