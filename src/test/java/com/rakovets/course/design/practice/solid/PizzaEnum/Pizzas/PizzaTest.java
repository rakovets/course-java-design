package com.rakovets.course.design.practice.solid.PizzaEnum.Pizzas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaTest {

    @Test
    void getCost() {
        assertEquals(14.6, Pizza.FOUR_CHEESE.getIngredients());
        assertEquals(12.6, Pizza.MARGHERITA.getIngredients());
        assertEquals(28.4, Pizza.MEAT_DELIGHT.getIngredients());
        assertEquals(21.6, Pizza.PEPPERONI.getIngredients());
        assertEquals(17.6, Pizza.VEGETARIAN.getIngredients());
    }
}