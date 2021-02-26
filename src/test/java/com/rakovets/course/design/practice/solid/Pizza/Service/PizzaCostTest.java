package com.rakovets.course.design.practice.solid.Pizza.Service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaCostTest {

    @Test
    void getCostFourCheese() {
        assertEquals(14.6, PizzaCost.getCostFourCheese());
    }

    @Test
    void getCostMargherita() {
        assertEquals(12.6, PizzaCost.getCostMargherita());
    }

    @Test
    void getCostMeatDelight() {
        assertEquals(28.4, PizzaCost.getCostMeatDelight());
    }

    @Test
    void getCostPepperoni() {
        assertEquals(21.6, PizzaCost.getCostPepperoni());
    }

    @Test
    void getCostVegetarian() {
        assertEquals(17.6, PizzaCost.getCostVegetarian());
    }
}