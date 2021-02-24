package com.rakovets.course.design.practice.solid.PizzaEnum.Finance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProfitTest {

    Profit profit = new Profit();

    @Test
    void profitPercentage() {
        assertEquals(130, profit.profitPercentage(100));
    }
}