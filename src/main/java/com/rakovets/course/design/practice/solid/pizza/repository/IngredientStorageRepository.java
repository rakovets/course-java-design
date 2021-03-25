package com.rakovets.course.design.practice.solid.pizza.repository;

import com.rakovets.course.design.practice.solid.pizza.model.Ingredient;
import com.rakovets.course.design.practice.solid.pizza.model.Pizza;

import java.util.Map;

public interface IngredientStorageRepository {

    Map<Ingredient, Integer> getStorage();

    int getIngredientQuantity(Ingredient ingredient);

    void changeIngredientQuantity(Pizza pizza);

    void changeIngredientQuantity(Ingredient ingredient, int newQuantity);

    void removeOneIngredient(Ingredient ingredient);

    Iterable<Map.Entry<Ingredient, Integer>> entrySet();

}