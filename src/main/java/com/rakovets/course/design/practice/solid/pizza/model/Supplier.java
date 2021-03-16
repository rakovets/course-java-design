package com.rakovets.course.design.practice.solid.pizza.model;

import java.util.Map;

public enum Supplier {
    SUPPLIER_1(Map.of(
            Ingredient.SAUCE, 50
    )),
    SUPPLIER_2(Map.of(
            Ingredient.CHEESE, 15
    )),
    SUPPLIER_3(Map.of(
            Ingredient.MEAT, 15,
            Ingredient.SAUSAGES, 50
    )),
    SUPPLIER_4(Map.of(
            Ingredient.OLIVES, 25,
            Ingredient.PEPPER, 60
    )),
    SUPPLIER_5(Map.of(
            Ingredient.OREGANO, 10,
            Ingredient.TOMATOES, 20
    ));
    private final Map<Ingredient, Integer> ingredients;

    Supplier(Map<Ingredient, Integer> ingredients) {
        this.ingredients = ingredients;
    }

    public Map<Ingredient, Integer> getIngredients() {
        return ingredients;
    }
}
