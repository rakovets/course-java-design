package com.rakovets.course.design.practice.solid.pizza.controller;

import com.rakovets.course.design.practice.solid.pizza.model.Ingredient;
import com.rakovets.course.design.practice.solid.pizza.repository.StorageRepository;

import java.util.Map;

public class StorageUtilityController {

    public static void main(String[] args) {

        StorageRepository storage = new StorageRepository();

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