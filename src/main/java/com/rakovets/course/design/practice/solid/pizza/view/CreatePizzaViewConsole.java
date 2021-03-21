package com.rakovets.course.design.practice.solid.pizza.view;

import com.rakovets.course.design.practice.solid.pizza.model.Ingredient;
import com.rakovets.course.design.practice.solid.pizza.service.*;

import java.time.LocalDateTime;

public class CreatePizzaViewConsole implements CreatePizzaView {
    private static final CardPaymentService cardPaymentService;
    private static final OnlinePaymentService onlinePaymentService;
    private static final IngredientPriceService ingredientPrice;

    static {
        cardPaymentService = new CardPaymentService();
        onlinePaymentService = new OnlinePaymentService();
        ingredientPrice = new IngredientPriceService();
    }

    public void greeting() {
        System.out.println("\nWELCOME TO PIZZERIA!");
        System.out.println("You can create your own pizza");
    }

    public void menuDough() {
        System.out.println("Choose type of dough you would like to have:");
        System.out.println("1. Thin Dough");
        System.out.println("2. Traditional Dough");
    }

    public void menuIngredients() {
        System.out.println("Choose ingredients you would like to have in your pizza:");
        System.out.println("1. Cheese");
        System.out.println("2. Meat");
        System.out.println("3. Sausages");
        System.out.println("4. Olives");
        System.out.println("5. Tomatoes");
        System.out.println("6. Pepper");
        System.out.println("7. Oregano");
        System.out.println("8. Sauce");
        System.out.println("9. Cheese crust");
    }

    public String orderThinDough() {
        return DateFormatService.localDatePattern(LocalDateTime.now()) + "\t" + Ingredient.THIN_DOUGH +
                "\t" + RoundUpService.roundUp(ingredientPrice.priceThinDoughIncludingVAT()) + "$";
    }

    public String orderTraditionalDough() {
        return DateFormatService.localDatePattern(LocalDateTime.now()) + "\t" + Ingredient.TRADITIONAL_DOUGH +
                "\t" + RoundUpService.roundUp(ingredientPrice.priceTraditionalDoughIncludingVAT()) + "$";
    }

    public String orderCheese() {
        return DateFormatService.localDatePattern(LocalDateTime.now()) + "\t" + Ingredient.CHEESE +
                "\t" + RoundUpService.roundUp(ingredientPrice.priceCheeseIncludingVAT()) + "$";
    }

    public String orderMeat() {
        return DateFormatService.localDatePattern(LocalDateTime.now()) + "\t" + Ingredient.MEAT +
                "\t" + RoundUpService.roundUp(ingredientPrice.priceMeatIncludingVAT()) + "$";
    }

    public String orderSausages() {
        return DateFormatService.localDatePattern(LocalDateTime.now()) + "\t" + Ingredient.SAUSAGES +
                "\t" + RoundUpService.roundUp(ingredientPrice.priceSausagesIncludingVAT()) + "$";
    }

    public String orderOlives() {
        return DateFormatService.localDatePattern(LocalDateTime.now()) + "\t" + Ingredient.OLIVES +
                "\t" + RoundUpService.roundUp(ingredientPrice.priceOlivesIncludingVAT()) + "$";
    }

    public String orderTomatoes() {
        return DateFormatService.localDatePattern(LocalDateTime.now()) + "\t" + Ingredient.TOMATOES +
                "\t" + RoundUpService.roundUp(ingredientPrice.priceTomatoesIncludingVAT()) + "$";
    }

    public String orderPepper() {
        return DateFormatService.localDatePattern(LocalDateTime.now()) + "\t" + Ingredient.PEPPER +
                "\t" + RoundUpService.roundUp(ingredientPrice.pricePepperIncludingVAT()) + "$";
    }

    public String orderOregano() {
        return DateFormatService.localDatePattern(LocalDateTime.now()) + "\t" + Ingredient.OREGANO +
                "\t" + RoundUpService.roundUp(ingredientPrice.priceOreganoIncludingVAT()) + "$";
    }

    public String orderSauce() {
        return DateFormatService.localDatePattern(LocalDateTime.now()) + "\t" + Ingredient.SAUCE +
                "\t" + RoundUpService.roundUp(ingredientPrice.priceSauceIncludingVAT()) + "$";
    }

    public String orderCrust() {
        return DateFormatService.localDatePattern(LocalDateTime.now()) + "\t" + Ingredient.CRUST +
                "\t" + RoundUpService.roundUp(ingredientPrice.priceCrustIncludingVAT()) + "$";
    }

    public void totalOrder(double totalOrder) {
        System.out.println("Total order is " + totalOrder + "$");
    }

    public void addDoughQuestion() {
        System.out.println("\nDo you want to add dough? (Type y or n)");
    }

    public void addIngredientsQuestion() {
        System.out.println("\nDo you want to add more ingredients? (Type y or n)");
    }

    public void paymentChoice() {
        System.out.println("How would you like to pay:");
        System.out.println("1. Cash");
        System.out.println("2. Credit card");
        System.out.println("3. Online");
    }
}
