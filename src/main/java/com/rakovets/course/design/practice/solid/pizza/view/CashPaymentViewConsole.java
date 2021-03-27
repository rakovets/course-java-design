package com.rakovets.course.design.practice.solid.pizza.view;

import com.rakovets.course.design.practice.solid.pizza.exceptions.CashAmountException;
import com.rakovets.course.design.practice.solid.pizza.service.CashPaymentService;
import com.rakovets.course.design.practice.solid.pizza.service.CreatePizzaService;
import com.rakovets.course.design.practice.solid.pizza.service.PizzaOrderService;

public class CashPaymentViewConsole implements CashPaymentView {
    private static final PizzaOrderService PIZZA_ORDER;
    private static final CreatePizzaService CREATE_PIZZA;
    private static final CashAmountException CASH_AMOUNT_EXCEPTION;

    static {
        PIZZA_ORDER = new PizzaOrderService();
        CREATE_PIZZA = new CreatePizzaService();
        CASH_AMOUNT_EXCEPTION = new CashAmountException();
    }

    public void fullAmountView() {
        System.out.println("Enter amount of money you want to get the change from:");
    }

    public void getChangePizzaOrder() {
        if (PIZZA_ORDER.getChange() >= 0)
            System.out.println("Your change from " + CashPaymentService.fullAmount + "$ is "
                    + PIZZA_ORDER.getChange() + "$");
    }

    public void getChangeCreatePizza() {
        if (CREATE_PIZZA.getChange() >= 0)
            System.out.println("Your change from " + CashPaymentService.fullAmount + "$ is "
                    + CREATE_PIZZA.getChange() + "$");
    }

    public void notEnoughMoney() {
        System.out.println("The amount is not enough to pay");
    }

    public void cashAmountException() {
        System.out.println(CASH_AMOUNT_EXCEPTION.toString());
    }
}
