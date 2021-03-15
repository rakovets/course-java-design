package com.rakovets.course.design.practice.solid.pizza.service;

import com.rakovets.course.design.practice.solid.pizza.model.Ingredient;
import com.rakovets.course.design.practice.solid.pizza.model.Pizza;
import com.rakovets.course.design.practice.solid.pizza.repository.StorageRepository;

public class CookService {
    private static final StorageRepository storage;

    static {
        storage = new StorageRepository();
    }

    public void pizzaFourCheese() {
        storage.changeIngredientQuantity(Pizza.FOUR_CHEESE);
    }

    public void pizzaMargherita() {
        storage.changeIngredientQuantity(Pizza.MARGHERITA);
    }

    public void pizzaMeatDelight() {
        storage.changeIngredientQuantity(Pizza.MEAT_DELIGHT);
    }

    public void pizzaPepperoni() {
        storage.changeIngredientQuantity(Pizza.PEPPERONI);
    }

    public void pizzaVegetarian() {
        storage.changeIngredientQuantity(Pizza.VEGETARIAN);
    }

    public void thinDough() {
        storage.changeIngredientQuantity(Ingredient.THIN_DOUGH,
                storage.getIngredientQuantity(Ingredient.THIN_DOUGH) - 1);
    }

    public void traditionalDough() {
        storage.changeIngredientQuantity(Ingredient.TRADITIONAL_DOUGH,
                storage.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH) - 1);
    }

    public void cheese() {
        storage.changeIngredientQuantity(Ingredient.CHEESE,
                storage.getIngredientQuantity(Ingredient.CHEESE) - 1);
    }

    public void meat() {
        storage.changeIngredientQuantity(Ingredient.MEAT,
                storage.getIngredientQuantity(Ingredient.MEAT) - 1);
    }

    public void sausages() {
        storage.changeIngredientQuantity(Ingredient.SAUSAGES,
                storage.getIngredientQuantity(Ingredient.SAUSAGES) - 1);
    }

    public void olives() {
        storage.changeIngredientQuantity(Ingredient.OLIVES,
                storage.getIngredientQuantity(Ingredient.OLIVES) - 1);
    }

    public void tomatoes() {
        storage.changeIngredientQuantity(Ingredient.TOMATOES,
                storage.getIngredientQuantity(Ingredient.TOMATOES) - 1);
    }

    public void pepper() {
        storage.changeIngredientQuantity(Ingredient.PEPPER,
                storage.getIngredientQuantity(Ingredient.PEPPER) - 1);
    }

    public void oregano() {
        storage.changeIngredientQuantity(Ingredient.OREGANO,
                storage.getIngredientQuantity(Ingredient.OREGANO) - 1);
    }

    public void sauce() {
        storage.changeIngredientQuantity(Ingredient.SAUCE,
                storage.getIngredientQuantity(Ingredient.SAUCE) - 1);
    }
}
