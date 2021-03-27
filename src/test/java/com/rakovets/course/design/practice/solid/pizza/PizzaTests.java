package com.rakovets.course.design.practice.solid.pizza;

import com.rakovets.course.design.practice.solid.pizza.controller.OrderStatisticsController;
import com.rakovets.course.design.practice.solid.pizza.model.Pizza;
import com.rakovets.course.design.practice.solid.pizza.service.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaTests {
    private static final CashPaymentService CASH_PAYMENT;
    private static final IngredientPriceService INGREDIENT_PRICE;
    private static final PizzaPriceService PIZZA_PRICE;
    private static final OrderStatisticsService ORDER_STATISTICS;
    private static final PizzaCaloriesService PIZZA_CALORIES;

    static {
        CASH_PAYMENT = new CashPaymentService();
        INGREDIENT_PRICE = new IngredientPriceService();
        PIZZA_PRICE = new PizzaPriceService();
        ORDER_STATISTICS = new OrderStatisticsService();
        PIZZA_CALORIES = new PizzaCaloriesService();
    }

    @Test
    void countChange_CashPaymentService() {
        CashPaymentService.fullAmount = 250;
        assertEquals(150, CASH_PAYMENT.countChange(100));
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
        assertEquals(2.47, RoundUpService.roundUp(INGREDIENT_PRICE.priceThinDoughWithoutVAT()));
    }

    @Test
    void priceThinDoughIncludingVAT_IngredientPriceService() {
        assertEquals(2.96, RoundUpService.roundUp(INGREDIENT_PRICE.priceThinDoughIncludingVAT()));
    }

    @Test
    void priceTraditionalDoughWithoutVAT_IngredientPriceService() {
        assertEquals(3.25, RoundUpService.roundUp(INGREDIENT_PRICE.priceTraditionalDoughWithoutVAT()));
    }

    @Test
    void priceTraditionalDoughIncludingVAT_IngredientPriceService() {
        assertEquals(3.9, RoundUpService.roundUp(INGREDIENT_PRICE.priceTraditionalDoughIncludingVAT()));
    }

    @Test
    void priceCheeseWithoutVAT_IngredientPriceService() {
        assertEquals(3.25, RoundUpService.roundUp(INGREDIENT_PRICE.priceCheeseWithoutVAT()));
    }

    @Test
    void priceCheeseIncludingVAT_IngredientPriceService() {
        assertEquals(3.9, RoundUpService.roundUp(INGREDIENT_PRICE.priceCheeseIncludingVAT()));
    }

    @Test
    void priceMeatWithoutVAT_IngredientPriceService() {
        assertEquals(6.76, RoundUpService.roundUp(INGREDIENT_PRICE.priceMeatWithoutVAT()));
    }

    @Test
    void priceMeatIncludingVAT_IngredientPriceService() {
        assertEquals(8.11, RoundUpService.roundUp(INGREDIENT_PRICE.priceMeatIncludingVAT()));
    }

    @Test
    void priceSausagesWithoutVAT_IngredientPriceService() {
        assertEquals(7.8, RoundUpService.roundUp(INGREDIENT_PRICE.priceSausagesWithoutVAT()));
    }

    @Test
    void priceSausagesIncludingVAT_IngredientPriceService() {
        assertEquals(9.36, RoundUpService.roundUp(INGREDIENT_PRICE.priceSausagesIncludingVAT()));
    }

    @Test
    void priceOlivesWithoutVAT_IngredientPriceService() {
        assertEquals(3.25, RoundUpService.roundUp(INGREDIENT_PRICE.priceOlivesWithoutVAT()));
    }

    @Test
    void priceOlivesIncludingVAT_IngredientPriceService() {
        assertEquals(3.9, RoundUpService.roundUp(INGREDIENT_PRICE.priceOlivesIncludingVAT()));
    }

    @Test
    void priceTomatoesWithoutVAT_IngredientPriceService() {
        assertEquals(1.95, RoundUpService.roundUp(INGREDIENT_PRICE.priceTomatoesWithoutVAT()));
    }

    @Test
    void priceTomatoesIncludingVAT_IngredientPriceService() {
        assertEquals(2.34, RoundUpService.roundUp(INGREDIENT_PRICE.priceTomatoesIncludingVAT()));
    }

    @Test
    void pricePepperWithoutVAT_IngredientPriceService() {
        assertEquals(2.34, RoundUpService.roundUp(INGREDIENT_PRICE.pricePepperWithoutVAT()));
    }

    @Test
    void pricePepperIncludingVAT_IngredientPriceService() {
        assertEquals(2.81, RoundUpService.roundUp(INGREDIENT_PRICE.pricePepperIncludingVAT()));
    }

    @Test
    void priceOreganoWithoutVAT_IngredientPriceService() {
        assertEquals(1.43, RoundUpService.roundUp(INGREDIENT_PRICE.priceOreganoWithoutVAT()));
    }

    @Test
    void priceOreganoIncludingVAT_IngredientPriceService() {
        assertEquals(1.72, RoundUpService.roundUp(INGREDIENT_PRICE.priceOreganoIncludingVAT()));
    }

    @Test
    void priceSauceWithoutVAT_IngredientPriceService() {
        assertEquals(1.3, RoundUpService.roundUp(INGREDIENT_PRICE.priceSauceWithoutVAT()));
    }

    @Test
    void priceSauceIncludingVAT_IngredientPriceService() {
        assertEquals(1.56, RoundUpService.roundUp(INGREDIENT_PRICE.priceSauceIncludingVAT()));
    }

    @Test
    void priceCrustWithoutVAT_IngredientPriceService() {
        assertEquals(2.6, RoundUpService.roundUp(INGREDIENT_PRICE.priceCrustWithoutVAT()));
    }

    @Test
    void priceCrustIncludingVAT_IngredientPriceService() {
        assertEquals(3.12, RoundUpService.roundUp(INGREDIENT_PRICE.priceCrustIncludingVAT()));
    }

    @Test
    void getNumberOfPizzasSold_OrderStatisticsService() {
        assertEquals(100, ORDER_STATISTICS.getNumberOfPizzasSold(
                Pizza.FOUR_CHEESE, 100));
    }

    @Test
    void getRevenue_PizzaFourCheese_OrderStatisticsService() {
        assertEquals(2277.6,
                ORDER_STATISTICS.getRevenue(Pizza.FOUR_CHEESE, 100,
                        PIZZA_PRICE.pricePizzaFourCheeseIncludingVAT()));
    }

    @Test
    void getRevenue_PizzaMargherita_OrderStatisticsService() {
        assertEquals(1965.6,
                ORDER_STATISTICS.getRevenue(Pizza.MARGHERITA, 100,
                        PIZZA_PRICE.pricePizzaMargheritaIncludingVAT()));
    }

    @Test
    void getRevenue_PizzaMeatDelight_OrderStatisticsService() {
        assertEquals(4430.4,
                ORDER_STATISTICS.getRevenue(Pizza.MEAT_DELIGHT, 100,
                        PIZZA_PRICE.pricePizzaMeatDelightIncludingVAT()));
    }

    @Test
    void getRevenue_PizzaPepperoni_OrderStatisticsService() {
        assertEquals(3369.6,
                ORDER_STATISTICS.getRevenue(Pizza.PEPPERONI, 100,
                        PIZZA_PRICE.pricePizzaPepperoniIncludingVAT()));
    }

    @Test
    void getRevenue_PizzaVegetarian_OrderStatisticsService() {
        assertEquals(2745.6,
                ORDER_STATISTICS.getRevenue(Pizza.VEGETARIAN, 100,
                        PIZZA_PRICE.pricePizzaVegetarianIncludingVAT()));
    }

    @Test
    void getProfit_PizzaFourCheese_OrderStatisticsService() {
        assertEquals(817.6,
                ORDER_STATISTICS.getProfit(Pizza.FOUR_CHEESE, 100,
                        PIZZA_PRICE.pricePizzaFourCheeseIncludingVAT(),
                        PizzaCostService.getCostFourCheese()));
    }

    @Test
    void getProfit_PizzaMargherita_OrderStatisticsService() {
        assertEquals(705.6,
                ORDER_STATISTICS.getProfit(Pizza.MARGHERITA, 100,
                        PIZZA_PRICE.pricePizzaMargheritaIncludingVAT(),
                        PizzaCostService.getCostMargherita()));
    }

    @Test
    void getProfit_PizzaMeatDelight_OrderStatisticsService() {
        assertEquals(1590.4,
                ORDER_STATISTICS.getProfit(Pizza.MEAT_DELIGHT, 100,
                        PIZZA_PRICE.pricePizzaMeatDelightIncludingVAT(),
                        PizzaCostService.getCostMeatDelight()));
    }

    @Test
    void getProfit_PizzaPepperoni_OrderStatisticsService() {
        assertEquals(1209.6,
                ORDER_STATISTICS.getProfit(Pizza.PEPPERONI, 100,
                        PIZZA_PRICE.pricePizzaPepperoniIncludingVAT(),
                        PizzaCostService.getCostPepperoni()));
    }

    @Test
    void getProfit_PizzaVegetarian_OrderStatisticsService() {
        assertEquals(985.6,
                ORDER_STATISTICS.getProfit(Pizza.VEGETARIAN, 100,
                        PIZZA_PRICE.pricePizzaVegetarianIncludingVAT(),
                        PizzaCostService.getCostVegetarian()));
    }

    @Test
    void totalPizzasSold_OrderStatisticsService() {
        OrderStatisticsController.numberOfFourCheeseSold = 100;
        OrderStatisticsController.numberOfMargheritaSold = 100;
        OrderStatisticsController.numberOfMeatDelightSold = 100;
        OrderStatisticsController.numberOfPepperoniSold = 100;
        OrderStatisticsController.numberOfVegetarianSold = 100;
        assertEquals(500, ORDER_STATISTICS.totalPizzasSold());
    }

    @Test
    void totalRevenue_OrderStatisticsService() {
        OrderStatisticsController.numberOfFourCheeseSold = 100;
        OrderStatisticsController.numberOfMargheritaSold = 100;
        OrderStatisticsController.numberOfMeatDelightSold = 100;
        OrderStatisticsController.numberOfPepperoniSold = 100;
        OrderStatisticsController.numberOfVegetarianSold = 100;
        assertEquals(14788.8, ORDER_STATISTICS.totalRevenue());
    }

    @Test
    void averageCheck_OrderStatisticsService() {
        OrderStatisticsController.numberOfFourCheeseSold = 100;
        OrderStatisticsController.numberOfMargheritaSold = 100;
        OrderStatisticsController.numberOfMeatDelightSold = 100;
        OrderStatisticsController.numberOfPepperoniSold = 100;
        OrderStatisticsController.numberOfVegetarianSold = 100;
        assertEquals(29.58, ORDER_STATISTICS.averageCheck());
    }

    @Test
    void caloriesPizzaFourCheese_PizzaCaloriesService() {
        assertEquals(1750, PIZZA_CALORIES.caloriesPizzaFourCheese());
    }

    @Test
    void caloriesPizzaMargherita_PizzaCaloriesService() {
        assertEquals(1420, PIZZA_CALORIES.caloriesPizzaMargherita());
    }

    @Test
    void caloriesPizzaMeatDelight_PizzaCaloriesService() {
        assertEquals(1740, PIZZA_CALORIES.caloriesPizzaMeatDelight());
    }

    @Test
    void caloriesPizzaPepperoni_PizzaCaloriesService() {
        assertEquals(1320, PIZZA_CALORIES.caloriesPizzaPepperoni());
    }

    @Test
    void caloriesPizzaVegetarian_PizzaCaloriesService() {
        assertEquals(990, PIZZA_CALORIES.caloriesPizzaVegetarian());
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
        assertEquals(18.98, RoundUpService.roundUp(PIZZA_PRICE.pricePizzaFourCheeseWithoutVAT()));
    }

    @Test
    void pricePizzaFourCheeseIncludingVAT_PizzaPriceService() {
        assertEquals(22.78, RoundUpService.roundUp(PIZZA_PRICE.pricePizzaFourCheeseIncludingVAT()));
    }

    @Test
    void pricePizzaMargheritaWithoutVAT_PizzaPriceService() {
        assertEquals(16.38, RoundUpService.roundUp(PIZZA_PRICE.pricePizzaMargheritaWithoutVAT()));
    }

    @Test
    void pricePizzaMargheritaIncludingVAT_PizzaPriceService() {
        assertEquals(19.66, RoundUpService.roundUp(PIZZA_PRICE.pricePizzaMargheritaIncludingVAT()));
    }

    @Test
    void pricePizzaMeatDelightWithoutVAT_PizzaPriceService() {
        assertEquals(36.92, RoundUpService.roundUp(PIZZA_PRICE.pricePizzaMeatDelightWithoutVAT()));
    }

    @Test
    void pricePizzaMeatDelightIncludingVAT_PizzaPriceService() {
        assertEquals(44.3, RoundUpService.roundUp(PIZZA_PRICE.pricePizzaMeatDelightIncludingVAT()));
    }

    @Test
    void pricePizzaPepperoniWithoutVAT_PizzaPriceService() {
        assertEquals(28.08, RoundUpService.roundUp(PIZZA_PRICE.pricePizzaPepperoniWithoutVAT()));
    }

    @Test
    void pricePizzaPepperoniIncludingVAT_PizzaPriceService() {
        assertEquals(33.7, RoundUpService.roundUp(PIZZA_PRICE.pricePizzaPepperoniIncludingVAT()));
    }

    @Test
    void pricePizzaVegetarianWithoutVAT_PizzaPriceService() {
        assertEquals(22.88, RoundUpService.roundUp(PIZZA_PRICE.pricePizzaVegetarianWithoutVAT()));
    }

    @Test
    void pricePizzaVegetarianIncludingVAT_PizzaPriceService() {
        assertEquals(27.46, RoundUpService.roundUp(PIZZA_PRICE.pricePizzaVegetarianIncludingVAT()));
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
