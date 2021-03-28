package com.rakovets.course.design.practice.solid.pizza.util;

import com.rakovets.course.design.practice.solid.pizza.model.Ingredient;
import com.rakovets.course.design.practice.solid.pizza.model.Pizza;

public final class PizzaCostUtil {

    private PizzaCostUtil() {
    }

    public static double getCostFourCheese() {
        return Ingredient.TRADITIONAL_DOUGH.getCostPerUnit() *
                Pizza.FOUR_CHEESE.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH) +
                Ingredient.SAUCE.getCostPerUnit() * Pizza.FOUR_CHEESE.getIngredientQuantity(Ingredient.SAUCE) +
                Ingredient.CHEESE.getCostPerUnit() * Pizza.FOUR_CHEESE.getIngredientQuantity(Ingredient.CHEESE) +
                Ingredient.OREGANO.getCostPerUnit() * Pizza.FOUR_CHEESE.getIngredientQuantity(Ingredient.OREGANO);
    }

    public static double getCostMargherita() {
        return Ingredient.TRADITIONAL_DOUGH.getCostPerUnit() *
                Pizza.MARGHERITA.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH) +
                Ingredient.SAUCE.getCostPerUnit() * Pizza.MARGHERITA.getIngredientQuantity(Ingredient.SAUCE) +
                Ingredient.CHEESE.getCostPerUnit() * Pizza.MARGHERITA.getIngredientQuantity(Ingredient.CHEESE) +
                Ingredient.TOMATOES.getCostPerUnit() * Pizza.MARGHERITA.getIngredientQuantity(Ingredient.TOMATOES) +
                Ingredient.OREGANO.getCostPerUnit() * Pizza.MARGHERITA.getIngredientQuantity(Ingredient.OREGANO);
    }

    public static double getCostMeatDelight() {
        return Ingredient.TRADITIONAL_DOUGH.getCostPerUnit() *
                Pizza.MEAT_DELIGHT.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH) +
                Ingredient.SAUCE.getCostPerUnit() * Pizza.MEAT_DELIGHT.getIngredientQuantity(Ingredient.SAUCE) +
                Ingredient.CHEESE.getCostPerUnit() * Pizza.MEAT_DELIGHT.getIngredientQuantity(Ingredient.CHEESE) +
                Ingredient.MEAT.getCostPerUnit() * Pizza.MEAT_DELIGHT.getIngredientQuantity(Ingredient.MEAT) +
                Ingredient.SAUSAGES.getCostPerUnit() * Pizza.MEAT_DELIGHT.getIngredientQuantity(Ingredient.SAUSAGES);
    }

    public static double getCostPepperoni() {
        return Ingredient.TRADITIONAL_DOUGH.getCostPerUnit() *
                Pizza.PEPPERONI.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH) +
                Ingredient.SAUCE.getCostPerUnit() * Pizza.PEPPERONI.getIngredientQuantity(Ingredient.SAUCE) +
                Ingredient.CHEESE.getCostPerUnit() * Pizza.PEPPERONI.getIngredientQuantity(Ingredient.CHEESE) +
                Ingredient.MEAT.getCostPerUnit() * Pizza.PEPPERONI.getIngredientQuantity(Ingredient.MEAT);
    }

    public static double getCostVegetarian() {
        return Ingredient.TRADITIONAL_DOUGH.getCostPerUnit() *
               Pizza.VEGETARIAN.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH) +
               Ingredient.SAUCE.getCostPerUnit() * Pizza.VEGETARIAN.getIngredientQuantity(Ingredient.SAUCE) +
               Ingredient.CHEESE.getCostPerUnit() * Pizza.VEGETARIAN.getIngredientQuantity(Ingredient.CHEESE) +
               Ingredient.TOMATOES.getCostPerUnit() * Pizza.VEGETARIAN.getIngredientQuantity(Ingredient.TOMATOES) +
               Ingredient.PEPPER.getCostPerUnit() * Pizza.VEGETARIAN.getIngredientQuantity(Ingredient.PEPPER) +
               Ingredient.OLIVES.getCostPerUnit() * Pizza.VEGETARIAN.getIngredientQuantity(Ingredient.OLIVES);
    }
}
