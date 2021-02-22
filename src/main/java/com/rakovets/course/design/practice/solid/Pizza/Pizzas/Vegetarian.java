package com.rakovets.course.design.practice.solid.Pizza.Pizzas;

import com.rakovets.course.design.practice.solid.Pizza.Finance.Profit;
import com.rakovets.course.design.practice.solid.Pizza.Ingredients.*;
import com.rakovets.course.design.practice.solid.Pizza.Ingredients.TraditionalDough;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Vegetarian implements Pizza {
    int sauceQuantity = 2;
    int cheeseQuantity = 1;
    int tomatoesQuantity = 2;
    int pepperQuantity = 2;
    int olivesQuantity = 2;

    TraditionalDough traditionalDough = new TraditionalDough();
    Sauce sauce = new Sauce();
    Cheese cheese = new Cheese();
    Tomatoes tomatoes = new Tomatoes();
    Pepper pepper = new Pepper();
    Olives olives = new Olives();
    Profit profit = new Profit();

    public double getExpenses() {
        return traditionalDough.getPrice() +
                sauce.getPrice() * sauceQuantity +
                cheese.getPrice() * cheeseQuantity +
                tomatoes.getPrice() * tomatoesQuantity +
                pepper.getPrice() * pepperQuantity +
                olives.getPrice() * olivesQuantity;
    }

    public double getPrice() {
        return BigDecimal.valueOf(
                profit.profitPercentage(getExpenses())).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public String toString() {
        return "Pizza 'Vegetarian'\tPrice: " + getPrice() + "$";
    }
}