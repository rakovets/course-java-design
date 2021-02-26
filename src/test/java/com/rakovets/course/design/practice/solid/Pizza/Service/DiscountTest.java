package com.rakovets.course.design.practice.solid.Pizza.Service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountTest {

    @Test
    void discountForTwoItems() {
        assertEquals(90, Discount.discountForTwoItems(100));
    }

    @Test
    void discountForThreeAndMoreItems() {
        assertEquals(80, Discount.discountForThreeAndMoreItems(100));
    }

    @Test
    void discountForOrderOnSpecificDay() {
        assertEquals(85, Discount.discountForOrderOnSpecificDay(100));
    }
}