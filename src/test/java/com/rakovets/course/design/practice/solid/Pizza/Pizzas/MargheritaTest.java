package com.rakovets.course.design.practice.solid.Pizza.Pizzas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MargheritaTest {

    Margherita margherita = new Margherita();

    @Test
    void getExpenses() {
        assertEquals(12.6, margherita.getExpenses());
    }

    @Test
    void getPrice() {
        assertEquals(16.38, margherita.getPrice());
    }
}