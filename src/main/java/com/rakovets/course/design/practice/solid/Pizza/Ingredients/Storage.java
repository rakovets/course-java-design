package com.rakovets.course.design.practice.solid.Pizza.Ingredients;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private final Map<Ingredient, Integer> storage = new HashMap<>();

    public Storage() {
        Cheese cheese = new Cheese();
        Meat meat = new Meat();
        Olives olives = new Olives();
        Oregano oregano = new Oregano();
        Pepper pepper = new Pepper();
        Sauce sauce = new Sauce();
        Sausages sausages = new Sausages();
        Tomatoes tomatoes = new Tomatoes();
        ThinDough thinDough = new ThinDough();
        TraditionalDough traditionalDough = new TraditionalDough();

        storage.put(cheese, 90);
        storage.put(meat, 82);
        storage.put(olives, 5);
        storage.put(oregano, 78);
        storage.put(pepper, 53);
        storage.put(sauce, 15);
        storage.put(sausages, 8);
        storage.put(tomatoes, 54);
        storage.put(thinDough, 11);
        storage.put(traditionalDough, 15);
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

    public Iterable<? extends Map.Entry<Ingredient, Integer>> entrySet() {
        return storage.entrySet();
    }
}
