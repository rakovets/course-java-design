package com.rakovets.course.design.practice.solid.pizza;

import com.rakovets.course.design.practice.solid.pizza.model.Pizza;
import com.rakovets.course.design.practice.solid.pizza.service.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaTests {
    private static final CashPaymentService cashPaymentService;
    private static final IngredientPriceService ingredientPriceService;
    private static final PizzaPriceService pizzaPriceService;
    private static final OrderStatisticsService orderStatisticsService;
    private static final PizzaCaloriesService pizzaCaloriesService;

    static {
        cashPaymentService = new CashPaymentService();
        ingredientPriceService = new IngredientPriceService();
        pizzaPriceService = new PizzaPriceService();
        orderStatisticsService = new OrderStatisticsService();
        pizzaCaloriesService = new PizzaCaloriesService();
    }

    @Test
    void countChange_CashPaymentService() {
        CashPaymentService.fullAmount = 250;
        assertEquals(150, cashPaymentService.countChange(100));
    }

    @Test
    void discountForTwoItems_DiscountService() {
        assertEquals(90, DiscountService.discountForTwoItems(100));
    }

    @Test
    void discountForThreeAndMoreItems_DiscountService() {
        assertEquals(80, DiscountService.discountForThreeAndMoreItems(100));
    }

    @Test
    void discountForOrderOnSpecificDay_DiscountService() {
        assertEquals(85, DiscountService.discountForOrderOnSpecificDay(100));
    }

    @Test
    void amountToPayFor2PizzasOnSpecificDay_DiscountService() {
        assertEquals(75, DiscountService.amountToPayFor2PizzasOnSpecificDay(100));
    }

    @Test
    void amountToPayFor3AndMorePizzasOnSpecificDay_DiscountService() {
        assertEquals(65, DiscountService.amountToPayFor3AndMorePizzasOnSpecificDay(100));
    }

    @Test
    void priceThinDoughWithoutVAT_IngredientPriceService() {
        assertEquals(2.47, RoundUpService.roundUp(ingredientPriceService.priceThinDoughWithoutVAT()));
    }

    @Test
    void priceThinDoughIncludingVAT_IngredientPriceService() {
        assertEquals(2.96, RoundUpService.roundUp(ingredientPriceService.priceThinDoughIncludingVAT()));
    }

    @Test
    void priceTraditionalDoughWithoutVAT_IngredientPriceService() {
        assertEquals(3.25, RoundUpService.roundUp(ingredientPriceService.priceTraditionalDoughWithoutVAT()));
    }

    @Test
    void priceTraditionalDoughIncludingVAT_IngredientPriceService() {
        assertEquals(3.9, RoundUpService.roundUp(ingredientPriceService.priceTraditionalDoughIncludingVAT()));
    }

    @Test
    void priceCheeseWithoutVAT_IngredientPriceService() {
        assertEquals(3.25, RoundUpService.roundUp(ingredientPriceService.priceCheeseWithoutVAT()));
    }

    @Test
    void priceCheeseIncludingVAT_IngredientPriceService() {
        assertEquals(3.9, RoundUpService.roundUp(ingredientPriceService.priceCheeseIncludingVAT()));
    }

    @Test
    void priceMeatWithoutVAT_IngredientPriceService() {
        assertEquals(6.76, RoundUpService.roundUp(ingredientPriceService.priceMeatWithoutVAT()));
    }

    @Test
    void priceMeatIncludingVAT_IngredientPriceService() {
        assertEquals(8.11, RoundUpService.roundUp(ingredientPriceService.priceMeatIncludingVAT()));
    }

    @Test
    void priceSausagesWithoutVAT_IngredientPriceService() {
        assertEquals(7.8, RoundUpService.roundUp(ingredientPriceService.priceSausagesWithoutVAT()));
    }

    @Test
    void priceSausagesIncludingVAT_IngredientPriceService() {
        assertEquals(9.36, RoundUpService.roundUp(ingredientPriceService.priceSausagesIncludingVAT()));
    }

    @Test
    void priceOlivesWithoutVAT_IngredientPriceService() {
        assertEquals(3.25, RoundUpService.roundUp(ingredientPriceService.priceOlivesWithoutVAT()));
    }

    @Test
    void priceOlivesIncludingVAT_IngredientPriceService() {
        assertEquals(3.9, RoundUpService.roundUp(ingredientPriceService.priceOlivesIncludingVAT()));
    }

    @Test
    void priceTomatoesWithoutVAT_IngredientPriceService() {
        assertEquals(1.95, RoundUpService.roundUp(ingredientPriceService.priceTomatoesWithoutVAT()));
    }

    @Test
    void priceTomatoesIncludingVAT_IngredientPriceService() {
        assertEquals(2.34, RoundUpService.roundUp(ingredientPriceService.priceTomatoesIncludingVAT()));
    }

    @Test
    void pricePepperWithoutVAT_IngredientPriceService() {
        assertEquals(2.34, RoundUpService.roundUp(ingredientPriceService.pricePepperWithoutVAT()));
    }

    @Test
    void pricePepperIncludingVAT_IngredientPriceService() {
        assertEquals(2.81, RoundUpService.roundUp(ingredientPriceService.pricePepperIncludingVAT()));
    }

    @Test
    void priceOreganoWithoutVAT_IngredientPriceService() {
        assertEquals(1.43, RoundUpService.roundUp(ingredientPriceService.priceOreganoWithoutVAT()));
    }

    @Test
    void priceOreganoIncludingVAT_IngredientPriceService() {
        assertEquals(1.72, RoundUpService.roundUp(ingredientPriceService.priceOreganoIncludingVAT()));
    }

    @Test
    void priceSauceWithoutVAT_IngredientPriceService() {
        assertEquals(1.3, RoundUpService.roundUp(ingredientPriceService.priceSauceWithoutVAT()));
    }

    @Test
    void priceSauceIncludingVAT_IngredientPriceService() {
        assertEquals(1.56, RoundUpService.roundUp(ingredientPriceService.priceSauceIncludingVAT()));
    }

    @Test
    void priceCrustWithoutVAT_IngredientPriceService() {
        assertEquals(2.6, RoundUpService.roundUp(ingredientPriceService.priceCrustWithoutVAT()));
    }

    @Test
    void priceCrustIncludingVAT_IngredientPriceService() {
        assertEquals(3.12, RoundUpService.roundUp(ingredientPriceService.priceCrustIncludingVAT()));
    }

    @Test
    void getNumberOfPizzasSold_OrderStatisticsService() {
        assertEquals(100, orderStatisticsService.getNumberOfPizzasSold(
                Pizza.FOUR_CHEESE, 100));
    }

    @Test
    void getRevenue_PizzaFourCheese_OrderStatisticsService() {
        assertEquals(2277.6,
                orderStatisticsService.getRevenue(Pizza.FOUR_CHEESE, 100,
                        pizzaPriceService.pricePizzaFourCheeseIncludingVAT()));
    }

    @Test
    void getRevenue_PizzaMargherita_OrderStatisticsService() {
        assertEquals(1965.6,
                orderStatisticsService.getRevenue(Pizza.MARGHERITA, 100,
                        pizzaPriceService.pricePizzaMargheritaIncludingVAT()));
    }

    @Test
    void getRevenue_PizzaMeatDelight_OrderStatisticsService() {
        assertEquals(4430.4,
                orderStatisticsService.getRevenue(Pizza.MEAT_DELIGHT, 100,
                        pizzaPriceService.pricePizzaMeatDelightIncludingVAT()));
    }

    @Test
    void getRevenue_PizzaPepperoni_OrderStatisticsService() {
        assertEquals(3369.6,
                orderStatisticsService.getRevenue(Pizza.PEPPERONI, 100,
                        pizzaPriceService.pricePizzaPepperoniIncludingVAT()));
    }

    @Test
    void getRevenue_PizzaVegetarian_OrderStatisticsService() {
        assertEquals(2745.6,
                orderStatisticsService.getRevenue(Pizza.VEGETARIAN, 100,
                        pizzaPriceService.pricePizzaVegetarianIncludingVAT()));
    }

    @Test
    void getProfit_PizzaFourCheese_OrderStatisticsService() {
        assertEquals(817.6,
                orderStatisticsService.getProfit(Pizza.FOUR_CHEESE, 100,
                        pizzaPriceService.pricePizzaFourCheeseIncludingVAT(),
                        PizzaCostService.getCostFourCheese()));
    }

    @Test
    void getProfit_PizzaMargherita_OrderStatisticsService() {
        assertEquals(705.6,
                orderStatisticsService.getProfit(Pizza.MARGHERITA, 100,
                        pizzaPriceService.pricePizzaMargheritaIncludingVAT(),
                        PizzaCostService.getCostMargherita()));
    }

    @Test
    void getProfit_PizzaMeatDelight_OrderStatisticsService() {
        assertEquals(1590.4,
                orderStatisticsService.getProfit(Pizza.MEAT_DELIGHT, 100,
                        pizzaPriceService.pricePizzaMeatDelightIncludingVAT(),
                        PizzaCostService.getCostMeatDelight()));
    }

    @Test
    void getProfit_PizzaPepperoni_OrderStatisticsService() {
        assertEquals(1209.6,
                orderStatisticsService.getProfit(Pizza.PEPPERONI, 100,
                        pizzaPriceService.pricePizzaPepperoniIncludingVAT(),
                        PizzaCostService.getCostPepperoni()));
    }

    @Test
    void getProfit_PizzaVegetarian_OrderStatisticsService() {
        assertEquals(985.6,
                orderStatisticsService.getProfit(Pizza.VEGETARIAN, 100,
                        pizzaPriceService.pricePizzaVegetarianIncludingVAT(),
                        PizzaCostService.getCostVegetarian()));
    }

    @Test
    void caloriesPizzaFourCheese_PizzaCaloriesService() {
        assertEquals(1750, pizzaCaloriesService.caloriesPizzaFourCheese());
    }

    @Test
    void caloriesPizzaMargherita_PizzaCaloriesService() {
        assertEquals(1420, pizzaCaloriesService.caloriesPizzaMargherita());
    }

    @Test
    void caloriesPizzaMeatDelight_PizzaCaloriesService() {
        assertEquals(1740, pizzaCaloriesService.caloriesPizzaMeatDelight());
    }

    @Test
    void caloriesPizzaPepperoni_PizzaCaloriesService() {
        assertEquals(1320, pizzaCaloriesService.caloriesPizzaPepperoni());
    }

    @Test
    void caloriesPizzaVegetarian_PizzaCaloriesService() {
        assertEquals(990, pizzaCaloriesService.caloriesPizzaVegetarian());
    }

    @Test
    void getCostFourCheese_PizzaCostService() {
        assertEquals(14.6, PizzaCostService.getCostFourCheese());
    }

    @Test
    void getCostMargherita_PizzaCostService() {
        assertEquals(12.6, PizzaCostService.getCostMargherita());
    }

    @Test
    void getCostMeatDelight_PizzaCostService() {
        assertEquals(28.4, PizzaCostService.getCostMeatDelight());
    }

    @Test
    void getCostPepperoni_PizzaCostService() {
        assertEquals(21.6, PizzaCostService.getCostPepperoni());
    }

    @Test
    void getCostVegetarian_PizzaCostService() {
        assertEquals(17.6, PizzaCostService.getCostVegetarian());
    }

    @Test
    void pricePizzaFourCheeseWithoutVAT_PizzaPriceService() {
        assertEquals(18.98, RoundUpService.roundUp(pizzaPriceService.pricePizzaFourCheeseWithoutVAT()));
    }

    @Test
    void pricePizzaFourCheeseIncludingVAT_PizzaPriceService() {
        assertEquals(22.78, RoundUpService.roundUp(pizzaPriceService.pricePizzaFourCheeseIncludingVAT()));
    }

    @Test
    void pricePizzaMargheritaWithoutVAT_PizzaPriceService() {
        assertEquals(16.38, RoundUpService.roundUp(pizzaPriceService.pricePizzaMargheritaWithoutVAT()));
    }

    @Test
    void pricePizzaMargheritaIncludingVAT_PizzaPriceService() {
        assertEquals(19.66, RoundUpService.roundUp(pizzaPriceService.pricePizzaMargheritaIncludingVAT()));
    }

    @Test
    void pricePizzaMeatDelightWithoutVAT_PizzaPriceService() {
        assertEquals(36.92, RoundUpService.roundUp(pizzaPriceService.pricePizzaMeatDelightWithoutVAT()));
    }

    @Test
    void pricePizzaMeatDelightIncludingVAT_PizzaPriceService() {
        assertEquals(44.3, RoundUpService.roundUp(pizzaPriceService.pricePizzaMeatDelightIncludingVAT()));
    }

    @Test
    void pricePizzaPepperoniWithoutVAT_PizzaPriceService() {
        assertEquals(28.08, RoundUpService.roundUp(pizzaPriceService.pricePizzaPepperoniWithoutVAT()));
    }

    @Test
    void pricePizzaPepperoniIncludingVAT_PizzaPriceService() {
        assertEquals(33.7, RoundUpService.roundUp(pizzaPriceService.pricePizzaPepperoniIncludingVAT()));
    }

    @Test
    void pricePizzaVegetarianWithoutVAT_PizzaPriceService() {
        assertEquals(22.88, RoundUpService.roundUp(pizzaPriceService.pricePizzaVegetarianWithoutVAT()));
    }

    @Test
    void pricePizzaVegetarianIncludingVAT_PizzaPriceService() {
        assertEquals(27.46, RoundUpService.roundUp(pizzaPriceService.pricePizzaVegetarianIncludingVAT()));
    }

    @Test
    void profitPercentage_ProfitService() {
        assertEquals(130, ProfitService.profitPercentage(100));
    }

    @Test
    void VAT_TaxService() {
        assertEquals(20, TaxService.VAT(100));
    }
}
