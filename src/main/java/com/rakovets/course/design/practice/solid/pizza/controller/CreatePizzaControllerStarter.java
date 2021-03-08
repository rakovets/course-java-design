package com.rakovets.course.design.practice.solid.pizza.controller;

public class CreatePizzaControllerStarter {
    public static void main(String[] args) {
        CreatePizzaController createPizzaController = new CreatePizzaController();
        createPizzaController.start();
        createPizzaController.chooseDough();
        createPizzaController.chooseIngredients();
        createPizzaController.addIngredientsQuestion();
    }
}