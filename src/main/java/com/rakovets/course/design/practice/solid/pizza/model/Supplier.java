package com.rakovets.course.design.practice.solid.pizza.model;

public enum Supplier {
    SUPPLIER_1(Ingredient.CHEESE),
    SUPPLIER_2(Ingredient.MEAT),
    SUPPLIER_3(Ingredient.OLIVES),
    SUPPLIER_4(Ingredient.OREGANO),
    SUPPLIER_5(Ingredient.PEPPER),
    SUPPLIER_6(Ingredient.SAUCE),
    SUPPLIER_7(Ingredient.SAUSAGES),
    SUPPLIER_8(Ingredient.TOMATOES);
    private final Ingredient ingredient;

    Supplier(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }
}
