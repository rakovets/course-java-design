package com.rakovets.course.design.practice.solid.Pizza.Pizzas;

import com.rakovets.course.design.practice.solid.Pizza.Finance.Profit;
import com.rakovets.course.design.practice.solid.Pizza.Ingredients.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Margherita implements Pizza {
    int sauceQuantity = 1;
    int cheeseQuantity = 2;
    int tomatoesQuantity = 2;
    int oreganoQuantity = 1;

    TraditionalDough traditionalDough = new TraditionalDough();
    Sauce sauce = new Sauce();
    Cheese cheese = new Cheese();
    Tomatoes tomatoes = new Tomatoes();
    Oregano oregano = new Oregano();
    Profit profit = new Profit();

    public double getExpenses() {
        return traditionalDough.getPrice() +
                sauce.getPrice() * sauceQuantity +
                cheese.getPrice() * cheeseQuantity +
                tomatoes.getPrice() * tomatoesQuantity +
                oregano.getPrice() * oreganoQuantity;
    }

    public double getPrice() {
        return BigDecimal.valueOf(
                profit.profitPercentage(getExpenses())).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public String toString() {
        return "Pizza 'Margherita'\tPrice: " + getPrice() + "$";
    }
}