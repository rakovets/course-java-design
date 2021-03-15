package com.rakovets.course.design.practice.solid.pizza.service;

public class PizzaPriceService {

    public double pricePizzaFourCheeseWithoutVAT() {
        return ProfitService.profitPercentage(PizzaCostService.getCostFourCheese());
    }

    public double pricePizzaFourCheeseIncludingVAT() {
        return pricePizzaFourCheeseWithoutVAT() + TaxService.VAT(pricePizzaFourCheeseWithoutVAT());
    }

    public double pricePizzaMargheritaWithoutVAT() {
        return ProfitService.profitPercentage(PizzaCostService.getCostMargherita());
    }

    public double pricePizzaMargheritaIncludingVAT() {
        return pricePizzaMargheritaWithoutVAT() + TaxService.VAT(pricePizzaMargheritaWithoutVAT());
    }

    public double pricePizzaMeatDelightWithoutVAT() {
        return ProfitService.profitPercentage(PizzaCostService.getCostMeatDelight());
    }

    public double pricePizzaMeatDelightIncludingVAT() {
        return pricePizzaMeatDelightWithoutVAT() + TaxService.VAT(pricePizzaMeatDelightWithoutVAT());
    }

    public double pricePizzaPepperoniWithoutVAT() {
        return ProfitService.profitPercentage(PizzaCostService.getCostPepperoni());
    }

    public double pricePizzaPepperoniIncludingVAT() {
        return pricePizzaPepperoniWithoutVAT() + TaxService.VAT(pricePizzaPepperoniWithoutVAT());
    }

    public double pricePizzaVegetarianWithoutVAT() {
        return ProfitService.profitPercentage(PizzaCostService.getCostVegetarian());
    }

    public double pricePizzaVegetarianIncludingVAT() {
        return pricePizzaVegetarianWithoutVAT() + TaxService.VAT(pricePizzaVegetarianWithoutVAT());
    }
}
