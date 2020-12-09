package com.rakovets.course.design.practice.pizzeria.model;

import com.rakovets.course.design.practice.pizzeria.service.Loader;

import java.util.Map;
import java.util.stream.Collectors;

public class Pizza extends Product {
    private Map<String, Integer> ingredients;

    public Pizza(String name) {
        super(name);
        ingredients = Loader.loadRecepie(name);
    }

    public Map<String, Integer> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Map<String, Integer> ingredients) {
        this.ingredients = ingredients;
    }

    public String toString() {
        String result = "\npizza name: " + name + "\nprice: " + cost + "\nconsist:";
        result += ingredients.entrySet().stream()
                .map(e -> "\n" + e.getKey() + " " + e.getValue() + "g")
                .collect(Collectors.joining());
        return result;
    }
}

