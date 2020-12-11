package com.racovets.course.design.practice.pizzeria;

import com.racovets.course.design.practice.pizzeria.model.Ingredients;
import com.rakovets.course.design.example.pattern.strategy.example.order.Order;

import java.util.*;

public class Accounting {
    private Map<Integer, OrderPizza> orders = new HashMap<>();
    private Map<Ingredients, Integer> receiptIngredients = new HashMap<>();

    public int getProfit() {
        int ingredientsCost = 0;
        for (Map.Entry<Ingredients, Integer> item : receiptIngredients.entrySet()) {
            ingredientsCost = ingredientsCost + (item.getValue() * item.getKey().getPrice());
        }
        return getProceeds() - ingredientsCost;
    }

    public int getNumberOfSoldPizza() {
        int numberOfSoldPizza = 0;
        if (!orders.isEmpty()) {
            for (Map.Entry<Integer, OrderPizza> item : orders.entrySet()) {
                numberOfSoldPizza += item.getValue().getTotalPizzaCountInOrder();
            }
        } return numberOfSoldPizza;
    }
    public int getProceeds() {
        int proceeds = 0;
        if (!orders.isEmpty()) {
            for (Map.Entry<Integer, OrderPizza> item : orders.entrySet()) {
                proceeds += item.getValue().getTotalCostWithDiscount();
            }
        } return proceeds;
    }

    public Map<Integer, OrderPizza> getOrders() {
        return orders;
    }

    public Map<Ingredients, Integer> getReceiptIngredients() {
        return receiptIngredients;
    }
}
