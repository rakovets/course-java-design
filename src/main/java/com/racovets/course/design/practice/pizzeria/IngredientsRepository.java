package com.racovets.course.design.practice.pizzeria;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IngredientsRepository {
    Map<String, Integer> ingredients = new HashMap<>();

    public Map<String, Integer> getIngredients() {
        return ingredients;
    }
}
