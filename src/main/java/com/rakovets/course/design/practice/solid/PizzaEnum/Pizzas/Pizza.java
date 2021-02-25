package com.rakovets.course.design.practice.solid.PizzaEnum.Pizzas;

import com.rakovets.course.design.practice.solid.PizzaEnum.Ingredients.Ingredient;

import java.util.List;
import java.util.Map;

public enum Pizza {
    FOUR_CHEESE(Map.of(
            Ingredient.CHEESE, 2,
            Ingredient.MEAT, 1,
            Ingredient.TOMATOES, 1
    )),
    MARGHERITA(Map.of(
            Ingredient.CHEESE, 2,
            Ingredient.MEAT, 1,
            Ingredient.TOMATOES, 1
    )),
    MEAT_DELIGHT(Map.of(
            Ingredient.CHEESE, 2,
            Ingredient.MEAT, 1,
            Ingredient.TOMATOES, 1
    )),
    PEPPERONI(Map.of(
            Ingredient.CHEESE, 2,
            Ingredient.MEAT, 1,
            Ingredient.TOMATOES, 1
    )),
    VEGETARIAN(Map.of(
            Ingredient.CHEESE, 2,
            Ingredient.MEAT, 1,
            Ingredient.TOMATOES, 1
    ));
    private final Map<Ingredient, Integer> ingredients;

    Pizza(Map<Ingredient, Integer> ingredients) {
        this.ingredients = ingredients;
    }

    public Map<Ingredient, Integer> getIngredients() {
        return ingredients;
    }
}