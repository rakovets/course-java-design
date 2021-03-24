package com.rakovets.course.design.practice.solid.pizza.view;

import com.rakovets.course.design.practice.solid.pizza.exceptions.CardException;
import com.rakovets.course.design.practice.solid.pizza.model.Customer;

public class OnlinePaymentViewConsole implements OnlinePaymentView {
    private static final CardException cardException;

    static {
        cardException = new CardException();
    }

    public void firstName() {
        System.out.println("Enter your First Name:");
    }

    public void lastName() {
        System.out.println("Enter your Last Name:");
    }

    public void cardNumber() {
        System.out.println("Enter your Card Number:");
    }

    public void invalidInput() {
        System.out.println("Card Number must contain 16 digits");
    }

    public void displayPayment() {
        System.out.println(Customer.firstName + " " + Customer.lastName + " paid total amount");
    }

    public void cardException() {
        System.out.println(cardException.toString());
    }
}
