package com.rakovets.course.design.practice.solid.pizza.view;

import com.rakovets.course.design.practice.solid.pizza.exceptions.DoughException;
import com.rakovets.course.design.practice.solid.pizza.exceptions.IngredientNumberException;
import com.rakovets.course.design.practice.solid.pizza.exceptions.PaymentChoiceException;
import com.rakovets.course.design.practice.solid.pizza.model.Ingredient;
import com.rakovets.course.design.practice.solid.pizza.service.*;

import java.time.LocalDateTime;

public class CreatePizzaViewConsole implements CreatePizzaView {
    private static final IngredientPriceService ingredientPrice;
    private static final DoughException doughException;
    private static final IngredientNumberException ingredientNumberException;
    private static final PaymentChoiceException paymentChoiceException;

    static {
        ingredientPrice = new IngredientPriceService();
        doughException = new DoughException();
        ingredientNumberException = new IngredientNumberException();
        paymentChoiceException = new PaymentChoiceException();
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

    public void displayCaloriesThinDough() {
        System.out.println("Ingredient " + Ingredient.THIN_DOUGH + " Calories: " +
                Ingredient.THIN_DOUGH.getCalories());
    }

    public void displayCaloriesTraditionalDough() {
        System.out.println("Ingredient " + Ingredient.TRADITIONAL_DOUGH + " Calories: " +
                Ingredient.TRADITIONAL_DOUGH.getCalories());
    }

    public void displayCaloriesCheese() {
        System.out.println("Ingredient " + Ingredient.CHEESE + " Calories: " +
                Ingredient.CHEESE.getCalories());
    }

    public void displayCaloriesMeat() {
        System.out.println("Ingredient " + Ingredient.MEAT + " Calories: " +
                Ingredient.MEAT.getCalories());
    }

    public void displayCaloriesSausages() {
        System.out.println("Ingredient " + Ingredient.SAUSAGES + " Calories: " +
                Ingredient.SAUSAGES.getCalories());
    }

    public void displayCaloriesOlives() {
        System.out.println("Ingredient " + Ingredient.OLIVES + " Calories: " +
                Ingredient.OLIVES.getCalories());
    }

    public void displayCaloriesTomatoes() {
        System.out.println("Ingredient " + Ingredient.TOMATOES + " Calories: " +
                Ingredient.TOMATOES.getCalories());
    }

    public void displayCaloriesPepper() {
        System.out.println("Ingredient " + Ingredient.PEPPER + " Calories: " +
                Ingredient.PEPPER.getCalories());
    }

    public void displayCaloriesOregano() {
        System.out.println("Ingredient " + Ingredient.OREGANO + " Calories: " +
                Ingredient.OREGANO.getCalories());
    }

    public void displayCaloriesSauce() {
        System.out.println("Ingredient " + Ingredient.SAUCE + " Calories: " +
                Ingredient.SAUCE.getCalories());
    }

    public void displayCaloriesCrust() {
        System.out.println("Ingredient " + Ingredient.CRUST + " Calories: " +
                Ingredient.CRUST.getCalories());
    }

    public void totalCalories(int totalCalories) {
        System.out.println("Total Calories of Created Pizza: " + totalCalories);
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

    public void invalidInput() {
        System.out.println("Your input is invalid. You must enter a digit");
    }

    public void doughException() {
        System.out.println(doughException.toString());
    }

    public void ingredientNumberException() {
        System.out.println(ingredientNumberException.toString());
    }

    public void paymentChoiceException() {
        System.out.println(paymentChoiceException.toString());
    }
}
