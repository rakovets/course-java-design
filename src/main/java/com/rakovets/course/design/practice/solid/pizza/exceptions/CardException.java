package com.rakovets.course.design.practice.solid.pizza.exceptions;

public class CardException extends Exception {

    public String toString() {
        return "Card Number must contain only digits";
    }
}
