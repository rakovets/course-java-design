package com.rakovets.course.design.practice.solid.pizza.model;

public class Customer {
    private final String name;
    private final int cardNumber;

    public Customer(String name, int cardNumber) {
        this.name = name;
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", cardNumber=" + cardNumber +
                '}';
    }
}
