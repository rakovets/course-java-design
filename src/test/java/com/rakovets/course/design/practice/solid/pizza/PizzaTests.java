package com.rakovets.course.design.practice.solid.pizza;

import com.rakovets.course.design.practice.solid.pizza.controller.OrderStatisticsController;
import com.rakovets.course.design.practice.solid.pizza.service.*;
import com.rakovets.course.design.practice.solid.pizza.util.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaTests {
    private static final CashPaymentService CASH_PAYMENT;
    private static final OrderStatisticsService ORDER_STATISTICS;
    private static final PizzaCaloriesService PIZZA_CALORIES;

    static {
        CASH_PAYMENT = new CashPaymentService();
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
        assertEquals(90, DiscountUtil.discountForTwoItems(100));
    }

    @Test
    void discountForThreeAndMoreItems_DiscountService() {
        assertEquals(80, DiscountUtil.discountForThreeAndMoreItems(100));
    }

    @Test
    void discountForOrderOnSpecificDay_DiscountService() {
        assertEquals(85, DiscountUtil.discountForOrderOnSpecificDay(100));
    }

    @Test
    void amountToPayFor2PizzasOnSpecificDay_DiscountService() {
        assertEquals(75, DiscountUtil.amountToPayFor2PizzasOnSpecificDay(100));
    }

    @Test
    void amountToPayFor3AndMorePizzasOnSpecificDay_DiscountService() {
        assertEquals(65, DiscountUtil.amountToPayFor3AndMorePizzasOnSpecificDay(100));
    }

    @Test
    void priceThinDoughWithoutVAT_IngredientPriceService() {
        assertEquals(2.47, RoundUtil.up(IngredientPriceUtil.priceThinDoughWithoutVAT()));
    }

    @Test
    void priceThinDoughIncludingVAT_IngredientPriceService() {
        assertEquals(2.96, RoundUtil.up(IngredientPriceUtil.priceThinDoughIncludingVAT()));
    }

    @Test
    void priceTraditionalDoughWithoutVAT_IngredientPriceService() {
        assertEquals(3.25, RoundUtil.up(IngredientPriceUtil.priceTraditionalDoughWithoutVAT()));
    }

    @Test
    void priceTraditionalDoughIncludingVAT_IngredientPriceService() {
        assertEquals(3.9, RoundUtil.up(IngredientPriceUtil.priceTraditionalDoughIncludingVAT()));
    }

    @Test
    void priceCheeseWithoutVAT_IngredientPriceService() {
        assertEquals(3.25, RoundUtil.up(IngredientPriceUtil.priceCheeseWithoutVAT()));
    }

    @Test
    void priceCheeseIncludingVAT_IngredientPriceService() {
        assertEquals(3.9, RoundUtil.up(IngredientPriceUtil.priceCheeseIncludingVAT()));
    }

    @Test
    void priceMeatWithoutVAT_IngredientPriceService() {
        assertEquals(6.76, RoundUtil.up(IngredientPriceUtil.priceMeatWithoutVAT()));
    }

    @Test
    void priceMeatIncludingVAT_IngredientPriceService() {
        assertEquals(8.11, RoundUtil.up(IngredientPriceUtil.priceMeatIncludingVAT()));
    }

    @Test
    void priceSausagesWithoutVAT_IngredientPriceService() {
        assertEquals(7.8, RoundUtil.up(IngredientPriceUtil.priceSausagesWithoutVAT()));
    }

    @Test
    void priceSausagesIncludingVAT_IngredientPriceService() {
        assertEquals(9.36, RoundUtil.up(IngredientPriceUtil.priceSausagesIncludingVAT()));
    }

    @Test
    void priceOlivesWithoutVAT_IngredientPriceService() {
        assertEquals(3.25, RoundUtil.up(IngredientPriceUtil.priceOlivesWithoutVAT()));
    }

    @Test
    void priceOlivesIncludingVAT_IngredientPriceService() {
        assertEquals(3.9, RoundUtil.up(IngredientPriceUtil.priceOlivesIncludingVAT()));
    }

    @Test
    void priceTomatoesWithoutVAT_IngredientPriceService() {
        assertEquals(1.95, RoundUtil.up(IngredientPriceUtil.priceTomatoesWithoutVAT()));
    }

    @Test
    void priceTomatoesIncludingVAT_IngredientPriceService() {
        assertEquals(2.34, RoundUtil.up(IngredientPriceUtil.priceTomatoesIncludingVAT()));
    }

    @Test
    void pricePepperWithoutVAT_IngredientPriceService() {
        assertEquals(2.34, RoundUtil.up(IngredientPriceUtil.pricePepperWithoutVAT()));
    }

    @Test
    void pricePepperIncludingVAT_IngredientPriceService() {
        assertEquals(2.81, RoundUtil.up(IngredientPriceUtil.pricePepperIncludingVAT()));
    }

    @Test
    void priceOreganoWithoutVAT_IngredientPriceService() {
        assertEquals(1.43, RoundUtil.up(IngredientPriceUtil.priceOreganoWithoutVAT()));
    }

    @Test
    void priceOreganoIncludingVAT_IngredientPriceService() {
        assertEquals(1.72, RoundUtil.up(IngredientPriceUtil.priceOreganoIncludingVAT()));
    }

    @Test
    void priceSauceWithoutVAT_IngredientPriceService() {
        assertEquals(1.3, RoundUtil.up(IngredientPriceUtil.priceSauceWithoutVAT()));
    }

    @Test
    void priceSauceIncludingVAT_IngredientPriceService() {
        assertEquals(1.56, RoundUtil.up(IngredientPriceUtil.priceSauceIncludingVAT()));
    }

    @Test
    void priceCrustWithoutVAT_IngredientPriceService() {
        assertEquals(2.6, RoundUtil.up(IngredientPriceUtil.priceCrustWithoutVAT()));
    }

    @Test
    void priceCrustIncludingVAT_IngredientPriceService() {
        assertEquals(3.12, RoundUtil.up(IngredientPriceUtil.priceCrustIncludingVAT()));
    }

    public void putToMaps() {
        OrderStatisticsController.SOLD_PIZZAS.put(1, 5);
        OrderStatisticsController.SOLD_PIZZAS.put(2, 5);
        OrderStatisticsController.SOLD_PIZZAS.put(3, 11);
        OrderStatisticsController.SOLD_PIZZAS.put(4, 1);
        OrderStatisticsController.SOLD_PIZZAS.put(5, 20);
    }

    @Test
    void totalPizzasSold_OrderStatisticsService() {
        putToMaps();
        assertEquals(42, ORDER_STATISTICS.totalPizzasSold());
    }

    @Test
    void totalRevenue_OrderStatisticsService() {
        putToMaps();
        assertEquals(1282.32, ORDER_STATISTICS.totalRevenue());
    }

    @Test
    void averageCheck_OrderStatisticsService() {
        putToMaps();
        assertEquals(30.53, ORDER_STATISTICS.averageCheck());
    }

    @Test
    void totalCost_OrderStatisticsService() {
        putToMaps();
        assertEquals(822.0, ORDER_STATISTICS.totalCost());
    }

    @Test
    void totalProfit_OrderStatisticsService() {
        putToMaps();
        assertEquals(460.32, ORDER_STATISTICS.totalProfit());
    }

    @Test
    void profitMargin_OrderStatisticsService() {
        putToMaps();
        assertEquals(35.9, ORDER_STATISTICS.profitMargin());
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
        assertEquals(14.6, PizzaCostUtil.getCostFourCheese());
    }

    @Test
    void getCostMargherita_PizzaCostService() {
        assertEquals(12.6, PizzaCostUtil.getCostMargherita());
    }

    @Test
    void getCostMeatDelight_PizzaCostService() {
        assertEquals(28.4, PizzaCostUtil.getCostMeatDelight());
    }

    @Test
    void getCostPepperoni_PizzaCostService() {
        assertEquals(21.6, PizzaCostUtil.getCostPepperoni());
    }

    @Test
    void getCostVegetarian_PizzaCostService() {
        assertEquals(17.6, PizzaCostUtil.getCostVegetarian());
    }

    @Test
    void pricePizzaFourCheeseWithoutVAT_PizzaPriceService() {
        assertEquals(18.98, RoundUtil.up(PizzaPriceUtil.pricePizzaFourCheeseWithoutVAT()));
    }

    @Test
    void pricePizzaFourCheeseIncludingVAT_PizzaPriceService() {
        assertEquals(22.78, RoundUtil.up(PizzaPriceUtil.pricePizzaFourCheeseIncludingVAT()));
    }

    @Test
    void pricePizzaMargheritaWithoutVAT_PizzaPriceService() {
        assertEquals(16.38, RoundUtil.up(PizzaPriceUtil.pricePizzaMargheritaWithoutVAT()));
    }

    @Test
    void pricePizzaMargheritaIncludingVAT_PizzaPriceService() {
        assertEquals(19.66, RoundUtil.up(PizzaPriceUtil.pricePizzaMargheritaIncludingVAT()));
    }

    @Test
    void pricePizzaMeatDelightWithoutVAT_PizzaPriceService() {
        assertEquals(36.92, RoundUtil.up(PizzaPriceUtil.pricePizzaMeatDelightWithoutVAT()));
    }

    @Test
    void pricePizzaMeatDelightIncludingVAT_PizzaPriceService() {
        assertEquals(44.3, RoundUtil.up(PizzaPriceUtil.pricePizzaMeatDelightIncludingVAT()));
    }

    @Test
    void pricePizzaPepperoniWithoutVAT_PizzaPriceService() {
        assertEquals(28.08, RoundUtil.up(PizzaPriceUtil.pricePizzaPepperoniWithoutVAT()));
    }

    @Test
    void pricePizzaPepperoniIncludingVAT_PizzaPriceService() {
        assertEquals(33.7, RoundUtil.up(PizzaPriceUtil.pricePizzaPepperoniIncludingVAT()));
    }

    @Test
    void pricePizzaVegetarianWithoutVAT_PizzaPriceService() {
        assertEquals(22.88, RoundUtil.up(PizzaPriceUtil.pricePizzaVegetarianWithoutVAT()));
    }

    @Test
    void pricePizzaVegetarianIncludingVAT_PizzaPriceService() {
        assertEquals(27.46, RoundUtil.up(PizzaPriceUtil.pricePizzaVegetarianIncludingVAT()));
    }

    @Test
    void profitPercentage_ProfitService() {
        assertEquals(130, ProfitUtil.profitPercentage(100));
    }

    @Test
    void VAT_TaxService() {
        assertEquals(20, TaxUtil.VAT(100));
    }
}
