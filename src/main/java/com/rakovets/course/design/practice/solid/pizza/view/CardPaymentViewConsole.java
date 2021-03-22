package com.rakovets.course.design.practice.solid.pizza.view;

public class CardPaymentViewConsole implements CardPaymentView {

    public void enterPIN() {
        System.out.println("Enter PIN:");
    }

    public void invalidInput() {
        System.out.println("PIN must contain 4 digits");
    }

    public void approvePayment() {
        System.out.println("Payment approved");
    }
}
