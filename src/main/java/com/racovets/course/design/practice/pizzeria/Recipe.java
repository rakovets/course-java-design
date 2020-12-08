package com.racovets.course.design.practice.pizzeria;

import java.util.HashMap;
import java.util.Map;

public class Recipe {
    private Map<? extends Ingredients, Integer> recipe;
    public Recipe (Map<? extends Ingredients, Integer> recipe) {
        this.recipe = new HashMap<>();
    }
    public void createNewRecipe() {


    }
}
