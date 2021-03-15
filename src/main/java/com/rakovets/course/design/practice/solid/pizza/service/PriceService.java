package com.rakovets.course.design.practice.solid.pizza.service;

public class PriceService {

    public static double pricePizzaFourCheeseWithoutVAT() {
        return ProfitService.profitPercentage(PizzaCostService.getCostFourCheese());
    }

    public static double pricePizzaFourCheeseIncludingVAT() {
        return pricePizzaFourCheeseWithoutVAT() + TaxService.VAT(pricePizzaFourCheeseWithoutVAT());
    }

    public static double pricePizzaMargheritaWithoutVAT() {
        return ProfitService.profitPercentage(PizzaCostService.getCostMargherita());
    }

    public static double pricePizzaMargheritaIncludingVAT() {
        return pricePizzaMargheritaWithoutVAT() + TaxService.VAT(pricePizzaMargheritaWithoutVAT());
    }

    public static double pricePizzaMeatDelightWithoutVAT() {
        return ProfitService.profitPercentage(PizzaCostService.getCostMeatDelight());
    }

    public static double pricePizzaMeatDelightIncludingVAT() {
        return pricePizzaMeatDelightWithoutVAT() + TaxService.VAT(pricePizzaMeatDelightWithoutVAT());
    }

    public static double pricePizzaPepperoniWithoutVAT() {
        return ProfitService.profitPercentage(PizzaCostService.getCostPepperoni());
    }

    public static double pricePizzaPepperoniIncludingVAT() {
        return pricePizzaPepperoniWithoutVAT() + TaxService.VAT(pricePizzaPepperoniWithoutVAT());
    }

    public static double pricePizzaVegetarianWithoutVAT() {
        return ProfitService.profitPercentage(PizzaCostService.getCostVegetarian());
    }

    public static double pricePizzaVegetarianIncludingVAT() {
        return pricePizzaVegetarianWithoutVAT() + TaxService.VAT(pricePizzaVegetarianWithoutVAT());
    }
}
