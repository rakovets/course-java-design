package com.rakovets.course.design.practice.solid.pizza.util;

public final class PizzaPriceUtil {

    private PizzaPriceUtil() {
    }

    public static double pricePizzaFourCheeseWithoutVAT() {
        return ProfitUtil.profitPercentage(PizzaCostUtil.getCostFourCheese());
    }

    public static double pricePizzaFourCheeseIncludingVAT() {
        return pricePizzaFourCheeseWithoutVAT() + TaxUtil.VAT(pricePizzaFourCheeseWithoutVAT());
    }

    public static double pricePizzaMargheritaWithoutVAT() {
        return ProfitUtil.profitPercentage(PizzaCostUtil.getCostMargherita());
    }

    public static double pricePizzaMargheritaIncludingVAT() {
        return pricePizzaMargheritaWithoutVAT() + TaxUtil.VAT(pricePizzaMargheritaWithoutVAT());
    }

    public static double pricePizzaMeatDelightWithoutVAT() {
        return ProfitUtil.profitPercentage(PizzaCostUtil.getCostMeatDelight());
    }

    public static double pricePizzaMeatDelightIncludingVAT() {
        return pricePizzaMeatDelightWithoutVAT() + TaxUtil.VAT(pricePizzaMeatDelightWithoutVAT());
    }

    public static double pricePizzaPepperoniWithoutVAT() {
        return ProfitUtil.profitPercentage(PizzaCostUtil.getCostPepperoni());
    }

    public static double pricePizzaPepperoniIncludingVAT() {
        return pricePizzaPepperoniWithoutVAT() + TaxUtil.VAT(pricePizzaPepperoniWithoutVAT());
    }

    public static double pricePizzaVegetarianWithoutVAT() {
        return ProfitUtil.profitPercentage(PizzaCostUtil.getCostVegetarian());
    }

    public static double pricePizzaVegetarianIncludingVAT() {
        return pricePizzaVegetarianWithoutVAT() + TaxUtil.VAT(pricePizzaVegetarianWithoutVAT());
    }
}
