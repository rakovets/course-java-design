package com.rakovets.course.design.practice.solid.pizza.controller;

import com.rakovets.course.design.practice.solid.pizza.view.StorageUtilityViewConsole;

public class StorageUtilityController {
    public static void main(String[] args) {
        StorageUtilityViewConsole storageUtilityViewConsole = new StorageUtilityViewConsole();
        storageUtilityViewConsole.displayStorage();
        storageUtilityViewConsole.showLackOfIngredients();
    }
}