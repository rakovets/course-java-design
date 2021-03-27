package com.rakovets.course.design.practice.solid.pizza.service;

import com.rakovets.course.design.practice.solid.pizza.controller.OrderStatisticsController;
import com.rakovets.course.design.practice.solid.pizza.model.Pizza;

public class OrderStatisticsService {
    private static final PizzaPriceService PIZZA_PRICE;

    static {
        PIZZA_PRICE = new PizzaPriceService();
    }

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
        return OrderStatisticsController.numberOfFourCheeseSold +
                OrderStatisticsController.numberOfMargheritaSold +
                OrderStatisticsController.numberOfMeatDelightSold +
                OrderStatisticsController.numberOfPepperoniSold +
                OrderStatisticsController.numberOfVegetarianSold;
    }

    public double totalRevenue() {
        return RoundUpService.roundUp(OrderStatisticsController.numberOfFourCheeseSold *
                PIZZA_PRICE.pricePizzaFourCheeseIncludingVAT() +
                OrderStatisticsController.numberOfMargheritaSold *
                        PIZZA_PRICE.pricePizzaMargheritaIncludingVAT() +
                OrderStatisticsController.numberOfMeatDelightSold *
                        PIZZA_PRICE.pricePizzaMeatDelightIncludingVAT() +
                OrderStatisticsController.numberOfPepperoniSold *
                        PIZZA_PRICE.pricePizzaPepperoniIncludingVAT() +
                OrderStatisticsController.numberOfVegetarianSold *
                        PIZZA_PRICE.pricePizzaVegetarianIncludingVAT());
    }

    public double averageCheck() {
        return RoundUpService.roundUp(totalRevenue() / totalPizzasSold());
    }
}
