package com.rakovets.course.design.practice.solid.pizza.exceptions;

public class PaymentChoiceException extends Exception {

    public String toString() {
        return "To choose a payment method you need to enter a number from 1 to 3";
    }
}
