package com.rakovets.course.design.practice.solid.pizza.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfitServiceTest {

    @Test
    void profitPercentage() {
        assertEquals(130, ProfitService.profitPercentage(100));
    }
}