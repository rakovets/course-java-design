package com.rakovets.course.design.practice.solid.pizza.repository;

import com.rakovets.course.design.practice.solid.pizza.model.Ingredient;
import com.rakovets.course.design.practice.solid.pizza.model.Pizza;

import java.util.HashMap;
import java.util.Map;

public class StorageRepository implements IngredientStorageRepository {
    private final Map<Ingredient, Integer> storage = new HashMap<>();

    public StorageRepository() {
        storage.put(Ingredient.CHEESE, 90);
        storage.put(Ingredient.MEAT, 82);
        storage.put(Ingredient.OLIVES, 5);
        storage.put(Ingredient.OREGANO, 78);
        storage.put(Ingredient.PEPPER, 53);
        storage.put(Ingredient.SAUCE, 15);
        storage.put(Ingredient.SAUSAGES, 8);
        storage.put(Ingredient.TOMATOES, 60);
        storage.put(Ingredient.THIN_DOUGH, 11);
        storage.put(Ingredient.TRADITIONAL_DOUGH, 15);
    }

    public Map<Ingredient, Integer> getStorage() {
        return storage;
    }

    public int getIngredientQuantity(Ingredient ingredient) {
        return storage.get(ingredient);
    }

    @NotNullPizza
    public void changeIngredientQuantity(Pizza pizza) {
        pizza.getIngredients().forEach((ingredient, ingredientsForPizza) -> {
            Integer oldQuantity = storage.get(ingredient);
            int newQuantity = oldQuantity - ingredientsForPizza;
            storage.put(ingredient, newQuantity);
        });
    }

    public void changeIngredientQuantity(Ingredient ingredient, int newQuantity) {
        storage.replace(ingredient, newQuantity);
    }

    public Iterable<Map.Entry<Ingredient, Integer>> entrySet() {
        return storage.entrySet();
    }
}
