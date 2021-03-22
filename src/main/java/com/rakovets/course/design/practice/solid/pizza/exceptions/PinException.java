package com.rakovets.course.design.practice.solid.pizza.exceptions;

public class PinException extends Exception {

    public String toString() {
        return "PIN must contain only digits";
    }
}
