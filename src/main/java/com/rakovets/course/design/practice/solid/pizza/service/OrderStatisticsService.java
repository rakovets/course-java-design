package com.rakovets.course.design.practice.solid.pizza.service;

import com.rakovets.course.design.practice.solid.pizza.model.Pizza;

public class OrderStatisticsService {

    public int getNumberOfPizzasSold(Pizza pizza, int numberOfPizzasSold) {
        return numberOfPizzasSold;
    }

    public double getRevenue(Pizza pizza, int numberOfPizzasSold, double price) {
        return RoundUpService.roundUp(getNumberOfPizzasSold(pizza, numberOfPizzasSold) * price);
    }

    public double getProfit(Pizza pizza, int numberOfPizzasSold, double price, double expenses) {
        return RoundUpService.roundUp(getNumberOfPizzasSold(pizza, numberOfPizzasSold) * price
                - getNumberOfPizzasSold(pizza, numberOfPizzasSold)
                * expenses);
    }
}