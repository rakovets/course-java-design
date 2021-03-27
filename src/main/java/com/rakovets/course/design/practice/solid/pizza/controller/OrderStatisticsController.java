package com.rakovets.course.design.practice.solid.pizza.controller;

import com.rakovets.course.design.practice.solid.pizza.exceptions.OrderStatisticsException;
import com.rakovets.course.design.practice.solid.pizza.service.OrderStatisticsService;
import com.rakovets.course.design.practice.solid.pizza.service.PizzaPriceService;
import com.rakovets.course.design.practice.solid.pizza.view.OrderStatisticsViewConsole;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderStatisticsController {
    public static int numberOfFourCheeseSold;
    public static int numberOfMargheritaSold;
    public static int numberOfMeatDelightSold;
    public static int numberOfPepperoniSold;
    public static int numberOfVegetarianSold;
    private static final OrderStatisticsViewConsole ORDER_STATISTICS_VIEW;
    private static final PizzaPriceService PRICE_SERVICE;
    private static final OrderStatisticsService ORDER_STATISTICS;

    static {
        ORDER_STATISTICS_VIEW = new OrderStatisticsViewConsole();
        PRICE_SERVICE = new PizzaPriceService();
        ORDER_STATISTICS = new OrderStatisticsService();
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
            ORDER_STATISTICS_VIEW.displayFourCheese();
            ORDER_STATISTICS_VIEW.displayMargherita();
            ORDER_STATISTICS_VIEW.displayMeatDelight();
            ORDER_STATISTICS_VIEW.displayPepperoni();
            ORDER_STATISTICS_VIEW.displayVegetarian();
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
