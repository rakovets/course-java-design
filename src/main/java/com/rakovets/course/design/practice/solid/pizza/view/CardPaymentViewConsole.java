package com.rakovets.course.design.practice.solid.pizza.view;

import com.rakovets.course.design.practice.solid.pizza.exceptions.PinException;

public class CardPaymentViewConsole implements CardPaymentView {
    private static final PinException pinException;

    static {
        pinException = new PinException();
    }

    public void enterPIN() {
        System.out.println("Enter PIN:");
    }

    public void invalidInput() {
        System.out.println("PIN must contain 4 digits");
    }

    public void approvePayment() {
        System.out.println("Payment approved");
    }

    public void pinException() {
        System.out.println(pinException.toString());
    }
}
