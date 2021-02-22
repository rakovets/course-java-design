package com.rakovets.course.design.practice.solid.Pizza.Pizzas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MeatDelightTest {

    MeatDelight meatDelight = new MeatDelight();

    @Test
    void getExpenses() {
        assertEquals(28.4, meatDelight.getExpenses());
    }

    @Test
    void getPrice() {
        assertEquals(36.92, meatDelight.getPrice());
    }
}