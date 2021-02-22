package com.rakovets.course.design.practice.solid.Pizza.Pizzas;

import com.rakovets.course.design.practice.solid.Pizza.Finance.Profit;
import com.rakovets.course.design.practice.solid.Pizza.Ingredients.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MeatDelight implements Pizza {
    int sauceQuantity = 1;
    int cheeseQuantity = 1;
    int meatQuantity = 2;
    int sausagesQuantity = 2;

    TraditionalDough traditionalDough = new TraditionalDough();
    Sauce sauce = new Sauce();
    Cheese cheese = new Cheese();
    Meat meat = new Meat();
    Sausages sausages = new Sausages();
    Profit profit = new Profit();

    public double getExpenses() {
        return traditionalDough.getPrice() +
                sauce.getPrice() * sauceQuantity +
                cheese.getPrice() * cheeseQuantity +
                meat.getPrice() * meatQuantity +
                sausages.getPrice() * sausagesQuantity;
    }

    public double getPrice() {
        return BigDecimal.valueOf(
                profit.profitPercentage(getExpenses())).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public String toString() {
        return "Pizza 'Meat Delight'\tPrice: " + getPrice() + "$";
    }
}