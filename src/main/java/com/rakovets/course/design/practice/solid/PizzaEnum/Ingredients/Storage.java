package com.rakovets.course.design.practice.solid.PizzaEnum.Ingredients;

import com.rakovets.course.design.practice.solid.PizzaEnum.Pizzas.Pizza;

import java.util.HashMap;
import java.util.Map;

public class Storage implements IngridientStorage {
    private final Map<Ingredient, Integer> storage = new HashMap<>();

    public Storage() {
        storage.put(Ingredient.CHEESE, 90);
        storage.put(Ingredient.MEAT, 82);
        storage.put(Ingredient.OLIVES, 5);
        storage.put(Ingredient.OREGANO, 78);
        storage.put(Ingredient.PEPPER, 53);
        storage.put(Ingredient.SAUCE, 15);
        storage.put(Ingredient.SAUSAGES, 8);
        storage.put(Ingredient.TOMATOES, 54);
        storage.put(Ingredient.THIN_DOUGH, 11);
        storage.put(Ingredient.TRADITIONAL_DOUGH, 15);
    }

    public Map<Ingredient, Integer> getStorage() {
        return storage;
    }

    public int getIngredientQuantity(Ingredient ingredient) {
        return storage.get(ingredient);
    }

    public void changeIngredientQuantity(Ingredient ingredient, int oldQuantity, int newQuantity) {
        storage.replace(ingredient, oldQuantity, newQuantity);
    }

    public void changeIngredientQuantity(Pizza pizza) {
        pizza.getIngredients().forEach((name, value) -> {
            Integer count = storage.get(name);
            int changedCountIngredientForPizza = count - value;
            storage.put(name, changedCountIngredientForPizza);
        });
    }

    public Iterable<Map.Entry<Ingredient, Integer>> entrySet() {
        return storage.entrySet();
    }
}
