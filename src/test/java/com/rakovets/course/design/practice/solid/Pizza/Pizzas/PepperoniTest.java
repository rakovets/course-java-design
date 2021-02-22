package com.rakovets.course.design.practice.solid.Pizza.Pizzas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PepperoniTest {

    Pepperoni pepperoni = new Pepperoni();

    @Test
    void getExpenses() {
        assertEquals(21.6, pepperoni.getExpenses());
    }

    @Test
    void getPrice() {
        assertEquals(28.08, pepperoni.getPrice());
    }
}