package com.rakovets.course.design.practice.solid.pizza.view;

import com.rakovets.course.design.practice.solid.pizza.service.PizzaOrderService;

public class CheckViewConsole implements CheckView {

    public void displayCheck() {
        PizzaOrderService.check.getItemsInCheck().forEach(System.out::println);
    }
}
