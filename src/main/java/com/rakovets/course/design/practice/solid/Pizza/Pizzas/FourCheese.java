package com.rakovets.course.design.practice.solid.Pizza.Pizzas;

import com.rakovets.course.design.practice.solid.Pizza.Finance.Profit;
import com.rakovets.course.design.practice.solid.Pizza.Ingredients.Cheese;
import com.rakovets.course.design.practice.solid.Pizza.Ingredients.Oregano;
import com.rakovets.course.design.practice.solid.Pizza.Ingredients.Sauce;
import com.rakovets.course.design.practice.solid.Pizza.Ingredients.TraditionalDough;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FourCheese implements Pizza {
    int sauceQuantity = 1;
    int cheeseQuantity = 4;
    int oreganoQuantity = 1;

    TraditionalDough traditionalDough = new TraditionalDough();
    Sauce sauce = new Sauce();
    Cheese cheese = new Cheese();
    Oregano oregano = new Oregano();
    Profit profit = new Profit();

    public double getExpenses() {
        return traditionalDough.getPrice() +
                sauce.getPrice() * sauceQuantity +
                cheese.getPrice() * cheeseQuantity +
                oregano.getPrice() * oreganoQuantity;
    }

    public double getPrice() {
        return BigDecimal.valueOf(
                profit.profitPercentage(getExpenses())).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public String toString() {
        return "Pizza 'Four Cheese'\tPrice: " + getPrice() + "$";
    }
}