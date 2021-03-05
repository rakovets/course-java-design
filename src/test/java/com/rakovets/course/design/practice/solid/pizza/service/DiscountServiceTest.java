package com.rakovets.course.design.practice.solid.pizza.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountServiceTest {

    @Test
    void discountForTwoItems() {
        assertEquals(90, DiscountService.discountForTwoItems(100));
    }

    @Test
    void discountForThreeAndMoreItems() {
        assertEquals(80, DiscountService.discountForThreeAndMoreItems(100));
    }

    @Test
    void discountForOrderOnSpecificDay() {
        assertEquals(85, DiscountService.discountForOrderOnSpecificDay(100));
    }

    @Test
    void amountToPayFor2PizzasOnSpecificDay() {
        assertEquals(75, DiscountService.amountToPayFor2PizzasOnSpecificDay(100));
    }

    @Test
    void amountToPayFor3AndMorePizzasOnSpecificDay() {
        assertEquals(65, DiscountService.amountToPayFor3AndMorePizzasOnSpecificDay(100));
    }
}