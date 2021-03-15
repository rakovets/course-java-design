package com.rakovets.course.design.practice.solid.pizza.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaPriceServiceTest {
    PizzaPriceService pizzaPriceService = new PizzaPriceService();

    @Test
    void pricePizzaFourCheeseWithoutVAT() {
        assertEquals(18.98, RoundUpService.roundUp(pizzaPriceService.pricePizzaFourCheeseWithoutVAT()));
    }

    @Test
    void pricePizzaFourCheeseIncludingVAT() {
        assertEquals(22.78, RoundUpService.roundUp(pizzaPriceService.pricePizzaFourCheeseIncludingVAT()));
    }

    @Test
    void pricePizzaMargheritaWithoutVAT() {
        assertEquals(16.38, RoundUpService.roundUp(pizzaPriceService.pricePizzaMargheritaWithoutVAT()));
    }

    @Test
    void pricePizzaMargheritaIncludingVAT() {
        assertEquals(19.66, RoundUpService.roundUp(pizzaPriceService.pricePizzaMargheritaIncludingVAT()));
    }

    @Test
    void pricePizzaMeatDelightWithoutVAT() {
        assertEquals(36.92, RoundUpService.roundUp(pizzaPriceService.pricePizzaMeatDelightWithoutVAT()));
    }

    @Test
    void pricePizzaMeatDelightIncludingVAT() {
        assertEquals(44.3, RoundUpService.roundUp(pizzaPriceService.pricePizzaMeatDelightIncludingVAT()));
    }

    @Test
    void pricePizzaPepperoniWithoutVAT() {
        assertEquals(28.08, RoundUpService.roundUp(pizzaPriceService.pricePizzaPepperoniWithoutVAT()));
    }

    @Test
    void pricePizzaPepperoniIncludingVAT() {
        assertEquals(33.7, RoundUpService.roundUp(pizzaPriceService.pricePizzaPepperoniIncludingVAT()));
    }

    @Test
    void pricePizzaVegetarianWithoutVAT() {
        assertEquals(22.88, RoundUpService.roundUp(pizzaPriceService.pricePizzaVegetarianWithoutVAT()));
    }

    @Test
    void pricePizzaVegetarianIncludingVAT() {
        assertEquals(27.46, RoundUpService.roundUp(pizzaPriceService.pricePizzaVegetarianIncludingVAT()));
    }
}