package com.rakovets.course.design.practice.solid.pizza.model;

public class Customer {
    private final String name;
    protected final int cardNumber;

    public Customer(String name, int cardNumber) {
        this.name = name;
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer " + name;
    }
}
