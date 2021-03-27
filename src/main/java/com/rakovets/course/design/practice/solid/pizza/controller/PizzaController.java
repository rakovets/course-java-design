package com.rakovets.course.design.practice.solid.pizza.controller;

import com.rakovets.course.design.practice.solid.pizza.service.CreatePizzaService;
import com.rakovets.course.design.practice.solid.pizza.service.PizzaOrderService;
import com.rakovets.course.design.practice.solid.pizza.service.SupplyService;
import com.rakovets.course.design.practice.solid.pizza.util.CheckIntUtil;
import com.rakovets.course.design.practice.solid.pizza.view.StarterViewConsole;
import com.rakovets.course.design.practice.solid.pizza.view.StorageUtilityViewConsole;

import java.io.IOException;
import java.util.Scanner;

public class PizzaController {
    private static final StarterViewConsole STARTER_VIEW;
    private static final PizzaOrderService PIZZA_ORDER;
    private static final CreatePizzaService CREATE_PIZZA;
    private static final OrderStatisticsController ORDER_STATISTICS;
    private static final StorageUtilityViewConsole STORAGE_UTILITY_VIEW;
    private static final SupplyService SUPPLY;
    private static final EmployeeController EMPLOYEE;
    public int operationChoice;
    private static boolean programOn;
    public static final CheckIntUtil CHECK_INT;

    static {
        STARTER_VIEW = new StarterViewConsole();
        PIZZA_ORDER = new PizzaOrderService();
        CREATE_PIZZA = new CreatePizzaService();
        ORDER_STATISTICS = new OrderStatisticsController();
        STORAGE_UTILITY_VIEW = new StorageUtilityViewConsole();
        SUPPLY = new SupplyService();
        EMPLOYEE = new EmployeeController();
        programOn = true;
        CHECK_INT = new CheckIntUtil();
    }

    public PizzaController() {
    }

    public void start() throws IOException {
        while (programOn) {
            STARTER_VIEW.displayOperations();
            operationChoice = CHECK_INT.checkInt();
            switch (operationChoice) {
                case 1:
                    PIZZA_ORDER.start();
                    PIZZA_ORDER.choosePizza();
                    PIZZA_ORDER.addPizzaQuestion();
                    addChoiceQuestion();
                    break;
                case 2:
                    CREATE_PIZZA.start();
                    CREATE_PIZZA.chooseDough();
                    CREATE_PIZZA.chooseIngredients();
                    CREATE_PIZZA.addIngredientsQuestion();
                    addChoiceQuestion();
                    break;
                case 3:
                    ORDER_STATISTICS.start();
                    addChoiceQuestion();
                    break;
                case 4:
                    STORAGE_UTILITY_VIEW.displayStorage();
                    STORAGE_UTILITY_VIEW.showLackOfIngredients();
                    addChoiceQuestion();
                    break;
                case 5:
                    SUPPLY.start();
                    addChoiceQuestion();
                    break;
                case 6:
                    EMPLOYEE.start();
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
