package com.rakovets.course.design.practice.solid.pizza.controller;

import com.rakovets.course.design.practice.solid.pizza.service.CreatePizzaService;

public class CreatePizzaControllerStarter {
    public static void main(String[] args) {
        CreatePizzaService createPizzaService = new CreatePizzaService();
        createPizzaService.start();
        createPizzaService.chooseDough();
        createPizzaService.chooseIngredients();
        createPizzaService.addIngredientsQuestion();
    }
}