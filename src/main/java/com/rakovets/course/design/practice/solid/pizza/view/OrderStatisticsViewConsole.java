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

    public void pizzasRevenue() {
        System.out.println("Revenue of Pizzas 'Four Cheese': " +
                RoundUtil.up(ORDER_STATISTICS.pizzasRevenue()[0]) + "$");
        System.out.println("Revenue of Pizzas: 'Margherita': " +
                RoundUtil.up(ORDER_STATISTICS.pizzasRevenue()[1]) + "$");
        System.out.println("Revenue of Pizzas: 'Meat Delight': " +
                RoundUtil.up(ORDER_STATISTICS.pizzasRevenue()[2]) + "$");
        System.out.println("Revenue of Pizzas: 'Pepperoni': " +
                RoundUtil.up(ORDER_STATISTICS.pizzasRevenue()[3]) + "$");
        System.out.println("Revenue of Pizzas: 'Vegetarian': " +
                RoundUtil.up(ORDER_STATISTICS.pizzasRevenue()[4]) + "$");
    }

    public void totalPizzasSold() {
        System.out.println("Total pizzas sold: " + ORDER_STATISTICS.totalPizzasSold());
    }

    public void totalRevenue() {
        System.out.println("Total revenue is " + ORDER_STATISTICS.totalRevenue() + "$");
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
