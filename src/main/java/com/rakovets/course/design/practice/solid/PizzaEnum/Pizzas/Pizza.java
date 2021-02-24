package com.rakovets.course.design.practice.solid.PizzaEnum.Pizzas;

import com.rakovets.course.design.practice.solid.PizzaEnum.Ingredients.Ingredient;

public enum Pizza {
    FOUR_CHEESE(Ingredient.TRADITIONAL_DOUGH.getCostPerUnit() +
            Ingredient.SAUCE.getCostPerUnit() +
            Ingredient.CHEESE.getCostPerUnit() * 4 +
            Ingredient.OREGANO.getCostPerUnit()),
    MARGHERITA(Ingredient.TRADITIONAL_DOUGH.getCostPerUnit() +
            Ingredient.SAUCE.getCostPerUnit() +
            Ingredient.CHEESE.getCostPerUnit() * 2 +
            Ingredient.TOMATOES.getCostPerUnit() * 2 +
            Ingredient.OREGANO.getCostPerUnit()),
    MEAT_DELIGHT(Ingredient.TRADITIONAL_DOUGH.getCostPerUnit() +
            Ingredient.SAUCE.getCostPerUnit() +
            Ingredient.CHEESE.getCostPerUnit() +
            Ingredient.MEAT.getCostPerUnit() * 2 +
            Ingredient.SAUSAGES.getCostPerUnit() * 2),
    PEPPERONI(Ingredient.TRADITIONAL_DOUGH.getCostPerUnit() +
            Ingredient.SAUCE.getCostPerUnit() +
            Ingredient.CHEESE.getCostPerUnit() +
            Ingredient.MEAT.getCostPerUnit() * 3),
    VEGETARIAN(Ingredient.TRADITIONAL_DOUGH.getCostPerUnit() +
            Ingredient.SAUCE.getCostPerUnit() +
            Ingredient.CHEESE.getCostPerUnit() +
            Ingredient.TOMATOES.getCostPerUnit() * 2 +
            Ingredient.PEPPER.getCostPerUnit() * 2 +
            Ingredient.OLIVES.getCostPerUnit() * 2);
    private final double cost;

    Pizza(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }
}