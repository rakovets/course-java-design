package com.rakovets.course.design.practice.solid.Pizza.Pizzas;

import com.rakovets.course.design.practice.solid.Pizza.Finance.Profit;
import com.rakovets.course.design.practice.solid.Pizza.Ingredients.Cheese;
import com.rakovets.course.design.practice.solid.Pizza.Ingredients.Meat;
import com.rakovets.course.design.practice.solid.Pizza.Ingredients.Sauce;
import com.rakovets.course.design.practice.solid.Pizza.Ingredients.TraditionalDough;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Pepperoni implements Pizza {
    int sauceQuantity = 1;
    int meatQuantity = 3;
    int cheeseQuantity = 1;

    TraditionalDough traditionalDough = new TraditionalDough();
    Sauce sauce = new Sauce();
    Meat meat = new Meat();
    Cheese cheese = new Cheese();
    Profit profit = new Profit();

    public double getExpenses() {
        return traditionalDough.getPrice() +
                sauce.getPrice() * sauceQuantity +
                meat.getPrice() * meatQuantity +
                cheese.getPrice() * cheeseQuantity;
    }

    public double getPrice() {
        return BigDecimal.valueOf(
                profit.profitPercentage(getExpenses())).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public String toString() {
        return "Pizza 'Pepperoni'\tPrice: " + getPrice() + "$";
    }
}