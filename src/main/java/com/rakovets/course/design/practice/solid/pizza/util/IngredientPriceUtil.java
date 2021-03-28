package com.rakovets.course.design.practice.solid.pizza.util;

import com.rakovets.course.design.practice.solid.pizza.model.Ingredient;

public final class IngredientPriceUtil {

    private IngredientPriceUtil() {
    }

    public static double priceThinDoughWithoutVAT() {
        return ProfitUtil.profitPercentage(Ingredient.THIN_DOUGH.getCostPerUnit());
    }

    public static double priceThinDoughIncludingVAT() {
        return priceThinDoughWithoutVAT() + TaxUtil.VAT(priceThinDoughWithoutVAT());
    }

    public static double priceTraditionalDoughWithoutVAT() {
        return ProfitUtil.profitPercentage(Ingredient.TRADITIONAL_DOUGH.getCostPerUnit());
    }

    public static double priceTraditionalDoughIncludingVAT() {
        return priceTraditionalDoughWithoutVAT() + TaxUtil.VAT(priceTraditionalDoughWithoutVAT());
    }

    public static double priceCheeseWithoutVAT() {
        return ProfitUtil.profitPercentage(Ingredient.CHEESE.getCostPerUnit());
    }

    public static double priceCheeseIncludingVAT() {
        return priceCheeseWithoutVAT() + TaxUtil.VAT(priceCheeseWithoutVAT());
    }

    public static double priceMeatWithoutVAT() {
        return ProfitUtil.profitPercentage(Ingredient.MEAT.getCostPerUnit());
    }

    public static double priceMeatIncludingVAT() {
        return priceMeatWithoutVAT() + TaxUtil.VAT(priceMeatWithoutVAT());
    }

    public static double priceSausagesWithoutVAT() {
        return ProfitUtil.profitPercentage(Ingredient.SAUSAGES.getCostPerUnit());
    }

    public static double priceSausagesIncludingVAT() {
        return priceSausagesWithoutVAT() + TaxUtil.VAT(priceSausagesWithoutVAT());
    }

    public static double priceOlivesWithoutVAT() {
        return ProfitUtil.profitPercentage(Ingredient.OLIVES.getCostPerUnit());
    }

    public static double priceOlivesIncludingVAT() {
        return priceOlivesWithoutVAT() + TaxUtil.VAT(priceOlivesWithoutVAT());
    }

    public static double priceTomatoesWithoutVAT() {
        return ProfitUtil.profitPercentage(Ingredient.TOMATOES.getCostPerUnit());
    }

    public static double priceTomatoesIncludingVAT() {
        return priceTomatoesWithoutVAT() + TaxUtil.VAT(priceTomatoesWithoutVAT());
    }

    public static double pricePepperWithoutVAT() {
        return ProfitUtil.profitPercentage(Ingredient.PEPPER.getCostPerUnit());
    }

    public static double pricePepperIncludingVAT() {
        return pricePepperWithoutVAT() + TaxUtil.VAT(pricePepperWithoutVAT());
    }

    public static double priceOreganoWithoutVAT() {
        return ProfitUtil.profitPercentage(Ingredient.OREGANO.getCostPerUnit());
    }

    public static double priceOreganoIncludingVAT() {
        return priceOreganoWithoutVAT() + TaxUtil.VAT(priceOreganoWithoutVAT());
    }

    public static double priceSauceWithoutVAT() {
        return ProfitUtil.profitPercentage(Ingredient.SAUCE.getCostPerUnit());
    }

    public static double priceSauceIncludingVAT() {
        return priceSauceWithoutVAT() + TaxUtil.VAT(priceSauceWithoutVAT());
    }

    public static double priceCrustWithoutVAT() {
        return ProfitUtil.profitPercentage(Ingredient.CRUST.getCostPerUnit());
    }

    public static double priceCrustIncludingVAT() {
        return priceCrustWithoutVAT() + TaxUtil.VAT(priceCrustWithoutVAT());
    }
}
