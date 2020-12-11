package com.rakovets.course.design.practice.pizzeria.repository;

import java.util.Map;
import java.util.stream.Collectors;

public class Storage {
    private static Map<String, Integer> ingredients;

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
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> e : ingredients.entrySet()) {
            result.append("\n").append(e.getKey()).append(" ").append(e.getValue()).append("g");
        }
       return result.toString();
    }
}
