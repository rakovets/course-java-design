package com.rakovets.course.design.practice.solid.pizza.util;

import com.rakovets.course.design.practice.solid.pizza.model.Ingredient;
import com.rakovets.course.design.practice.solid.pizza.model.Pizza;

public final class PizzaCaloriesUtil {

    private PizzaCaloriesUtil() {
    }

    public static int caloriesPizzaFourCheese() {
        return Pizza.FOUR_CHEESE.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH) *
                Ingredient.TRADITIONAL_DOUGH.getCalories() +
                Pizza.FOUR_CHEESE.getIngredientQuantity(Ingredient.SAUCE) *
                        Ingredient.SAUCE.getCalories() +
                Pizza.FOUR_CHEESE.getIngredientQuantity(Ingredient.CHEESE) *
                        Ingredient.CHEESE.getCalories() +
                Pizza.FOUR_CHEESE.getIngredientQuantity(Ingredient.OREGANO) *
                        Ingredient.OREGANO.getCalories();
    }

    public static int caloriesPizzaMargherita() {
        return Pizza.MARGHERITA.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH) *
                Ingredient.TRADITIONAL_DOUGH.getCalories() +
                Pizza.MARGHERITA.getIngredientQuantity(Ingredient.SAUCE) *
                        Ingredient.SAUCE.getCalories() +
                Pizza.MARGHERITA.getIngredientQuantity(Ingredient.CHEESE) *
                        Ingredient.CHEESE.getCalories() +
                Pizza.MARGHERITA.getIngredientQuantity(Ingredient.TOMATOES) *
                        Ingredient.TOMATOES.getCalories() *
                Pizza.MARGHERITA.getIngredientQuantity(Ingredient.OREGANO) *
                        Ingredient.OREGANO.getCalories();
    }

    public static int caloriesPizzaMeatDelight() {
        return Pizza.MEAT_DELIGHT.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH) *
                Ingredient.TRADITIONAL_DOUGH.getCalories() +
                Pizza.MEAT_DELIGHT.getIngredientQuantity(Ingredient.SAUCE) *
                        Ingredient.SAUCE.getCalories() +
                Pizza.MEAT_DELIGHT.getIngredientQuantity(Ingredient.CHEESE) *
                        Ingredient.CHEESE.getCalories() +
                Pizza.MEAT_DELIGHT.getIngredientQuantity(Ingredient.MEAT) *
                        Ingredient.MEAT.getCalories() +
                Pizza.MEAT_DELIGHT.getIngredientQuantity(Ingredient.SAUSAGES) *
                        Ingredient.SAUSAGES.getCalories();
    }

    public static int caloriesPizzaPepperoni() {
        return Pizza.PEPPERONI.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH) *
                Ingredient.TRADITIONAL_DOUGH.getCalories() +
                Pizza.PEPPERONI.getIngredientQuantity(Ingredient.SAUCE) *
                        Ingredient.SAUCE.getCalories() +
                Pizza.PEPPERONI.getIngredientQuantity(Ingredient.CHEESE) *
                        Ingredient.CHEESE.getCalories() +
                Pizza.PEPPERONI.getIngredientQuantity(Ingredient.MEAT) *
                        Ingredient.MEAT.getCalories();
    }

    public static int caloriesPizzaVegetarian() {
        return Pizza.VEGETARIAN.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH) *
                Ingredient.TRADITIONAL_DOUGH.getCalories() +
                Pizza.VEGETARIAN.getIngredientQuantity(Ingredient.SAUCE) *
                        Ingredient.SAUCE.getCalories() +
                Pizza.VEGETARIAN.getIngredientQuantity(Ingredient.CHEESE) *
                        Ingredient.CHEESE.getCalories() +
                Pizza.VEGETARIAN.getIngredientQuantity(Ingredient.TOMATOES) *
                        Ingredient.TOMATOES.getCalories() +
                Pizza.VEGETARIAN.getIngredientQuantity(Ingredient.PEPPER) *
                        Ingredient.PEPPER.getCalories() +
                Pizza.VEGETARIAN.getIngredientQuantity(Ingredient.OLIVES) *
                        Ingredient.OLIVES.getCalories();
    }
}
