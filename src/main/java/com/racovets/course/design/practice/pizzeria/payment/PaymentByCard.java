package com.racovets.course.design.practice.pizzeria.payment;

import com.racovets.course.design.practice.pizzeria.OrderPizza;

public class PaymentByCard implements PaymentMethod {
    OrderPizza orderPizza;

    @Override
    public void payOrder() {
        System.out.println("Turn on terminal.");
        System.out.println("Approved.");
    }
}
