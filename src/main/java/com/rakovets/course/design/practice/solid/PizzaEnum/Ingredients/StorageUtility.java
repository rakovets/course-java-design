package com.rakovets.course.design.practice.solid.PizzaEnum.Ingredients;

import java.util.Map;

public class StorageUtility {

    public static void main(String[] args) {

        Storage storage = new Storage();

        for (Map.Entry<Ingredient, Integer> entry : storage.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        for (Map.Entry<Ingredient, Integer> entry : storage.entrySet()) {
            Integer value = entry.getValue();
            if (value <= 10)
                System.out.println("Ingredient " + entry.getKey() + " is running out, quantity is " + entry.getValue());
        }
    }
}