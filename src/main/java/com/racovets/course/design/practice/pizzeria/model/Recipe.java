package com.racovets.course.design.practice.pizzeria.model;

import com.racovets.course.design.practice.pizzeria.model.Ingredients;

import java.util.HashMap;
import java.util.Map;

public class Recipe {
    private Map<Ingredients, Integer> recipeMap = new HashMap<>();
    public Recipe (Map<Ingredients, Integer> recipeMap) {
        this.recipeMap = recipeMap;
    }

    public Map<Ingredients, Integer> getRecipeMap() {
        return recipeMap;
    }

    public void setRecipeMap(Map<Ingredients, Integer> recipeMap) {
        this.recipeMap = recipeMap;
    }
}
