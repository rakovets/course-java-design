package com.rakovets.course.design.practice.solid.pizza.repository;

import com.rakovets.course.design.practice.solid.pizza.model.Ingredient;
import com.rakovets.course.design.practice.solid.pizza.model.Pizza;

class StorageDemo {
    public static void main(String[] args) {

        StorageRepository storage = new StorageRepository();

        System.out.println(storage.getStorage());
        System.out.println("Quantity of cheese : " + storage.getIngredientQuantity(Ingredient.CHEESE));
        storage.changeIngredientQuantity(Pizza.FOUR_CHEESE);
        System.out.println("Quantity of ingredients after ordering pizza:");
        System.out.println(storage.getStorage());
        storage.changeIngredientQuantity(Ingredient.CHEESE,
                storage.getIngredientQuantity(Ingredient.CHEESE) - 1);
        System.out.println("Quantity of cheese after changing : " + storage.getIngredientQuantity(Ingredient.CHEESE));
    }
}
