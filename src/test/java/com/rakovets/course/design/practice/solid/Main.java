package com.rakovets.course.design.practice.solid;

import com.rakovets.course.design.practice.solid.controller.impl.MakePizzaVegetarian;
import com.rakovets.course.design.practice.solid.model.Pizza;
import com.rakovets.course.design.practice.solid.model.ingredient.Ingredient;

import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        MakePizzaVegetarian makePizzaFromTheChef = new MakePizzaVegetarian();
        Collection<Ingredient> ingredients = makePizzaFromTheChef.selectionsIngredients();
        Pizza pizza = new Pizza("From the chef", ingredients);
        Collection<Ingredient> pizzaIngredients = pizza.getIngredients();
        for (Ingredient pizzaIngredient : pizzaIngredients) {
            System.out.println(pizzaIngredient);
        }
        System.out.printf("%.2f$%n", pizza.calculatePrice());
        System.out.printf("%.2f", pizza.calculateWeight());
    }
}
