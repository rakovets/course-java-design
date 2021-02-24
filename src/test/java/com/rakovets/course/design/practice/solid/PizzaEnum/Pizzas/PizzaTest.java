package com.rakovets.course.design.practice.solid.PizzaEnum.Pizzas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaTest {

    @Test
    void getCost() {
        assertEquals(14.6, Pizza.FOUR_CHEESE.getCost());
        assertEquals(12.6, Pizza.MARGHERITA.getCost());
        assertEquals(28.4, Pizza.MEAT_DELIGHT.getCost());
        assertEquals(21.6, Pizza.PEPPERONI.getCost());
        assertEquals(17.6, Pizza.VEGETARIAN.getCost());
    }
}