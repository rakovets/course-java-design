package com.rakovets.course.design.practice.solid.Pizza.Finance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiscountTest {

    Discount discount = new Discount();

    @Test
    void discountForTwoItems() {
        assertEquals(90, discount.discountForTwoItems(100));
    }

    @Test
    void discountForThreeAndMoreItems() {
        assertEquals(80, discount.discountForThreeAndMoreItems(100));
    }

    @Test
    void discountForOrderOnMonday() {
        assertEquals(85, discount.discountForOrderOnMonday(100));
    }
}