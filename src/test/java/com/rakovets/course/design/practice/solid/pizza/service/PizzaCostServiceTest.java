package com.rakovets.course.design.practice.solid.pizza.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaCostServiceTest {

    @Test
    void getCostFourCheese() {
        assertEquals(14.6, PizzaCostService.getCostFourCheese());
    }

    @Test
    void getCostMargherita() {
        assertEquals(12.6, PizzaCostService.getCostMargherita());
    }

    @Test
    void getCostMeatDelight() {
        assertEquals(28.4, PizzaCostService.getCostMeatDelight());
    }

    @Test
    void getCostPepperoni() {
        assertEquals(21.6, PizzaCostService.getCostPepperoni());
    }

    @Test
    void getCostVegetarian() {
        assertEquals(17.6, PizzaCostService.getCostVegetarian());
    }
}