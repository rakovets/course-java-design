package com.rakovets.course.design.practice.solid.pizza.controller;

import com.rakovets.course.design.practice.solid.pizza.exceptions.OrderStatisticsException;
import com.rakovets.course.design.practice.solid.pizza.service.OrderStatisticsService;
import com.rakovets.course.design.practice.solid.pizza.view.OrderStatisticsViewConsole;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class OrderStatisticsController {
    public int numberOfFourCheeseSold;
    public int numberOfMargheritaSold;
    public int numberOfMeatDelightSold;
    public int numberOfPepperoniSold;
    public int numberOfVegetarianSold;
    private static final OrderStatisticsViewConsole ORDER_STATISTICS_VIEW;
    private static final OrderStatisticsService ORDER_STATISTICS;
    public static final Map<Integer, Integer> SOLD_PIZZAS;

    static {
        ORDER_STATISTICS_VIEW = new OrderStatisticsViewConsole();
        ORDER_STATISTICS = new OrderStatisticsService();
        SOLD_PIZZAS = new HashMap<>();
    }

    public void start() {
        try {
            Scanner scan = new Scanner(System.in);
            ORDER_STATISTICS_VIEW.enterFourCheese();
            numberOfFourCheeseSold = scan.nextInt();
            ORDER_STATISTICS_VIEW.enterMargherita();
            numberOfMargheritaSold = scan.nextInt();
            ORDER_STATISTICS_VIEW.enterMeatDelight();
            numberOfMeatDelightSold = scan.nextInt();
            ORDER_STATISTICS_VIEW.enterPepperoni();
            numberOfPepperoniSold = scan.nextInt();
            ORDER_STATISTICS_VIEW.enterVegetarian();
            numberOfVegetarianSold = scan.nextInt();
            createMapOfSoldPizzas();
            ORDER_STATISTICS.pizzasSold();
            ORDER_STATISTICS_VIEW.pizzasSold();
            ORDER_STATISTICS.totalPizzasSold();
            ORDER_STATISTICS_VIEW.totalPizzasSold();
            ORDER_STATISTICS.pizzasRevenue();
            ORDER_STATISTICS_VIEW.pizzasRevenue();
            ORDER_STATISTICS.totalRevenue();
            ORDER_STATISTICS_VIEW.totalRevenue();
            ORDER_STATISTICS.averageCheck();
            ORDER_STATISTICS_VIEW.averageCheck();
            ORDER_STATISTICS.totalProfit();
            ORDER_STATISTICS_VIEW.totalProfit();
            ORDER_STATISTICS.profitMargin();
            ORDER_STATISTICS_VIEW.profitMargin();
        } catch (InputMismatchException e) {
            try {
                throw new OrderStatisticsException();
            } catch (OrderStatisticsException ex) {
                ORDER_STATISTICS_VIEW.orderStatisticsException();
                start();
            }
        }
    }

    public void createMapOfSoldPizzas() {
        SOLD_PIZZAS.put(1, numberOfFourCheeseSold);
        SOLD_PIZZAS.put(2, numberOfMargheritaSold);
        SOLD_PIZZAS.put(3, numberOfMeatDelightSold);
        SOLD_PIZZAS.put(4, numberOfPepperoniSold);
        SOLD_PIZZAS.put(5, numberOfVegetarianSold);
    }
}
