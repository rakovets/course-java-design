package com.rakovets.course.design.practice.solid.pizza.controller;

import com.rakovets.course.design.practice.solid.pizza.exceptions.OrderStatisticsException;
import com.rakovets.course.design.practice.solid.pizza.service.OrderStatisticsService;
import com.rakovets.course.design.practice.solid.pizza.service.PizzaPriceService;
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
    public static final Map<Integer, Double> SOLD_PIZZAS;
    private static final PizzaPriceService PIZZA_PRICE;

    static {
        ORDER_STATISTICS_VIEW = new OrderStatisticsViewConsole();
        ORDER_STATISTICS = new OrderStatisticsService();
        PIZZA_PRICE = new PizzaPriceService();
        SOLD_PIZZAS = new HashMap<>();
    }

    public void start() {
        try {
            Scanner scan = new Scanner(System.in);
            ORDER_STATISTICS_VIEW.enterFourCheese();
            numberOfFourCheeseSold = scan.nextInt();
            SOLD_PIZZAS.put(numberOfFourCheeseSold, PIZZA_PRICE.pricePizzaFourCheeseIncludingVAT());
            ORDER_STATISTICS_VIEW.enterMargherita();
            numberOfMargheritaSold = scan.nextInt();
            SOLD_PIZZAS.put(numberOfMargheritaSold, PIZZA_PRICE.pricePizzaMargheritaIncludingVAT());
            ORDER_STATISTICS_VIEW.enterMeatDelight();
            numberOfMeatDelightSold = scan.nextInt();
            SOLD_PIZZAS.put(numberOfMeatDelightSold, PIZZA_PRICE.pricePizzaMeatDelightIncludingVAT());
            ORDER_STATISTICS_VIEW.enterPepperoni();
            numberOfPepperoniSold = scan.nextInt();
            SOLD_PIZZAS.put(numberOfPepperoniSold, PIZZA_PRICE.pricePizzaPepperoniIncludingVAT());
            ORDER_STATISTICS_VIEW.enterVegetarian();
            numberOfVegetarianSold = scan.nextInt();
            SOLD_PIZZAS.put(numberOfVegetarianSold, PIZZA_PRICE.pricePizzaVegetarianIncludingVAT());
            ORDER_STATISTICS_VIEW.totalPizzasSold();
            ORDER_STATISTICS.totalPizzasSold();
            ORDER_STATISTICS.totalRevenue();
            ORDER_STATISTICS_VIEW.totalRevenue();
            ORDER_STATISTICS.averageCheck();
            ORDER_STATISTICS_VIEW.averageCheck();
        } catch (InputMismatchException e) {
            try {
                throw new OrderStatisticsException();
            } catch (OrderStatisticsException ex) {
                ORDER_STATISTICS_VIEW.orderStatisticsException();
                start();
            }
        }
    }
}
