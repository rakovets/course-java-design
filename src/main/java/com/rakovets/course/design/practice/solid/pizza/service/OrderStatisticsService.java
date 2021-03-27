package com.rakovets.course.design.practice.solid.pizza.service;

import com.rakovets.course.design.practice.solid.pizza.controller.OrderStatisticsController;
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

    public int totalPizzasSold() {
        return OrderStatisticsController.SOLD_PIZZAS
                .keySet()
                .stream()
                .mapToInt(Integer::intValue)
                .reduce(0, Integer::sum);
    }

    public double totalRevenue() {
        return RoundUpService.roundUp(OrderStatisticsController.SOLD_PIZZAS
                .entrySet()
                .stream()
                .mapToDouble((e) -> (e.getKey() * e.getValue()))
                .sum());
    }

    public double averageCheck() {
        return RoundUpService.roundUp(totalRevenue() / totalPizzasSold());
    }
}
