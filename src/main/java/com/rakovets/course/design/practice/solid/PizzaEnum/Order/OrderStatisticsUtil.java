package com.rakovets.course.design.practice.solid.PizzaEnum.Order;

import com.rakovets.course.design.practice.solid.PizzaEnum.Finance.Profit;
import com.rakovets.course.design.practice.solid.PizzaEnum.Pizzas.*;

public class OrderStatisticsUtil {
    public static void main(String[] args) {

        int numberOfFourCheeseSold = 100;
        int numberOfMargheritaSold = 100;
        int numberOfMeatDelightSold = 100;
        int numberOfPepperoniSold = 100;
        int numberOfVegetarianSold = 100;

        OrderStatistics orderStatistics = new OrderStatistics();
        Profit profit = new Profit();

        System.out.println("\nPizzas 'Four Cheese':");
        System.out.println("Number of sold pizzas: " + orderStatistics.getNumberOfPizzasSold
                (Pizza.FOUR_CHEESE, numberOfFourCheeseSold));
        System.out.println("Revenue: " + orderStatistics.getRevenue(Pizza.FOUR_CHEESE, numberOfFourCheeseSold,
                (profit.profitPercentage(Pizza.FOUR_CHEESE.getCost()))) + "$");
        System.out.println("Profit: " + orderStatistics.getProfit(Pizza.FOUR_CHEESE, numberOfFourCheeseSold,
                profit.profitPercentage(Pizza.FOUR_CHEESE.getCost()), Pizza.FOUR_CHEESE.getCost()) + "$");

        System.out.println("\nPizzas 'Margherita':");
        System.out.println("Number of sold pizzas: " + orderStatistics.getNumberOfPizzasSold
                (Pizza.MARGHERITA, numberOfMargheritaSold));
        System.out.println("Revenue: " + orderStatistics.getRevenue(Pizza.MARGHERITA, numberOfMargheritaSold,
                profit.profitPercentage(Pizza.MARGHERITA.getCost())) + "$");
        System.out.println("Profit: " + orderStatistics.getProfit(Pizza.MARGHERITA, numberOfMargheritaSold,
                profit.profitPercentage(Pizza.MARGHERITA.getCost()), Pizza.MARGHERITA.getCost()) + "$");

        System.out.println("\nPizzas 'MeatDelight':");
        System.out.println("Number of sold pizzas: " + orderStatistics.getNumberOfPizzasSold
                (Pizza.MEAT_DELIGHT, numberOfMeatDelightSold));
        System.out.println("Revenue: " + orderStatistics.getRevenue(Pizza.MEAT_DELIGHT, numberOfMeatDelightSold,
                profit.profitPercentage(Pizza.MEAT_DELIGHT.getCost())) + "$");
        System.out.println("Profit: " + orderStatistics.getProfit(Pizza.MEAT_DELIGHT, numberOfMeatDelightSold,
                profit.profitPercentage(Pizza.MEAT_DELIGHT.getCost()), Pizza.MEAT_DELIGHT.getCost()) + "$");

        System.out.println("\nPizzas 'Pepperoni':");
        System.out.println("Number of sold pizzas: " + orderStatistics.getNumberOfPizzasSold
                (Pizza.PEPPERONI, numberOfPepperoniSold));
        System.out.println("Revenue: " + orderStatistics.getRevenue(Pizza.PEPPERONI, numberOfPepperoniSold,
                profit.profitPercentage(Pizza.PEPPERONI.getCost())) + "$");
        System.out.println("Profit: " + orderStatistics.getProfit(Pizza.PEPPERONI, numberOfPepperoniSold,
                profit.profitPercentage(Pizza.PEPPERONI.getCost()), Pizza.PEPPERONI.getCost()) + "$");

        System.out.println("\nPizzas 'Vegetarian':");
        System.out.println("Number of sold pizzas: " + orderStatistics.getNumberOfPizzasSold
                (Pizza.VEGETARIAN, numberOfVegetarianSold));
        System.out.println("Revenue: " + orderStatistics.getRevenue(Pizza.VEGETARIAN, numberOfVegetarianSold,
                profit.profitPercentage(Pizza.VEGETARIAN.getCost())) + "$");
        System.out.println("Profit: " + orderStatistics.getProfit(Pizza.VEGETARIAN, numberOfVegetarianSold,
                profit.profitPercentage(Pizza.VEGETARIAN.getCost()), Pizza.VEGETARIAN.getCost()) + "$");

    }

}