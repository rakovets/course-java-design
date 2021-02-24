package com.rakovets.course.design.practice.solid.PizzaEnum.Ingredients;

class StorageDemo {
    public static void main(String[] args) {

        Storage storage = new Storage();

        System.out.print(storage.getStorage());
        System.out.print("\nQuantity of cheese : " + storage.getIngredientQuantity(Ingredient.CHEESE));
        storage.changeIngredientQuantity(Ingredient.CHEESE, storage.getIngredientQuantity(Ingredient.CHEESE),
                storage.getIngredientQuantity(Ingredient.CHEESE) - 1);
        System.out.print("\nQuantity of cheese after changing : " + storage.getIngredientQuantity(Ingredient.CHEESE));
    }
}