package com.rakovets.course.design.practice.solid.pizza.repository;

import com.rakovets.course.design.practice.solid.pizza.model.Ingredient;
import com.rakovets.course.design.practice.solid.pizza.model.Pizza;
import com.rakovets.course.design.practice.solid.pizza.model.Supplier;

import java.util.Map;

public interface IngredientStorageRepository {

    Map<Ingredient, Integer> getStorage();

    int getIngredientQuantity(Ingredient ingredient);

    void changeIngredientQuantity(Supplier supplier);

    void changeIngredientQuantity(Pizza pizza);

    void changeIngredientQuantity(Ingredient ingredient, int newQuantity);

    Iterable<Map.Entry<Ingredient, Integer>> entrySet();

}