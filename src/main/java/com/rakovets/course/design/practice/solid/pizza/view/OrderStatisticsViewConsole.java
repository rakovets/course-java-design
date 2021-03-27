package com.rakovets.course.design.practice.solid.pizza.view;

import com.rakovets.course.design.practice.solid.pizza.controller.OrderStatisticsController;
import com.rakovets.course.design.practice.solid.pizza.exceptions.OrderStatisticsException;
import com.rakovets.course.design.practice.solid.pizza.model.Pizza;
import com.rakovets.course.design.practice.solid.pizza.service.OrderStatisticsService;
import com.rakovets.course.design.practice.solid.pizza.service.PizzaCostService;
import com.rakovets.course.design.practice.solid.pizza.service.PizzaPriceService;

public class OrderStatisticsViewConsole implements OrderStatisticsView {
    private static final OrderStatisticsService ORDER_STATISTICS;
    private static final PizzaPriceService PIZZA_PRICE;
    private static final OrderStatisticsException ORDER_STATISTICS_EXCEPTION;

    static {
        ORDER_STATISTICS = new OrderStatisticsService();
        PIZZA_PRICE = new PizzaPriceService();
        ORDER_STATISTICS_EXCEPTION = new OrderStatisticsException();
    }

    public void enterFourCheese() {
        System.out.println("Enter number of Pizzas 'Four Cheese' sold:");
    }

    public void displayFourCheese() {
        System.out.println("\nPizzas 'Four Cheese':");
        System.out.println("Number of sold pizzas: " + OrderStatisticsController.numberOfFourCheeseSold);
        System.out.println("Revenue: " + ORDER_STATISTICS.getRevenue(Pizza.FOUR_CHEESE,
                OrderStatisticsController.numberOfFourCheeseSold,
                PIZZA_PRICE.pricePizzaFourCheeseIncludingVAT()) + "$");
        System.out.println("Profit: " + ORDER_STATISTICS.getProfit(Pizza.FOUR_CHEESE,
                OrderStatisticsController.numberOfFourCheeseSold,
                PIZZA_PRICE.pricePizzaFourCheeseIncludingVAT(),
                PizzaCostService.getCostFourCheese()) + "$");
    }

    public void enterMargherita() {
        System.out.println("Enter number of Pizzas 'Margherita' sold:");
    }

    public void displayMargherita() {
        System.out.println("\nPizzas 'Margherita':");
        System.out.println("Number of sold pizzas: " + OrderStatisticsController.numberOfMargheritaSold);
        System.out.println("Revenue: " + ORDER_STATISTICS.getRevenue(Pizza.MARGHERITA,
                OrderStatisticsController.numberOfMargheritaSold,
                PIZZA_PRICE.pricePizzaMargheritaIncludingVAT()) + "$");
        System.out.println("Profit: " + ORDER_STATISTICS.getProfit(Pizza.MARGHERITA,
                OrderStatisticsController.numberOfMargheritaSold,
                PIZZA_PRICE.pricePizzaMargheritaIncludingVAT(),
                PizzaCostService.getCostMargherita()) + "$");
    }

    public void enterMeatDelight() {
        System.out.println("Enter number of Pizzas 'Meat Delight' sold:");
    }

    public void displayMeatDelight() {
        System.out.println("\nPizzas 'Meat Delight':");
        System.out.println("Number of sold pizzas: " + OrderStatisticsController.numberOfMeatDelightSold);
        System.out.println("Revenue: " + ORDER_STATISTICS.getRevenue(Pizza.MEAT_DELIGHT,
                OrderStatisticsController.numberOfMeatDelightSold,
                PIZZA_PRICE.pricePizzaMeatDelightIncludingVAT()) + "$");
        System.out.println("Profit: " + ORDER_STATISTICS.getProfit(Pizza.MEAT_DELIGHT,
                OrderStatisticsController.numberOfMeatDelightSold,
                PIZZA_PRICE.pricePizzaMeatDelightIncludingVAT(),
                PizzaCostService.getCostMeatDelight()) + "$");
    }

    public void enterPepperoni() {
        System.out.println("Enter number of Pizzas 'Pepperoni' sold:");
    }

    public void displayPepperoni() {
        System.out.println("\nPizzas 'Pepperoni':");
        System.out.println("Number of sold pizzas: " + OrderStatisticsController.numberOfPepperoniSold);
        System.out.println("Revenue: " + ORDER_STATISTICS.getRevenue(Pizza.PEPPERONI,
                OrderStatisticsController.numberOfPepperoniSold,
                PIZZA_PRICE.pricePizzaPepperoniIncludingVAT()) + "$");
        System.out.println("Profit: " + ORDER_STATISTICS.getProfit(Pizza.PEPPERONI,
                OrderStatisticsController.numberOfPepperoniSold,
                PIZZA_PRICE.pricePizzaPepperoniIncludingVAT(),
                PizzaCostService.getCostPepperoni()) + "$");
    }

    public void enterVegetarian() {
        System.out.println("Enter number of Pizzas 'Vegetarian' sold:");
    }

    public void displayVegetarian() {
        System.out.println("\nPizzas 'Vegetarian':");
        System.out.println("Number of sold pizzas: " + OrderStatisticsController.numberOfVegetarianSold);
        System.out.println("Revenue: " + ORDER_STATISTICS.getRevenue(Pizza.VEGETARIAN,
                OrderStatisticsController.numberOfVegetarianSold,
                PIZZA_PRICE.pricePizzaVegetarianIncludingVAT()) + "$");
        System.out.println("Profit: " + ORDER_STATISTICS.getProfit(Pizza.VEGETARIAN,
                OrderStatisticsController.numberOfVegetarianSold,
                PIZZA_PRICE.pricePizzaVegetarianIncludingVAT(),
                PizzaCostService.getCostVegetarian()) + "$");
    }

    public void orderStatisticsException() {
        System.out.println(ORDER_STATISTICS_EXCEPTION.toString());
    }

    public void totalPizzasSold() {
        System.out.println();
        System.out.println("Total pizzas sold: " + ORDER_STATISTICS.totalPizzasSold());
    }

    public void totalRevenue() {
        System.out.println("Total revenue is " + ORDER_STATISTICS.totalRevenue() + "$");
    }

    public void averageCheck() {
        System.out.println("Average check is " + ORDER_STATISTICS.averageCheck() + "$");
    }
}
