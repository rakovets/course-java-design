package com.rakovets.course.design.practice.solid.pizza.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientPriceServiceTest {
    IngredientPriceService ingredientPriceService = new IngredientPriceService();

    @Test
    void priceThinDoughWithoutVAT() {
        assertEquals(2.47, RoundUpService.roundUp(ingredientPriceService.priceThinDoughWithoutVAT()));
    }

    @Test
    void priceThinDoughIncludingVAT() {
        assertEquals(2.96, RoundUpService.roundUp(ingredientPriceService.priceThinDoughIncludingVAT()));
    }

    @Test
    void priceTraditionalDoughWithoutVAT() {
        assertEquals(3.25, RoundUpService.roundUp(ingredientPriceService.priceTraditionalDoughWithoutVAT()));
    }

    @Test
    void priceTraditionalDoughIncludingVAT() {
        assertEquals(3.9, RoundUpService.roundUp(ingredientPriceService.priceTraditionalDoughIncludingVAT()));
    }

    @Test
    void priceCheeseWithoutVAT() {
        assertEquals(3.25, RoundUpService.roundUp(ingredientPriceService.priceCheeseWithoutVAT()));
    }

    @Test
    void priceCheeseIncludingVAT() {
        assertEquals(3.9, RoundUpService.roundUp(ingredientPriceService.priceCheeseIncludingVAT()));
    }

    @Test
    void priceMeatWithoutVAT() {
        assertEquals(6.76, RoundUpService.roundUp(ingredientPriceService.priceMeatWithoutVAT()));
    }

    @Test
    void priceMeatIncludingVAT() {
        assertEquals(8.11, RoundUpService.roundUp(ingredientPriceService.priceMeatIncludingVAT()));
    }

    @Test
    void priceSausagesWithoutVAT() {
        assertEquals(7.8, RoundUpService.roundUp(ingredientPriceService.priceSausagesWithoutVAT()));
    }

    @Test
    void priceSausagesIncludingVAT() {
        assertEquals(9.36, RoundUpService.roundUp(ingredientPriceService.priceSausagesIncludingVAT()));
    }

    @Test
    void priceOlivesWithoutVAT() {
        assertEquals(3.25, RoundUpService.roundUp(ingredientPriceService.priceOlivesWithoutVAT()));
    }

    @Test
    void priceOlivesIncludingVAT() {
        assertEquals(3.9, RoundUpService.roundUp(ingredientPriceService.priceOlivesIncludingVAT()));
    }

    @Test
    void priceTomatoesWithoutVAT() {
        assertEquals(1.95, RoundUpService.roundUp(ingredientPriceService.priceTomatoesWithoutVAT()));
    }

    @Test
    void priceTomatoesIncludingVAT() {
        assertEquals(2.34, RoundUpService.roundUp(ingredientPriceService.priceTomatoesIncludingVAT()));
    }

    @Test
    void pricePepperWithoutVAT() {
        assertEquals(2.34, RoundUpService.roundUp(ingredientPriceService.pricePepperWithoutVAT()));
    }

    @Test
    void pricePepperIncludingVAT() {
        assertEquals(2.81, RoundUpService.roundUp(ingredientPriceService.pricePepperIncludingVAT()));
    }

    @Test
    void priceOreganoWithoutVAT() {
        assertEquals(1.43, RoundUpService.roundUp(ingredientPriceService.priceOreganoWithoutVAT()));
    }

    @Test
    void priceOreganoIncludingVAT() {
        assertEquals(1.72, RoundUpService.roundUp(ingredientPriceService.priceOreganoIncludingVAT()));
    }

    @Test
    void priceSauceWithoutVAT() {
        assertEquals(1.3, RoundUpService.roundUp(ingredientPriceService.priceSauceWithoutVAT()));
    }

    @Test
    void priceSauceIncludingVAT() {
        assertEquals(1.56, RoundUpService.roundUp(ingredientPriceService.priceSauceIncludingVAT()));
    }

    @Test
    void priceCrustWithoutVAT() {
        assertEquals(2.6, RoundUpService.roundUp(ingredientPriceService.priceCrustWithoutVAT()));
    }

    @Test
    void priceCrustIncludingVAT() {
        assertEquals(3.12, RoundUpService.roundUp(ingredientPriceService.priceCrustIncludingVAT()));
    }
}