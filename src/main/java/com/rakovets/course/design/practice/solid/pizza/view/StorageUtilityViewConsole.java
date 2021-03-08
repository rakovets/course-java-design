package com.rakovets.course.design.practice.solid.pizza.view;

import com.rakovets.course.design.practice.solid.pizza.model.Ingredient;
import com.rakovets.course.design.practice.solid.pizza.repository.StorageRepository;

import java.util.Map;

public class StorageUtilityViewConsole implements StorageUtilityView {
    private static final StorageRepository storage;

    static {

        storage = new StorageRepository();

    }

    public void displayStorage() {
        for (Map.Entry<Ingredient, Integer> entry : storage.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public void showLackOfIngredients() {
        for (Map.Entry<Ingredient, Integer> entry : storage.entrySet()) {
            Integer value = entry.getValue();
            if (value <= 10)
                System.out.println("Ingredient " + entry.getKey() + " is running out, quantity is " + entry.getValue());
        }
    }
}
