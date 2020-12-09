package com.racovets.course.design.practice.pizzeria;

import com.racovets.course.design.practice.pizzeria.model.Ingredients;

import java.util.HashMap;
import java.util.Map;

public class IngredientsRepository {
    Map<Ingredients, Integer> ingredients = new HashMap<>();

    public IngredientsRepository (Map<Ingredients, Integer> ingredients) {
        this.ingredients = ingredients;
    }
    public void infoAboutLackingIngredients() {
        for (Map.Entry<Ingredients, Integer> item : ingredients.entrySet()) {
            if (item.getValue() <= 10) {
                System.out.println(item.getKey().getName() + " quantity: " + item.getValue() + " it should be restocked");
            }
        }
    }
    public void viewIngredients() {
        System.out.println("Available ingredients: ");
        for (Map.Entry<Ingredients, Integer> item : ingredients.entrySet()) {
            System.out.println(item.getKey() + " quantity: " + item.getValue());
        }
    }
    public void consumeIngredients(Pizza pizza, int count) {
        for (Map.Entry<Ingredients, Integer> item : ingredients.entrySet()) {
            for (Map.Entry<Ingredients, Integer> element : pizza.recipe.getRecipeMap().entrySet()) {
                if (item.getKey().equals(element.getKey())) {
                    ingredients.put(item.getKey(), item.getValue() - (element.getValue() * count));
                }
            }
        }
    }

    public Map<Ingredients, Integer> getIngredients() {
        return ingredients;
    }
}
