package com.rakovets.course.design.practice.solid.pizza.view;

import com.rakovets.course.design.practice.solid.pizza.controller.OrderStatisticsController;
import com.rakovets.course.design.practice.solid.pizza.exceptions.OrderStatisticsException;
import com.rakovets.course.design.practice.solid.pizza.model.Pizza;
import com.rakovets.course.design.practice.solid.pizza.service.OrderStatisticsService;
import com.rakovets.course.design.practice.solid.pizza.service.PizzaCostService;
import com.rakovets.course.design.practice.solid.pizza.service.PizzaPriceService;

public class OrderStatisticsViewConsole implements OrderStatisticsView {
    private static final OrderStatisticsService orderStatisticsService;
    private static final PizzaPriceService pizzaPriceService;
    private static final OrderStatisticsException orderStatisticsException;

    static {
        orderStatisticsService = new OrderStatisticsService();
        pizzaPriceService = new PizzaPriceService();
        orderStatisticsException = new OrderStatisticsException();
    }

    public void enterFourCheese() {
        System.out.println("Enter number of Pizzas 'Four Cheese' sold:");
    }

    public void displayFourCheese() {
        System.out.println("\nPizzas 'Four Cheese':");
        System.out.println("Number of sold pizzas: " + OrderStatisticsController.numberOfFourCheeseSold);
        System.out.println("Revenue: " + orderStatisticsService.getRevenue(Pizza.FOUR_CHEESE,
                OrderStatisticsController.numberOfFourCheeseSold,
                pizzaPriceService.pricePizzaFourCheeseIncludingVAT()) + "$");
        System.out.println("Profit: " + orderStatisticsService.getProfit(Pizza.FOUR_CHEESE,
                OrderStatisticsController.numberOfFourCheeseSold,
                pizzaPriceService.pricePizzaFourCheeseIncludingVAT(),
                PizzaCostService.getCostFourCheese()) + "$");
    }

    public void enterMargherita() {
        System.out.println("Enter number of Pizzas 'Margherita' sold:");
    }

    public void displayMargherita() {
        System.out.println("\nPizzas 'Margherita':");
        System.out.println("Number of sold pizzas: " + OrderStatisticsController.numberOfMargheritaSold);
        System.out.println("Revenue: " + orderStatisticsService.getRevenue(Pizza.MARGHERITA,
                OrderStatisticsController.numberOfMargheritaSold,
                pizzaPriceService.pricePizzaMargheritaIncludingVAT()) + "$");
        System.out.println("Profit: " + orderStatisticsService.getProfit(Pizza.MARGHERITA,
                OrderStatisticsController.numberOfMargheritaSold,
                pizzaPriceService.pricePizzaMargheritaIncludingVAT(),
                PizzaCostService.getCostMargherita()) + "$");
    }

    public void enterMeatDelight() {
        System.out.println("Enter number of Pizzas 'Meat Delight' sold:");
    }

    public void displayMeatDelight() {
        System.out.println("\nPizzas 'Meat Delight':");
        System.out.println("Number of sold pizzas: " + OrderStatisticsController.numberOfMeatDelightSold);
        System.out.println("Revenue: " + orderStatisticsService.getRevenue(Pizza.MEAT_DELIGHT,
                OrderStatisticsController.numberOfMeatDelightSold,
                pizzaPriceService.pricePizzaMeatDelightIncludingVAT()) + "$");
        System.out.println("Profit: " + orderStatisticsService.getProfit(Pizza.MEAT_DELIGHT,
                OrderStatisticsController.numberOfMeatDelightSold,
                pizzaPriceService.pricePizzaMeatDelightIncludingVAT(),
                PizzaCostService.getCostMeatDelight()) + "$");
    }

    public void enterPepperoni() {
        System.out.println("Enter number of Pizzas 'Pepperoni' sold:");
    }

    public void displayPepperoni() {
        System.out.println("\nPizzas 'Pepperoni':");
        System.out.println("Number of sold pizzas: " + OrderStatisticsController.numberOfPepperoniSold);
        System.out.println("Revenue: " + orderStatisticsService.getRevenue(Pizza.PEPPERONI,
                OrderStatisticsController.numberOfPepperoniSold,
                pizzaPriceService.pricePizzaPepperoniIncludingVAT()) + "$");
        System.out.println("Profit: " + orderStatisticsService.getProfit(Pizza.PEPPERONI,
                OrderStatisticsController.numberOfPepperoniSold,
                pizzaPriceService.pricePizzaPepperoniIncludingVAT(),
                PizzaCostService.getCostPepperoni()) + "$");
    }

    public void enterVegetarian() {
        System.out.println("Enter number of Pizzas 'Vegetarian' sold:");
    }

    public void displayVegetarian() {
        System.out.println("\nPizzas 'Vegetarian':");
        System.out.println("Number of sold pizzas: " + OrderStatisticsController.numberOfVegetarianSold);
        System.out.println("Revenue: " + orderStatisticsService.getRevenue(Pizza.VEGETARIAN,
                OrderStatisticsController.numberOfVegetarianSold,
                pizzaPriceService.pricePizzaVegetarianIncludingVAT()) + "$");
        System.out.println("Profit: " + orderStatisticsService.getProfit(Pizza.VEGETARIAN,
                OrderStatisticsController.numberOfVegetarianSold,
                pizzaPriceService.pricePizzaVegetarianIncludingVAT(),
                PizzaCostService.getCostVegetarian()) + "$");
    }

    public void orderStatisticsException() {
        System.out.println(orderStatisticsException.toString());
    }
}
