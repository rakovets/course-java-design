package com.rakovets.course.design.practice.solid.Pizza.Repository;

class StorageDemo {
    public static void main(String[] args) {

        Storage storage = new Storage();

        System.out.println(storage.getStorage());
        System.out.println("Quantity of cheese : " + storage.getIngredientQuantity(Ingredient.CHEESE));
        storage.changeIngredientQuantity(Pizza.FOUR_CHEESE);
        System.out.println("Quantity of ingredients after ordering pizza:");
        System.out.println(storage.getStorage());
        storage.changeIngredientQuantity(Ingredient.CHEESE, storage.getIngredientQuantity(Ingredient.CHEESE),
                storage.getIngredientQuantity(Ingredient.CHEESE) - 1);
        System.out.println("Quantity of cheese after changing : " + storage.getIngredientQuantity(Ingredient.CHEESE));
    }
}