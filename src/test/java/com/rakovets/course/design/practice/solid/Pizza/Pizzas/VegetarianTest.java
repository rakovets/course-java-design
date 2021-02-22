package com.rakovets.course.design.practice.solid.Pizza.Pizzas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VegetarianTest {

    Vegetarian vegetarian = new Vegetarian();

    @Test
    void getExpenses() {
        assertEquals(18.6, vegetarian.getExpenses());
    }

    @Test
    void getPrice() {
        assertEquals(24.18, vegetarian.getPrice());
    }
}