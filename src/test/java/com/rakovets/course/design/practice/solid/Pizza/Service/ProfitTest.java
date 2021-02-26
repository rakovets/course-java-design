package com.rakovets.course.design.practice.solid.Pizza.Service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfitTest {

    @Test
    void profitPercentage() {
        assertEquals(130, Profit.profitPercentage(100));
    }
}