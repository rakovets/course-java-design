package com.rakovets.course.design.practice.solid.Pizza.Controller;

import com.rakovets.course.design.practice.solid.Pizza.Repository.Pizza;
import com.rakovets.course.design.practice.solid.Pizza.Service.PizzaCost;
import com.rakovets.course.design.practice.solid.Pizza.Service.Profit;
import com.rakovets.course.design.practice.solid.Pizza.Service.OrderStatistics;

public class OrderStatisticsUtil {
    public static void main(String[] args) {

        int numberOfFourCheeseSold = 100;
        int numberOfMargheritaSold = 100;
        int numberOfMeatDelightSold = 100;
        int numberOfPepperoniSold = 100;
        int numberOfVegetarianSold = 100;

        OrderStatistics orderStatistics = new OrderStatistics();

        System.out.println("\nPizzas 'Four Cheese':");
        System.out.println("Number of sold pizzas: " + orderStatistics.getNumberOfPizzasSold
                (Pizza.FOUR_CHEESE, numberOfFourCheeseSold));
        System.out.println("Revenue: " + orderStatistics.getRevenue(Pizza.FOUR_CHEESE, numberOfFourCheeseSold,
                (Profit.profitPercentage(PizzaCost.getCostFourCheese()))) + "$");
        System.out.println("Profit: " + orderStatistics.getProfit(Pizza.FOUR_CHEESE, numberOfFourCheeseSold,
                Profit.profitPercentage(PizzaCost.getCostFourCheese()), PizzaCost.getCostFourCheese()) + "$");

        System.out.println("\nPizzas 'Margherita':");
        System.out.println("Number of sold pizzas: " + orderStatistics.getNumberOfPizzasSold
                (Pizza.MARGHERITA, numberOfMargheritaSold));
        System.out.println("Revenue: " + orderStatistics.getRevenue(Pizza.MARGHERITA, numberOfMargheritaSold,
                Profit.profitPercentage(PizzaCost.getCostMargherita())) + "$");
        System.out.println("Profit: " + orderStatistics.getProfit(Pizza.MARGHERITA, numberOfMargheritaSold,
                Profit.profitPercentage(PizzaCost.getCostMargherita()), PizzaCost.getCostMargherita()) + "$");

        System.out.println("\nPizzas 'MeatDelight':");
        System.out.println("Number of sold pizzas: " + orderStatistics.getNumberOfPizzasSold
                (Pizza.MEAT_DELIGHT, numberOfMeatDelightSold));
        System.out.println("Revenue: " + orderStatistics.getRevenue(Pizza.MEAT_DELIGHT, numberOfMeatDelightSold,
                Profit.profitPercentage(PizzaCost.getCostMeatDelight())) + "$");
        System.out.println("Profit: " + orderStatistics.getProfit(Pizza.MEAT_DELIGHT, numberOfMeatDelightSold,
                Profit.profitPercentage(PizzaCost.getCostMeatDelight()), PizzaCost.getCostMeatDelight()) + "$");

        System.out.println("\nPizzas 'Pepperoni':");
        System.out.println("Number of sold pizzas: " + orderStatistics.getNumberOfPizzasSold
                (Pizza.PEPPERONI, numberOfPepperoniSold));
        System.out.println("Revenue: " + orderStatistics.getRevenue(Pizza.PEPPERONI, numberOfPepperoniSold,
                Profit.profitPercentage(PizzaCost.getCostPepperoni())) + "$");
        System.out.println("Profit: " + orderStatistics.getProfit(Pizza.PEPPERONI, numberOfPepperoniSold,
                Profit.profitPercentage(PizzaCost.getCostPepperoni()), PizzaCost.getCostPepperoni()) + "$");

        System.out.println("\nPizzas 'Vegetarian':");
        System.out.println("Number of sold pizzas: " + orderStatistics.getNumberOfPizzasSold
                (Pizza.VEGETARIAN, numberOfVegetarianSold));
        System.out.println("Revenue: " + orderStatistics.getRevenue(Pizza.VEGETARIAN, numberOfVegetarianSold,
                Profit.profitPercentage(PizzaCost.getCostVegetarian())) + "$");
        System.out.println("Profit: " + orderStatistics.getProfit(Pizza.VEGETARIAN, numberOfVegetarianSold,
                Profit.profitPercentage(PizzaCost.getCostVegetarian()), PizzaCost.getCostVegetarian()) + "$");
    }
}