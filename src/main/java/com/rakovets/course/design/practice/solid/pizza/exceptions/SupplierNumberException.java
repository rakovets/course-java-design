package com.rakovets.course.design.practice.solid.pizza.exceptions;

public class SupplierNumberException extends Exception {

    public String toString() {
        return "There is no supplier under entered number";
    }
}
