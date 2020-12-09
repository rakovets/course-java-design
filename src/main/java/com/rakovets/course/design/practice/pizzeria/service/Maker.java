package com.rakovets.course.design.practice.pizzeria.service;

import com.rakovets.course.design.practice.pizzeria.model.Pizza;
import com.rakovets.course.design.practice.pizzeria.repository.Storage;

import java.util.Map;

public class Maker {
    public static void makePizza(Pizza pizza) {
        Map<String, Integer> storageIngredients = Storage.getIngredients();
        Map<String, Integer> pizzaIngredients = pizza.getIngredients();
        for (Map.Entry<String, Integer> storageEntry : storageIngredients.entrySet()) {
            for (Map.Entry<String, Integer> pizzaEntry : pizzaIngredients.entrySet()) {
                if (storageEntry.getKey().equals(pizzaEntry.getKey())) {
                    storageEntry.setValue(storageEntry.getValue() - pizzaEntry.getValue());
                }
            }
        }
        Storage.setIngredients(storageIngredients);
    }
}
