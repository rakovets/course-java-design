package com.rakovets.course.design.practice.pizzeria.repository;

import com.rakovets.course.design.practice.pizzeria.service.Loader;

import java.util.Map;
import java.util.stream.Collectors;

public class Storage {
    private static Map<String, Integer> ingredients;

    public static void start() {
        ingredients = Loader.loadIngredients();
    }

    public static Map<String, Integer> getIngredients() {
        return ingredients;
    }

    public static void setIngredients(Map<String, Integer> ingredients) {
        Storage.ingredients = ingredients;
    }

    public static void checkIngredients() {
        for (Map.Entry<String, Integer> entry : ingredients.entrySet()) {
            if (entry.getValue() < 100) {
                System.out.println(entry.getKey() + " ends!");
            }
        }
    }

    public static String printIngredients() {
       return ingredients.entrySet().stream()
                .map(e -> "\n" + e.getKey() + " " + e.getValue() + "g")
                .collect(Collectors.joining());
    }
}
