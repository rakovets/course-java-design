package com.rakovets.course.design.practice.solid.pizza.controller;

import com.rakovets.course.design.practice.solid.pizza.model.Pizza;
import com.rakovets.course.design.practice.solid.pizza.service.PizzaCostService;
import com.rakovets.course.design.practice.solid.pizza.service.ProfitService;
import com.rakovets.course.design.practice.solid.pizza.service.OrderStatisticsService;

public class OrderStatisticsController {
    private static final OrderStatisticsService orderStatisticsService;
    private static final int numberOfFourCheeseSold;
    private static final int numberOfMargheritaSold;
    private static final int numberOfMeatDelightSold;
    private static final int numberOfPepperoniSold;
    private static final int numberOfVegetarianSold;

    static {
        orderStatisticsService = new OrderStatisticsService();
        numberOfFourCheeseSold = 100;
        numberOfMargheritaSold = 100;
        numberOfMeatDelightSold = 100;
        numberOfPepperoniSold = 100;
        numberOfVegetarianSold = 100;
    }

    public void start() {
        System.out.println("\nPizzas 'Four Cheese':");
        System.out.println("Number of sold pizzas: " + orderStatisticsService.getNumberOfPizzasSold
                (Pizza.FOUR_CHEESE, numberOfFourCheeseSold));
        System.out.println("Revenue: " + orderStatisticsService.getRevenue(Pizza.FOUR_CHEESE, numberOfFourCheeseSold,
                (ProfitService.profitPercentage(PizzaCostService.getCostFourCheese()))) + "$");
        System.out.println("Profit: " + orderStatisticsService.getProfit(Pizza.FOUR_CHEESE, numberOfFourCheeseSold,
                ProfitService.profitPercentage(PizzaCostService.getCostFourCheese()), PizzaCostService.getCostFourCheese()) + "$");

        System.out.println("\nPizzas 'Margherita':");
        System.out.println("Number of sold pizzas: " + orderStatisticsService.getNumberOfPizzasSold
                (Pizza.MARGHERITA, numberOfMargheritaSold));
        System.out.println("Revenue: " + orderStatisticsService.getRevenue(Pizza.MARGHERITA, numberOfMargheritaSold,
                ProfitService.profitPercentage(PizzaCostService.getCostMargherita())) + "$");
        System.out.println("Profit: " + orderStatisticsService.getProfit(Pizza.MARGHERITA, numberOfMargheritaSold,
                ProfitService.profitPercentage(PizzaCostService.getCostMargherita()), PizzaCostService.getCostMargherita()) + "$");

        System.out.println("\nPizzas 'MeatDelight':");
        System.out.println("Number of sold pizzas: " + orderStatisticsService.getNumberOfPizzasSold
                (Pizza.MEAT_DELIGHT, numberOfMeatDelightSold));
        System.out.println("Revenue: " + orderStatisticsService.getRevenue(Pizza.MEAT_DELIGHT, numberOfMeatDelightSold,
                ProfitService.profitPercentage(PizzaCostService.getCostMeatDelight())) + "$");
        System.out.println("Profit: " + orderStatisticsService.getProfit(Pizza.MEAT_DELIGHT, numberOfMeatDelightSold,
                ProfitService.profitPercentage(PizzaCostService.getCostMeatDelight()), PizzaCostService.getCostMeatDelight()) + "$");

        System.out.println("\nPizzas 'Pepperoni':");
        System.out.println("Number of sold pizzas: " + orderStatisticsService.getNumberOfPizzasSold
                (Pizza.PEPPERONI, numberOfPepperoniSold));
        System.out.println("Revenue: " + orderStatisticsService.getRevenue(Pizza.PEPPERONI, numberOfPepperoniSold,
                ProfitService.profitPercentage(PizzaCostService.getCostPepperoni())) + "$");
        System.out.println("Profit: " + orderStatisticsService.getProfit(Pizza.PEPPERONI, numberOfPepperoniSold,
                ProfitService.profitPercentage(PizzaCostService.getCostPepperoni()), PizzaCostService.getCostPepperoni()) + "$");

        System.out.println("\nPizzas 'Vegetarian':");
        System.out.println("Number of sold pizzas: " + orderStatisticsService.getNumberOfPizzasSold
                (Pizza.VEGETARIAN, numberOfVegetarianSold));
        System.out.println("Revenue: " + orderStatisticsService.getRevenue(Pizza.VEGETARIAN, numberOfVegetarianSold,
                ProfitService.profitPercentage(PizzaCostService.getCostVegetarian())) + "$");
        System.out.println("Profit: " + orderStatisticsService.getProfit(Pizza.VEGETARIAN, numberOfVegetarianSold,
                ProfitService.profitPercentage(PizzaCostService.getCostVegetarian()), PizzaCostService.getCostVegetarian()) + "$");
    }
}