package com.rakovets.course.design.practice.solid.Pizza.Order;

import com.rakovets.course.design.practice.solid.Pizza.Pizzas.*;

public class OrderStatisticsUtil {
    public static void main(String[] args) {

        FourCheese fourCheese = new FourCheese();
        Margherita margherita = new Margherita();
        MeatDelight meatDelight = new MeatDelight();
        Pepperoni pepperoni = new Pepperoni();
        Vegetarian vegetarian = new Vegetarian();
        OrderStatistics orderStatistics = new OrderStatistics();

        System.out.println("\nPizzas 'Four Cheese':");
        System.out.println("Number of sold pizzas: " + orderStatistics.getNumberOfPizzasSold
                (fourCheese, 100));
        System.out.println("Revenue: " + orderStatistics.getRevenue(fourCheese, 100,
                fourCheese.getPrice()) + "$");
        System.out.println("Profit: " + orderStatistics.getProfit(fourCheese, 100,
                fourCheese.getPrice(), fourCheese.getExpenses()) + "$");

        System.out.println("\nPizzas 'Margherita':");
        System.out.println("Number of sold pizzas: " + orderStatistics.getNumberOfPizzasSold
                (margherita, 100));
        System.out.println("Revenue: " + orderStatistics.getRevenue(margherita, 100,
                margherita.getPrice()) + "$");
        System.out.println("Profit: " + orderStatistics.getProfit(margherita, 100,
                margherita.getPrice(), margherita.getExpenses()) + "$");

        System.out.println("\nPizzas 'MeatDelight':");
        System.out.println("Number of sold pizzas: " + orderStatistics.getNumberOfPizzasSold
                (meatDelight, 100));
        System.out.println("Revenue: " + orderStatistics.getRevenue(meatDelight, 100,
                meatDelight.getPrice()) + "$");
        System.out.println("Profit: " + orderStatistics.getProfit(meatDelight, 100,
                meatDelight.getPrice(), meatDelight.getExpenses()) + "$");

        System.out.println("\nPizzas 'Pepperoni':");
        System.out.println("Number of sold pizzas: " + orderStatistics.getNumberOfPizzasSold
                (pepperoni, 100));
        System.out.println("Revenue: " + orderStatistics.getRevenue(pepperoni, 100,
                pepperoni.getPrice()) + "$");
        System.out.println("Profit: " + orderStatistics.getProfit(pepperoni, 100,
                pepperoni.getPrice(), pepperoni.getExpenses()) + "$");

        System.out.println("\nPizzas 'Vegetarian':");
        System.out.println("Number of sold pizzas: " + orderStatistics.getNumberOfPizzasSold
                (vegetarian, 100));
        System.out.println("Revenue: " + orderStatistics.getRevenue(vegetarian, 100,
                vegetarian.getPrice()) + "$");
        System.out.println("Profit: " + orderStatistics.getProfit(vegetarian, 100,
                vegetarian.getPrice(), vegetarian.getExpenses()) + "$");

    }
}