package com.rakovets.course.design.practice.solid.PizzaEnum.Order;

import com.rakovets.course.design.practice.solid.PizzaEnum.Pizzas.Pizza;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class OrderStatistics {

    public int getNumberOfPizzasSold(Pizza pizza, int numberOfPizzasSold) {
        return numberOfPizzasSold;
    }

    public double getRevenue(Pizza pizza, int numberOfPizzasSold, double price) {
        return BigDecimal.valueOf(getNumberOfPizzasSold(pizza, numberOfPizzasSold) * price)
                .setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public double getProfit(Pizza pizza, int numberOfPizzasSold, double price, double expenses) {
        return BigDecimal.valueOf(getNumberOfPizzasSold(pizza, numberOfPizzasSold) * price
                - getNumberOfPizzasSold(pizza, numberOfPizzasSold)
                * expenses).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}