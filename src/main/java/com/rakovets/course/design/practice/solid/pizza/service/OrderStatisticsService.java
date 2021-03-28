package com.rakovets.course.design.practice.solid.pizza.service;

import com.rakovets.course.design.practice.solid.pizza.controller.OrderStatisticsController;
import com.rakovets.course.design.practice.solid.pizza.util.PizzaCostUtil;
import com.rakovets.course.design.practice.solid.pizza.util.PizzaPriceUtil;
import com.rakovets.course.design.practice.solid.pizza.util.RoundUtil;

import java.util.HashMap;
import java.util.Map;

public class OrderStatisticsService {
    private static final Map<Integer, Double> PIZZAS_PRICES;
    private static final Map<Integer, Double> PIZZAS_COST;

    static {
        PIZZAS_PRICES = new HashMap<>();
        PIZZAS_PRICES.put(1, PizzaPriceUtil.pricePizzaFourCheeseIncludingVAT());
        PIZZAS_PRICES.put(2, PizzaPriceUtil.pricePizzaMargheritaIncludingVAT());
        PIZZAS_PRICES.put(3, PizzaPriceUtil.pricePizzaMeatDelightIncludingVAT());
        PIZZAS_PRICES.put(4, PizzaPriceUtil.pricePizzaPepperoniIncludingVAT());
        PIZZAS_PRICES.put(5, PizzaPriceUtil.pricePizzaVegetarianIncludingVAT());

        PIZZAS_COST = new HashMap<>();
        PIZZAS_COST.put(1, PizzaCostUtil.getCostFourCheese());
        PIZZAS_COST.put(2, PizzaCostUtil.getCostMargherita());
        PIZZAS_COST.put(3, PizzaCostUtil.getCostMeatDelight());
        PIZZAS_COST.put(4, PizzaCostUtil.getCostPepperoni());
        PIZZAS_COST.put(5, PizzaCostUtil.getCostVegetarian());
    }

    public int totalPizzasSold() {
        return OrderStatisticsController.SOLD_PIZZAS
                .values()
                .stream()
                .mapToInt(Integer::intValue)
                .reduce(0, Integer::sum);
    }

    public double totalRevenue() {
        double sum = 0;
        for (Integer key : OrderStatisticsController.SOLD_PIZZAS.keySet()) {
            double value1 = OrderStatisticsController.SOLD_PIZZAS.get(key);
            double value2 = PIZZAS_PRICES.get(key);
            sum += value1 * value2;
        }
        return RoundUtil.up(sum);
    }

    public double averageCheck() {
        return RoundUtil.up(totalRevenue() / totalPizzasSold());
    }

    public double totalCost() {
        double sum = 0;
        for (Integer key : OrderStatisticsController.SOLD_PIZZAS.keySet()) {
            double value1 = OrderStatisticsController.SOLD_PIZZAS.get(key);
            double value2 = PIZZAS_COST.get(key);
            sum += value1 * value2;
        }
        return RoundUtil.up(sum);
    }

    public double totalProfit() {
        return RoundUtil.up(totalRevenue() - totalCost());
    }

    public double profitMargin() {
        return RoundUtil.up(totalProfit() / totalRevenue() * 100);
    }
}
