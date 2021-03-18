package com.rakovets.course.design.practice.solid.pizza.view;

import com.rakovets.course.design.practice.solid.pizza.service.CreatePizzaService;
import com.rakovets.course.design.practice.solid.pizza.service.PizzaOrderService;

public class CheckViewConsole implements CheckView {

    public void displayCheckPizzaOrder() {
        PizzaOrderService.check.getItemsInCheck().forEach(System.out::println);
    }

    public void displayCheckCreatePizza() {
        CreatePizzaService.check.getItemsInCheck().forEach(System.out::println);
    }
}
