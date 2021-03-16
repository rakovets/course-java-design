package com.rakovets.course.design.practice.solid.pizza.exceptions;

public class UserInputException extends Exception {
    private final int number;

    public UserInputException(int number) {
        this.number = number;
    }

    public String toString() {
        return "Input " + number + " is invalid";
    }
}
