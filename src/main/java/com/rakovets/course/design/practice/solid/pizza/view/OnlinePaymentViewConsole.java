package com.rakovets.course.design.practice.solid.pizza.view;

import com.rakovets.course.design.practice.solid.pizza.service.OnlinePaymentService;

public class OnlinePaymentViewConsole implements OnlinePaymentView {
    OnlinePaymentService onlinePaymentService = new OnlinePaymentService();

    public void addCustomerView() {
        System.out.println("Enter your name and card number:");
    }

    public void displayPayment() {
        System.out.println(onlinePaymentService.toString() + " paid total amount");
    }
}
