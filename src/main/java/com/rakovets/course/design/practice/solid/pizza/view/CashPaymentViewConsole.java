package com.rakovets.course.design.practice.solid.pizza.view;

import com.rakovets.course.design.practice.solid.pizza.exceptions.CashAmountException;
import com.rakovets.course.design.practice.solid.pizza.service.CashPaymentService;
import com.rakovets.course.design.practice.solid.pizza.service.CreatePizzaService;
import com.rakovets.course.design.practice.solid.pizza.service.PizzaOrderService;

public class CashPaymentViewConsole implements CashPaymentView {
    private static final PizzaOrderService pizzaOrderService;
    private static final CreatePizzaService createPizzaService;
    private static final CashAmountException cashAmountException;

    static {
        pizzaOrderService = new PizzaOrderService();
        createPizzaService = new CreatePizzaService();
        cashAmountException = new CashAmountException();
    }

    public void fullAmountView() {
        System.out.println("Enter amount of money you want to get the change from:");
    }

    public void getChangePizzaOrder() {
        if (pizzaOrderService.getChange() >= 0)
            System.out.println("Your change from " + CashPaymentService.fullAmount + "$ is "
                    + pizzaOrderService.getChange() + "$");
    }

    public void getChangeCreatePizza() {
        if (createPizzaService.getChange() >= 0)
            System.out.println("Your change from " + CashPaymentService.fullAmount + "$ is "
                    + createPizzaService.getChange() + "$");
    }

    public void notEnoughMoney() {
        System.out.println("The amount is not enough to pay");
    }

    public void cashAmountException() {
        System.out.println(cashAmountException.toString());
    }
}
