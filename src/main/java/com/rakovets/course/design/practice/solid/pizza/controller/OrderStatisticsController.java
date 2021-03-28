package com.rakovets.course.design.practice.solid.pizza.controller;

import com.rakovets.course.design.practice.solid.pizza.exceptions.OrderStatisticsException;
import com.rakovets.course.design.practice.solid.pizza.service.OrderStatisticsService;
import com.rakovets.course.design.practice.solid.pizza.service.PizzaCostService;
import com.rakovets.course.design.practice.solid.pizza.service.PizzaPriceService;
import com.rakovets.course.design.practice.solid.pizza.view.OrderStatisticsViewConsole;

import java.util.*;

public class OrderStatisticsController {
    public int numberOfFourCheeseSold;
    public int numberOfMargheritaSold;
    public int numberOfMeatDelightSold;
    public int numberOfPepperoniSold;
    public int numberOfVegetarianSold;
    private static final OrderStatisticsViewConsole ORDER_STATISTICS_VIEW;
    private static final OrderStatisticsService ORDER_STATISTICS;
    public static final Map<Integer, Double> SOLD_PIZZAS_REVENUE;
    private static final PizzaPriceService PIZZA_PRICE;
    public static final Map<Integer, Double> SOLD_PIZZAS_COST;

    static {
        ORDER_STATISTICS_VIEW = new OrderStatisticsViewConsole();
        ORDER_STATISTICS = new OrderStatisticsService();
        PIZZA_PRICE = new PizzaPriceService();
        SOLD_PIZZAS_REVENUE = new HashMap<>();
        SOLD_PIZZAS_COST = new HashMap<>();
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
            createMapOfSoldPizzasRevenue();
            ORDER_STATISTICS.totalPizzasSold();
            ORDER_STATISTICS_VIEW.totalPizzasSold();
            ORDER_STATISTICS.pizzasRevenue();
            ORDER_STATISTICS_VIEW.pizzasRevenue();
            ORDER_STATISTICS.totalRevenue();
            ORDER_STATISTICS_VIEW.totalRevenue();
            ORDER_STATISTICS.averageCheck();
            ORDER_STATISTICS_VIEW.averageCheck();
            createMapOfSoldPizzasCost();
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

    public void createMapOfSoldPizzasRevenue() {
        SOLD_PIZZAS_REVENUE.put(numberOfFourCheeseSold, PIZZA_PRICE.pricePizzaFourCheeseIncludingVAT());
        SOLD_PIZZAS_REVENUE.put(numberOfMargheritaSold, PIZZA_PRICE.pricePizzaMargheritaIncludingVAT());
        SOLD_PIZZAS_REVENUE.put(numberOfMeatDelightSold, PIZZA_PRICE.pricePizzaMeatDelightIncludingVAT());
        SOLD_PIZZAS_REVENUE.put(numberOfPepperoniSold, PIZZA_PRICE.pricePizzaPepperoniIncludingVAT());
        SOLD_PIZZAS_REVENUE.put(numberOfVegetarianSold, PIZZA_PRICE.pricePizzaVegetarianIncludingVAT());
    }

    public void createMapOfSoldPizzasCost() {
        SOLD_PIZZAS_COST.put(numberOfFourCheeseSold, PizzaCostService.getCostFourCheese());
        SOLD_PIZZAS_COST.put(numberOfMargheritaSold, PizzaCostService.getCostMargherita());
        SOLD_PIZZAS_COST.put(numberOfMeatDelightSold, PizzaCostService.getCostMeatDelight());
        SOLD_PIZZAS_COST.put(numberOfPepperoniSold, PizzaCostService.getCostPepperoni());
        SOLD_PIZZAS_COST.put(numberOfVegetarianSold, PizzaCostService.getCostVegetarian());
    }
}
