package com.rakovets.course.design.practice.solid.pizza.controller;

import java.io.IOException;

public class PizzaOrderControllerStarter {
    public static void main(String[] args) throws IOException {
        PizzaOrderController pizzaOrderController = new PizzaOrderController();
        pizzaOrderController.start();
        pizzaOrderController.choosePizza();
        pizzaOrderController.addPizzaQuestion();
    }
}