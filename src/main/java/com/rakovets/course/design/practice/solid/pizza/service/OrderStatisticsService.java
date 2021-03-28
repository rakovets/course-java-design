package com.rakovets.course.design.practice.solid.pizza.service;

import com.rakovets.course.design.practice.solid.pizza.controller.OrderStatisticsController;
import com.rakovets.course.design.practice.solid.pizza.util.RoundUtil;

public class OrderStatisticsService {

    public int totalPizzasSold() {
        return OrderStatisticsController.SOLD_PIZZAS_REVENUE
                .keySet()
                .stream()
                .mapToInt(Integer::intValue)
                .reduce(0, Integer::sum);
    }

    public double[] pizzasRevenue() {
        return OrderStatisticsController.SOLD_PIZZAS_REVENUE
                .entrySet()
                .stream()
                .mapToDouble((e) -> (e.getKey() * e.getValue())).toArray();
    }

    public double totalRevenue() {
        return RoundUtil.up(OrderStatisticsController.SOLD_PIZZAS_REVENUE
                .entrySet()
                .stream()
                .mapToDouble((e) -> (e.getKey() * e.getValue()))
                .sum());
    }

    public double averageCheck() {
        return RoundUtil.up(totalRevenue() / totalPizzasSold());
    }

    public double totalCost() {
        return RoundUtil.up(OrderStatisticsController.SOLD_PIZZAS_COST
                .entrySet()
                .stream()
                .mapToDouble((e) -> (e.getKey() * e.getValue()))
                .sum());
    }

    public double totalProfit() {
        return RoundUtil.up(totalRevenue() - totalCost());
    }

    public double profitMargin() {
        return RoundUtil.up(totalProfit() / totalRevenue() * 100);
    }
}
