package com.rakovets.course.design.practice.solid.pizza.controller;

import com.rakovets.course.design.practice.solid.pizza.service.CreatePizzaService;
import com.rakovets.course.design.practice.solid.pizza.service.PizzaOrderService;
import com.rakovets.course.design.practice.solid.pizza.service.SupplyService;
import com.rakovets.course.design.practice.solid.pizza.util.CheckInt;
import com.rakovets.course.design.practice.solid.pizza.view.StarterViewConsole;
import com.rakovets.course.design.practice.solid.pizza.view.StorageUtilityViewConsole;

import java.io.IOException;
import java.util.Scanner;

public class PizzaController {
    private static final StarterViewConsole STARTER_VIEW;
    private final PizzaOrderService pizzaOrderService = new PizzaOrderService();
    private static final CreatePizzaService CREATE_PIZZA_SERVICE;
    private static final OrderStatisticsController ORDER_STATISTICS_CONTROLLER;
    private static final StorageUtilityViewConsole STORAGE_UTILITY_VIEW;
    private static final SupplyService SUPPLY_SERVICE;
    private static final EmployeeController EMPLOYEE_CONTROLLER;
    public int operationChoice;
    private static boolean programOn;
    public static final CheckInt CHECK_INT;

    static {
        STARTER_VIEW = new StarterViewConsole();
        CREATE_PIZZA_SERVICE = new CreatePizzaService();
        ORDER_STATISTICS_CONTROLLER = new OrderStatisticsController();
        STORAGE_UTILITY_VIEW = new StorageUtilityViewConsole();
        SUPPLY_SERVICE = new SupplyService();
        EMPLOYEE_CONTROLLER = new EmployeeController();
        programOn = true;
        CHECK_INT = new CheckInt();
    }

    public PizzaController() throws IOException {
    }

    public void start() throws IOException {
        while (programOn) {
            STARTER_VIEW.displayOperations();
            operationChoice = CHECK_INT.checkInt();
            switch (operationChoice) {
                case 1:
                    pizzaOrderService.start();
                    pizzaOrderService.choosePizza();
                    pizzaOrderService.addPizzaQuestion();
                    addChoiceQuestion();
                    break;
                case 2:
                    CREATE_PIZZA_SERVICE.start();
                    CREATE_PIZZA_SERVICE.chooseDough();
                    CREATE_PIZZA_SERVICE.chooseIngredients();
                    CREATE_PIZZA_SERVICE.addIngredientsQuestion();
                    addChoiceQuestion();
                    break;
                case 3:
                    ORDER_STATISTICS_CONTROLLER.start();
                    addChoiceQuestion();
                    break;
                case 4:
                    STORAGE_UTILITY_VIEW.displayStorage();
                    STORAGE_UTILITY_VIEW.showLackOfIngredients();
                    addChoiceQuestion();
                    break;
                case 5:
                    SUPPLY_SERVICE.start();
                    addChoiceQuestion();
                    break;
                case 6:
                    EMPLOYEE_CONTROLLER.start();
                    addChoiceQuestion();
                    break;
                case 7:
                    STARTER_VIEW.exitProgram();
                    programOn = false;
                    break;
                default:
                    STARTER_VIEW.noSuchOperation();
                    start();
                    break;
            }
        }
    }

    public void addChoiceQuestion() throws IOException {
        STARTER_VIEW.chooseOtherOperations();
        Scanner scan = new Scanner(System.in);
        char ch = scan.next().charAt(0);
        if (ch == 'Y' || ch == 'y') {
            start();
        }
    }
}
