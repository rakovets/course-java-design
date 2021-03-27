package com.rakovets.course.design.practice.solid.pizza.repository;

import com.rakovets.course.design.practice.solid.pizza.model.Ingredient;
import com.rakovets.course.design.practice.solid.pizza.model.Pizza;
import com.rakovets.course.design.practice.solid.pizza.model.Supplier;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StorageRepository implements IngredientStorageRepository {
    private static final Map<Ingredient, Integer> STORAGE;
    private static final Scanner SCANNER;

    static {
        STORAGE = new HashMap<>();
        SCANNER = new Scanner(System.in);
    }

    public StorageRepository() {
        STORAGE.put(Ingredient.CHEESE, 90);
        STORAGE.put(Ingredient.MEAT, 82);
        STORAGE.put(Ingredient.OLIVES, 5);
        STORAGE.put(Ingredient.OREGANO, 78);
        STORAGE.put(Ingredient.PEPPER, 53);
        STORAGE.put(Ingredient.SAUCE, 15);
        STORAGE.put(Ingredient.SAUSAGES, 8);
        STORAGE.put(Ingredient.TOMATOES, 60);
        STORAGE.put(Ingredient.THIN_DOUGH, 11);
        STORAGE.put(Ingredient.TRADITIONAL_DOUGH, 15);
    }

    public Map<Ingredient, Integer> getStorage() {
        return STORAGE;
    }

    public int getIngredientQuantity(Ingredient ingredient) {
        return STORAGE.get(ingredient);
    }

    public void changeIngredientQuantity(Pizza pizza) {
        pizza.getIngredients().forEach((ingredient, ingredientsForPizza) -> {
            Integer oldQuantity = STORAGE.get(ingredient);
            int newQuantity = oldQuantity - ingredientsForPizza;
            STORAGE.put(ingredient, newQuantity);
        });
    }

    public void changeIngredientQuantity(Ingredient ingredient, int newQuantity) {
        STORAGE.replace(ingredient, newQuantity);
    }

    public void removeOneIngredient(Ingredient ingredient) {
        changeIngredientQuantity(ingredient, getIngredientQuantity(ingredient) - 1);
    }

    public void changeDeliveredIngredient(Supplier supplier) {
        changeIngredientQuantity(supplier.getIngredient(), getIngredientQuantity(supplier.getIngredient())
                        + SCANNER.nextInt());
    }

    public Iterable<Map.Entry<Ingredient, Integer>> entrySet() {
        return STORAGE.entrySet();
    }
}
