package com.rakovets.course.design.practice.solid.pizza.view;

import com.rakovets.course.design.practice.solid.pizza.exceptions.OrderStatisticsException;
import com.rakovets.course.design.practice.solid.pizza.service.OrderStatisticsService;
import com.rakovets.course.design.practice.solid.pizza.util.RoundUtil;

public class OrderStatisticsViewConsole implements OrderStatisticsView {
    private static final OrderStatisticsService ORDER_STATISTICS;
    private static final OrderStatisticsException ORDER_STATISTICS_EXCEPTION;

    static {
        ORDER_STATISTICS = new OrderStatisticsService();
        ORDER_STATISTICS_EXCEPTION = new OrderStatisticsException();
    }

    public void enterFourCheese() {
        System.out.println("Enter number of Pizzas 'Four Cheese' sold:");
    }

    public void enterMargherita() {
        System.out.println("Enter number of Pizzas 'Margherita' sold:");
    }

    public void enterMeatDelight() {
        System.out.println("Enter number of Pizzas 'Meat Delight' sold:");
    }

    public void enterPepperoni() {
        System.out.println("Enter number of Pizzas 'Pepperoni' sold:");
    }

    public void enterVegetarian() {
        System.out.println("Enter number of Pizzas 'Vegetarian' sold:");
    }

    public void orderStatisticsException() {
        System.out.println(ORDER_STATISTICS_EXCEPTION.toString());
    }

    public void pizzasSold() {
        System.out.println();
        System.out.println("ORDER STATISTICS:");
        System.out.println();
        System.out.println("Sold Pizzas 'Four Cheese': " + ORDER_STATISTICS.pizzasSold().get(0));
        System.out.println("Sold Pizzas 'Margherita': " + ORDER_STATISTICS.pizzasSold().get(1));
        System.out.println("Sold Pizzas 'Meat Delight': " + ORDER_STATISTICS.pizzasSold().get(2));
        System.out.println("Sold Pizzas 'Pepperoni': " + ORDER_STATISTICS.pizzasSold().get(3));
        System.out.println("Sold Pizzas 'Vegetarian': " + ORDER_STATISTICS.pizzasSold().get(4));
    }

    public void totalPizzasSold() {
        System.out.println("Total pizzas sold: " + ORDER_STATISTICS.totalPizzasSold());
        System.out.println();
    }

    public void pizzasRevenue() {
        System.out.println("Revenue from Pizzas 'Four Cheese': " +
                RoundUtil.up(ORDER_STATISTICS.pizzasSold().get(0)) *
                        ORDER_STATISTICS.pizzasPrices().get(0) + "$");
        System.out.println("Revenue from Pizzas 'Margherita': " +
                RoundUtil.up(ORDER_STATISTICS.pizzasSold().get(1) *
                        ORDER_STATISTICS.pizzasPrices().get(1)) + "$");
        System.out.println("Revenue from Pizzas 'Meat Delight': " +
                RoundUtil.up(ORDER_STATISTICS.pizzasSold().get(2) *
                        ORDER_STATISTICS.pizzasPrices().get(2)) + "$");
        System.out.println("Revenue from Pizzas 'Pepperoni': " +
                RoundUtil.up(ORDER_STATISTICS.pizzasSold().get(3) *
                        ORDER_STATISTICS.pizzasPrices().get(3)) + "$");
        System.out.println("Revenue from Pizzas 'Vegetarian': " +
                RoundUtil.up(ORDER_STATISTICS.pizzasSold().get(4) *
                        ORDER_STATISTICS.pizzasPrices().get(4)) + "$");
    }

    public void totalRevenue() {
        System.out.println("Total revenue is " + ORDER_STATISTICS.totalRevenue() + "$");
        System.out.println();
    }

    public void averageCheck() {
        System.out.println("Average check is " + ORDER_STATISTICS.averageCheck() + "$");
    }

    public void totalProfit() {
        System.out.println("Total profit is " + ORDER_STATISTICS.totalProfit() + "$");
    }

    public void profitMargin() {
        System.out.println("Profit margin is " + ORDER_STATISTICS.profitMargin() + "%");
    }
}
