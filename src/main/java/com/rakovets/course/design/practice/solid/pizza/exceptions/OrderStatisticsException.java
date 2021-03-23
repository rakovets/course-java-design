package com.rakovets.course.design.practice.solid.pizza.exceptions;

public class OrderStatisticsException extends Exception {

    public String toString() {
        return "Number of sold pizzas must to be an integer";
    }
}
