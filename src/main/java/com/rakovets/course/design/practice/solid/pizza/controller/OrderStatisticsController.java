package com.rakovets.course.design.practice.solid.pizza.controller;

import com.rakovets.course.design.practice.solid.pizza.exceptions.OrderStatisticsException;
import com.rakovets.course.design.practice.solid.pizza.service.OrderStatisticsService;
import com.rakovets.course.design.practice.solid.pizza.util.PizzaCostUtil;
import com.rakovets.course.design.practice.solid.pizza.util.PizzaPriceUtil;
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
    public static final Map<Integer, Double> SOLD_PIZZAS_COST;

    static {
        ORDER_STATISTICS_VIEW = new OrderStatisticsViewConsole();
        ORDER_STATISTICS = new OrderStatisticsService();
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
        SOLD_PIZZAS_REVENUE.put(numberOfFourCheeseSold, PizzaPriceUtil.pricePizzaFourCheeseIncludingVAT());
        SOLD_PIZZAS_REVENUE.put(numberOfMargheritaSold, PizzaPriceUtil.pricePizzaMargheritaIncludingVAT());
        SOLD_PIZZAS_REVENUE.put(numberOfMeatDelightSold, PizzaPriceUtil.pricePizzaMeatDelightIncludingVAT());
        SOLD_PIZZAS_REVENUE.put(numberOfPepperoniSold, PizzaPriceUtil.pricePizzaPepperoniIncludingVAT());
        SOLD_PIZZAS_REVENUE.put(numberOfVegetarianSold, PizzaPriceUtil.pricePizzaVegetarianIncludingVAT());
    }

    public void createMapOfSoldPizzasCost() {
        SOLD_PIZZAS_COST.put(numberOfFourCheeseSold, PizzaCostUtil.getCostFourCheese());
        SOLD_PIZZAS_COST.put(numberOfMargheritaSold, PizzaCostUtil.getCostMargherita());
        SOLD_PIZZAS_COST.put(numberOfMeatDelightSold, PizzaCostUtil.getCostMeatDelight());
        SOLD_PIZZAS_COST.put(numberOfPepperoniSold, PizzaCostUtil.getCostPepperoni());
        SOLD_PIZZAS_COST.put(numberOfVegetarianSold, PizzaCostUtil.getCostVegetarian());
    }
}
