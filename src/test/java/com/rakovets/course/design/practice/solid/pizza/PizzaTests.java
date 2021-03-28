package com.rakovets.course.design.practice.solid.pizza;

import com.rakovets.course.design.practice.solid.pizza.controller.OrderStatisticsController;
import com.rakovets.course.design.practice.solid.pizza.service.*;
import com.rakovets.course.design.practice.solid.pizza.util.RoundUtil;
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
        assertEquals(2.47, RoundUtil.up(INGREDIENT_PRICE.priceThinDoughWithoutVAT()));
    }

    @Test
    void priceThinDoughIncludingVAT_IngredientPriceService() {
        assertEquals(2.96, RoundUtil.up(INGREDIENT_PRICE.priceThinDoughIncludingVAT()));
    }

    @Test
    void priceTraditionalDoughWithoutVAT_IngredientPriceService() {
        assertEquals(3.25, RoundUtil.up(INGREDIENT_PRICE.priceTraditionalDoughWithoutVAT()));
    }

    @Test
    void priceTraditionalDoughIncludingVAT_IngredientPriceService() {
        assertEquals(3.9, RoundUtil.up(INGREDIENT_PRICE.priceTraditionalDoughIncludingVAT()));
    }

    @Test
    void priceCheeseWithoutVAT_IngredientPriceService() {
        assertEquals(3.25, RoundUtil.up(INGREDIENT_PRICE.priceCheeseWithoutVAT()));
    }

    @Test
    void priceCheeseIncludingVAT_IngredientPriceService() {
        assertEquals(3.9, RoundUtil.up(INGREDIENT_PRICE.priceCheeseIncludingVAT()));
    }

    @Test
    void priceMeatWithoutVAT_IngredientPriceService() {
        assertEquals(6.76, RoundUtil.up(INGREDIENT_PRICE.priceMeatWithoutVAT()));
    }

    @Test
    void priceMeatIncludingVAT_IngredientPriceService() {
        assertEquals(8.11, RoundUtil.up(INGREDIENT_PRICE.priceMeatIncludingVAT()));
    }

    @Test
    void priceSausagesWithoutVAT_IngredientPriceService() {
        assertEquals(7.8, RoundUtil.up(INGREDIENT_PRICE.priceSausagesWithoutVAT()));
    }

    @Test
    void priceSausagesIncludingVAT_IngredientPriceService() {
        assertEquals(9.36, RoundUtil.up(INGREDIENT_PRICE.priceSausagesIncludingVAT()));
    }

    @Test
    void priceOlivesWithoutVAT_IngredientPriceService() {
        assertEquals(3.25, RoundUtil.up(INGREDIENT_PRICE.priceOlivesWithoutVAT()));
    }

    @Test
    void priceOlivesIncludingVAT_IngredientPriceService() {
        assertEquals(3.9, RoundUtil.up(INGREDIENT_PRICE.priceOlivesIncludingVAT()));
    }

    @Test
    void priceTomatoesWithoutVAT_IngredientPriceService() {
        assertEquals(1.95, RoundUtil.up(INGREDIENT_PRICE.priceTomatoesWithoutVAT()));
    }

    @Test
    void priceTomatoesIncludingVAT_IngredientPriceService() {
        assertEquals(2.34, RoundUtil.up(INGREDIENT_PRICE.priceTomatoesIncludingVAT()));
    }

    @Test
    void pricePepperWithoutVAT_IngredientPriceService() {
        assertEquals(2.34, RoundUtil.up(INGREDIENT_PRICE.pricePepperWithoutVAT()));
    }

    @Test
    void pricePepperIncludingVAT_IngredientPriceService() {
        assertEquals(2.81, RoundUtil.up(INGREDIENT_PRICE.pricePepperIncludingVAT()));
    }

    @Test
    void priceOreganoWithoutVAT_IngredientPriceService() {
        assertEquals(1.43, RoundUtil.up(INGREDIENT_PRICE.priceOreganoWithoutVAT()));
    }

    @Test
    void priceOreganoIncludingVAT_IngredientPriceService() {
        assertEquals(1.72, RoundUtil.up(INGREDIENT_PRICE.priceOreganoIncludingVAT()));
    }

    @Test
    void priceSauceWithoutVAT_IngredientPriceService() {
        assertEquals(1.3, RoundUtil.up(INGREDIENT_PRICE.priceSauceWithoutVAT()));
    }

    @Test
    void priceSauceIncludingVAT_IngredientPriceService() {
        assertEquals(1.56, RoundUtil.up(INGREDIENT_PRICE.priceSauceIncludingVAT()));
    }

    @Test
    void priceCrustWithoutVAT_IngredientPriceService() {
        assertEquals(2.6, RoundUtil.up(INGREDIENT_PRICE.priceCrustWithoutVAT()));
    }

    @Test
    void priceCrustIncludingVAT_IngredientPriceService() {
        assertEquals(3.12, RoundUtil.up(INGREDIENT_PRICE.priceCrustIncludingVAT()));
    }

    public void putToMaps() {
        OrderStatisticsController.SOLD_PIZZAS_REVENUE.put(1, PIZZA_PRICE.pricePizzaFourCheeseIncludingVAT());
        OrderStatisticsController.SOLD_PIZZAS_REVENUE.put(2, PIZZA_PRICE.pricePizzaMargheritaIncludingVAT());
        OrderStatisticsController.SOLD_PIZZAS_REVENUE.put(3, PIZZA_PRICE.pricePizzaMeatDelightIncludingVAT());
        OrderStatisticsController.SOLD_PIZZAS_REVENUE.put(4, PIZZA_PRICE.pricePizzaPepperoniIncludingVAT());
        OrderStatisticsController.SOLD_PIZZAS_REVENUE.put(5, PIZZA_PRICE.pricePizzaVegetarianIncludingVAT());
        OrderStatisticsController.SOLD_PIZZAS_COST.put(1, PizzaCostService.getCostFourCheese());
        OrderStatisticsController.SOLD_PIZZAS_COST.put(2, PizzaCostService.getCostMargherita());
        OrderStatisticsController.SOLD_PIZZAS_COST.put(3, PizzaCostService.getCostMeatDelight());
        OrderStatisticsController.SOLD_PIZZAS_COST.put(4, PizzaCostService.getCostPepperoni());
        OrderStatisticsController.SOLD_PIZZAS_COST.put(5, PizzaCostService.getCostVegetarian());
    }

    @Test
    void totalPizzasSold_OrderStatisticsService() {
        putToMaps();
        assertEquals(15, RoundUtil.up(ORDER_STATISTICS.totalPizzasSold()));
    }

    @Test
    void totalRevenue_OrderStatisticsService() {
        putToMaps();
        assertEquals(467.06, ORDER_STATISTICS.totalRevenue());
    }

    @Test
    void averageCheck_OrderStatisticsService() {
        putToMaps();
        assertEquals(31.14, ORDER_STATISTICS.averageCheck());
    }

    @Test
    void totalCost_OrderStatisticsService() {
        putToMaps();
        assertEquals(299.4, ORDER_STATISTICS.totalCost());
    }

    @Test
    void totalProfit_OrderStatisticsService() {
        putToMaps();
        assertEquals(167.66, ORDER_STATISTICS.totalProfit());
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
        assertEquals(18.98, RoundUtil.up(PIZZA_PRICE.pricePizzaFourCheeseWithoutVAT()));
    }

    @Test
    void pricePizzaFourCheeseIncludingVAT_PizzaPriceService() {
        assertEquals(22.78, RoundUtil.up(PIZZA_PRICE.pricePizzaFourCheeseIncludingVAT()));
    }

    @Test
    void pricePizzaMargheritaWithoutVAT_PizzaPriceService() {
        assertEquals(16.38, RoundUtil.up(PIZZA_PRICE.pricePizzaMargheritaWithoutVAT()));
    }

    @Test
    void pricePizzaMargheritaIncludingVAT_PizzaPriceService() {
        assertEquals(19.66, RoundUtil.up(PIZZA_PRICE.pricePizzaMargheritaIncludingVAT()));
    }

    @Test
    void pricePizzaMeatDelightWithoutVAT_PizzaPriceService() {
        assertEquals(36.92, RoundUtil.up(PIZZA_PRICE.pricePizzaMeatDelightWithoutVAT()));
    }

    @Test
    void pricePizzaMeatDelightIncludingVAT_PizzaPriceService() {
        assertEquals(44.3, RoundUtil.up(PIZZA_PRICE.pricePizzaMeatDelightIncludingVAT()));
    }

    @Test
    void pricePizzaPepperoniWithoutVAT_PizzaPriceService() {
        assertEquals(28.08, RoundUtil.up(PIZZA_PRICE.pricePizzaPepperoniWithoutVAT()));
    }

    @Test
    void pricePizzaPepperoniIncludingVAT_PizzaPriceService() {
        assertEquals(33.7, RoundUtil.up(PIZZA_PRICE.pricePizzaPepperoniIncludingVAT()));
    }

    @Test
    void pricePizzaVegetarianWithoutVAT_PizzaPriceService() {
        assertEquals(22.88, RoundUtil.up(PIZZA_PRICE.pricePizzaVegetarianWithoutVAT()));
    }

    @Test
    void pricePizzaVegetarianIncludingVAT_PizzaPriceService() {
        assertEquals(27.46, RoundUtil.up(PIZZA_PRICE.pricePizzaVegetarianIncludingVAT()));
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
