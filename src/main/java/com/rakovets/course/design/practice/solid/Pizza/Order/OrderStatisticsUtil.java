package com.rakovets.course.design.practice.solid.Pizza.Order;

import com.rakovets.course.design.practice.solid.Pizza.Pizzas.*;

public class OrderStatisticsUtil {
    public static void main(String[] args) {

        int numberOfFourCheeseSold = 100;
        int numberOfMargheritaSold = 100;
        int numberOfMeatDelightSold = 100;
        int numberOfPepperoniSold = 100;
        int numberOfVegetarianSold = 100;

        FourCheese fourCheese = new FourCheese();
        Margherita margherita = new Margherita();
        MeatDelight meatDelight = new MeatDelight();
        Pepperoni pepperoni = new Pepperoni();
        Vegetarian vegetarian = new Vegetarian();
        OrderStatistics orderStatistics = new OrderStatistics();

        System.out.println("\nPizzas 'Four Cheese':");
        System.out.println("Number of sold pizzas: " + orderStatistics.getNumberOfPizzasSold
                (fourCheese, numberOfFourCheeseSold));
        System.out.println("Revenue: " + orderStatistics.getRevenue(fourCheese, numberOfFourCheeseSold,
                fourCheese.getPrice()) + "$");
        System.out.println("Profit: " + orderStatistics.getProfit(fourCheese, numberOfFourCheeseSold,
                fourCheese.getPrice(), fourCheese.getExpenses()) + "$");

        System.out.println("\nPizzas 'Margherita':");
        System.out.println("Number of sold pizzas: " + orderStatistics.getNumberOfPizzasSold
                (margherita, numberOfMargheritaSold));
        System.out.println("Revenue: " + orderStatistics.getRevenue(margherita, numberOfMargheritaSold,
                margherita.getPrice()) + "$");
        System.out.println("Profit: " + orderStatistics.getProfit(margherita, numberOfMargheritaSold,
                margherita.getPrice(), margherita.getExpenses()) + "$");

        System.out.println("\nPizzas 'MeatDelight':");
        System.out.println("Number of sold pizzas: " + orderStatistics.getNumberOfPizzasSold
                (meatDelight, numberOfMeatDelightSold));
        System.out.println("Revenue: " + orderStatistics.getRevenue(meatDelight, numberOfMeatDelightSold,
                meatDelight.getPrice()) + "$");
        System.out.println("Profit: " + orderStatistics.getProfit(meatDelight, numberOfMeatDelightSold,
                meatDelight.getPrice(), meatDelight.getExpenses()) + "$");

        System.out.println("\nPizzas 'Pepperoni':");
        System.out.println("Number of sold pizzas: " + orderStatistics.getNumberOfPizzasSold
                (pepperoni, numberOfPepperoniSold));
        System.out.println("Revenue: " + orderStatistics.getRevenue(pepperoni, numberOfPepperoniSold,
                pepperoni.getPrice()) + "$");
        System.out.println("Profit: " + orderStatistics.getProfit(pepperoni, numberOfPepperoniSold,
                pepperoni.getPrice(), pepperoni.getExpenses()) + "$");

        System.out.println("\nPizzas 'Vegetarian':");
        System.out.println("Number of sold pizzas: " + orderStatistics.getNumberOfPizzasSold
                (vegetarian, numberOfVegetarianSold));
        System.out.println("Revenue: " + orderStatistics.getRevenue(vegetarian, numberOfVegetarianSold,
                vegetarian.getPrice()) + "$");
        System.out.println("Profit: " + orderStatistics.getProfit(vegetarian, numberOfVegetarianSold,
                vegetarian.getPrice(), vegetarian.getExpenses()) + "$");

    }
}