package com.rakovets.course.design.practice.solid.pizza.service;

import com.rakovets.course.design.practice.solid.pizza.model.Ingredient;

public class IngredientPriceService {

    public double priceThinDoughWithoutVAT() {
        return ProfitService.profitPercentage(Ingredient.THIN_DOUGH.getCostPerUnit());
    }

    public double priceThinDoughIncludingVAT() {
        return priceThinDoughWithoutVAT() + TaxService.VAT(priceThinDoughWithoutVAT());
    }

    public double priceTraditionalDoughWithoutVAT() {
        return ProfitService.profitPercentage(Ingredient.TRADITIONAL_DOUGH.getCostPerUnit());
    }

    public double priceTraditionalDoughIncludingVAT() {
        return priceTraditionalDoughWithoutVAT() + TaxService.VAT(priceTraditionalDoughWithoutVAT());
    }

    public double priceCheeseWithoutVAT() {
        return ProfitService.profitPercentage(Ingredient.CHEESE.getCostPerUnit());
    }

    public double priceCheeseIncludingVAT() {
        return priceCheeseWithoutVAT() + TaxService.VAT(priceCheeseWithoutVAT());
    }

    public double priceMeatWithoutVAT() {
        return ProfitService.profitPercentage(Ingredient.MEAT.getCostPerUnit());
    }

    public double priceMeatIncludingVAT() {
        return priceMeatWithoutVAT() + TaxService.VAT(priceMeatWithoutVAT());
    }

    public double priceSausagesWithoutVAT() {
        return ProfitService.profitPercentage(Ingredient.SAUSAGES.getCostPerUnit());
    }

    public double priceSausagesIncludingVAT() {
        return priceSausagesWithoutVAT() + TaxService.VAT(priceSausagesWithoutVAT());
    }

    public double priceOlivesWithoutVAT() {
        return ProfitService.profitPercentage(Ingredient.OLIVES.getCostPerUnit());
    }

    public double priceOlivesIncludingVAT() {
        return priceOlivesWithoutVAT() + TaxService.VAT(priceOlivesWithoutVAT());
    }

    public double priceTomatoesWithoutVAT() {
        return ProfitService.profitPercentage(Ingredient.TOMATOES.getCostPerUnit());
    }

    public double priceTomatoesIncludingVAT() {
        return priceTomatoesWithoutVAT() + TaxService.VAT(priceTomatoesWithoutVAT());
    }

    public double pricePepperWithoutVAT() {
        return ProfitService.profitPercentage(Ingredient.PEPPER.getCostPerUnit());
    }

    public double pricePepperIncludingVAT() {
        return pricePepperWithoutVAT() + TaxService.VAT(pricePepperWithoutVAT());
    }

    public double priceOreganoWithoutVAT() {
        return ProfitService.profitPercentage(Ingredient.OREGANO.getCostPerUnit());
    }

    public double priceOreganoIncludingVAT() {
        return priceOreganoWithoutVAT() + TaxService.VAT(priceOreganoWithoutVAT());
    }

    public double priceSauceWithoutVAT() {
        return ProfitService.profitPercentage(Ingredient.SAUCE.getCostPerUnit());
    }

    public double priceSauceIncludingVAT() {
        return priceSauceWithoutVAT() + TaxService.VAT(priceSauceWithoutVAT());
    }

    public double priceCrustWithoutVAT() {
        return ProfitService.profitPercentage(Ingredient.CRUST.getCostPerUnit());
    }

    public double priceCrustIncludingVAT() {
        return priceCrustWithoutVAT() + TaxService.VAT(priceCrustWithoutVAT());
    }
}
