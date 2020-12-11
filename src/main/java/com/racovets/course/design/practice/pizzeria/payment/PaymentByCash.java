package com.racovets.course.design.practice.pizzeria.payment;

import com.racovets.course.design.practice.pizzeria.OrderPizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PaymentByCash implements PaymentMethod {
    OrderPizza orderPizza;
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public PaymentByCash (OrderPizza orderPizza){
        this.orderPizza = orderPizza;
    }

    @Override
    public void payOrder() {
        try {
            System.out.print("Total cost of order is " + orderPizza.getTotalCostWithDiscount() + "\n" +
                    "Enter the sum of cash.\n");
            int cashSum = Integer.parseInt(bufferedReader.readLine());
            int change = cashSum - orderPizza.getTotalCostWithDiscount();
            System.out.println("Change: " + change);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
