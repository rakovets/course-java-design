package com.rakovets.course.design.practice.solid.Pizza.Ingredients;

class StorageDemo {
    public static void main(String[] args) {

        Storage storage = new Storage();
        Cheese cheese = new Cheese();

        System.out.print(storage.getStorage());
        System.out.print("\nQuantity of cheese : " + storage.getIngredientQuantity(cheese));
        storage.changeIngredientQuantity(cheese, storage.getIngredientQuantity(cheese),
                storage.getIngredientQuantity(cheese) - 1);
        System.out.print("\nQuantity of cheese after changing : " + storage.getIngredientQuantity(cheese));
    }
}