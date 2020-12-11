package com.racovets.course.design.practice.pizzeria.payment;

import com.racovets.course.design.practice.pizzeria.Accounting;
import com.racovets.course.design.practice.pizzeria.OrderPizza;

public class PaymentOnline implements PaymentMethod {
    OrderPizza orderPizza;
    public PaymentOnline (OrderPizza orderPizza) {
        this.orderPizza = orderPizza;
    }

    @Override
    public void payOrder() {
        System.out.println("Enter the number of client's check.");
        System.out.println("Approved.");
    }
}
