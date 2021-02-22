package com.rakovets.course.design.practice.solid.Pizza.Pizzas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FourCheeseTest {

    FourCheese fourCheese = new FourCheese();

    @Test
    void getExpenses() {
        assertEquals(14.6, fourCheese.getExpenses());
    }

    @Test
    void getPrice() {
        assertEquals(18.98, fourCheese.getPrice());
    }
}