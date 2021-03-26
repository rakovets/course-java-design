package com.rakovets.course.design.practice.solid.pizza.view;

import com.rakovets.course.design.practice.solid.pizza.service.CreatePizzaService;
import com.rakovets.course.design.practice.solid.pizza.service.PizzaOrderService;

public class CheckViewConsole implements CheckView {

    public void displayCheckPizzaOrder() {
        PizzaOrderService.CHECK.getItemsInCheck().forEach(System.out::println);
    }

    public void displayCheckCreatePizza() {
        CreatePizzaService.CHECK.getItemsInCheck().forEach(System.out::println);
    }
}
