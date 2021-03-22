package com.rakovets.course.design.practice.solid.pizza.model;

public final class Customer {
    public static String firstName;
    public static String lastName;
    public static long cardNumber;

    private Customer(String firstName, String lastName, long cardNumber) {
        Customer.firstName = firstName;
        Customer.lastName = lastName;
        Customer.cardNumber = cardNumber;
    }
}
