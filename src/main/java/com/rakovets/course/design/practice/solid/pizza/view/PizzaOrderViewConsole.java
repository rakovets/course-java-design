package com.rakovets.course.design.practice.solid.pizza.view;

import com.rakovets.course.design.practice.solid.pizza.exceptions.PaymentChoiceException;
import com.rakovets.course.design.practice.solid.pizza.exceptions.PizzaNumberException;
import com.rakovets.course.design.practice.solid.pizza.model.Pizza;
import com.rakovets.course.design.practice.solid.pizza.service.*;

import java.time.LocalDateTime;

public class PizzaOrderViewConsole implements PizzaOrderView {
    private static final PizzaPriceService PIZZA_PRICE;
    private static final PizzaCaloriesService PIZZA_CALORIES_SERVICE;
    private static final PizzaNumberException PIZZA_NUMBER_EXCEPTION;
    private static final PaymentChoiceException PAYMENT_CHOICE_EXCEPTION;

    static {
        PIZZA_PRICE = new PizzaPriceService();
        PIZZA_CALORIES_SERVICE = new PizzaCaloriesService();
        PIZZA_NUMBER_EXCEPTION = new PizzaNumberException();
        PAYMENT_CHOICE_EXCEPTION = new PaymentChoiceException();
    }

    public void greeting() {
        System.out.println("\nWELCOME TO PIZZERIA!");
        System.out.println("Choose what pizza you would like to order:");
    }

    public void pizzaMenu() {
        System.out.println("1. Four Cheese");
        System.out.println("2. Margherita");
        System.out.println("3. Meat Delight");
        System.out.println("4. Pepperoni");
        System.out.println("5. Vegetarian");
    }

    public String orderPizzaFourCheese() {
        return DateFormatService.localDatePattern(LocalDateTime.now()) + "\t" + Pizza.FOUR_CHEESE +
                "\t" + RoundUpService.roundUp(PIZZA_PRICE.pricePizzaFourCheeseIncludingVAT()) + "$";
    }

    public String orderPizzaMargherita() {
        return DateFormatService.localDatePattern(LocalDateTime.now()) + "\t" + Pizza.MARGHERITA +
                "\t" + RoundUpService.roundUp(PIZZA_PRICE.pricePizzaMargheritaIncludingVAT()) + "$";
    }

    public String orderPizzaMeatDelight() {
        return DateFormatService.localDatePattern(LocalDateTime.now()) + "\t" + Pizza.MEAT_DELIGHT +
                "\t" + RoundUpService.roundUp(PIZZA_PRICE.pricePizzaMeatDelightIncludingVAT()) + "$";
    }

    public String orderPizzaPepperoni() {
        return DateFormatService.localDatePattern(LocalDateTime.now()) + "\t" + Pizza.PEPPERONI +
                "\t" + RoundUpService.roundUp(PIZZA_PRICE.pricePizzaPepperoniIncludingVAT()) + "$";
    }

    public String orderPizzaVegetarian() {
        return DateFormatService.localDatePattern(LocalDateTime.now()) + "\t" + Pizza.VEGETARIAN +
                "\t" + RoundUpService.roundUp(PIZZA_PRICE.pricePizzaVegetarianIncludingVAT()) + "$";
    }

    public void displayInfoPizzaFourCheese() {
        System.out.println("Pizza " + Pizza.FOUR_CHEESE + " Calories: " +
                PIZZA_CALORIES_SERVICE.caloriesPizzaFourCheese() +
                ", Ingredients: " + Pizza.FOUR_CHEESE.getIngredients());
    }

    public void displayInfoPizzaMargherita() {
        System.out.println("Pizza " + Pizza.MARGHERITA + " Calories: " +
                PIZZA_CALORIES_SERVICE.caloriesPizzaMargherita() +
                ", Ingredients: " + Pizza.MARGHERITA.getIngredients());
    }

    public void displayInfoPizzaMeatDelight() {
        System.out.println("Pizza " + Pizza.MEAT_DELIGHT + " Calories: " +
                PIZZA_CALORIES_SERVICE.caloriesPizzaMeatDelight() +
                ", Ingredients: " + Pizza.MEAT_DELIGHT.getIngredients());
    }

    public void displayInfoPizzaPepperoni() {
        System.out.println("Pizza " + Pizza.PEPPERONI + " Calories: " +
                PIZZA_CALORIES_SERVICE.caloriesPizzaPepperoni() +
                ", Ingredients: " + Pizza.PEPPERONI.getIngredients());
    }

    public void displayInfoPizzaVegetarian() {
        System.out.println("Pizza " + Pizza.VEGETARIAN + " Calories: " +
                PIZZA_CALORIES_SERVICE.caloriesPizzaVegetarian() +
                ", Ingredients: " + Pizza.VEGETARIAN.getIngredients());
    }

    public void totalOrder(double totalOrder, int size) {
        System.out.println("Order is " + RoundUpService.roundUp(totalOrder) + "$\nNumber of pizzas: " + size);
    }

    public void discountFor2Pizzas(double totalOrder) {
        System.out.println("Discount for ordering 2 pizzas: "
                + RoundUpService.roundUp(totalOrder -
                DiscountService.discountForTwoItems(totalOrder)) + "$");
    }

    public void discountFor3AndMorePizzas(double totalOrder) {
        System.out.println("Discount for ordering 3 & more pizzas: "
                + RoundUpService.roundUp(totalOrder -
                DiscountService.discountForThreeAndMoreItems(totalOrder)) + "$");
    }

    public void discountForOrderOnSpecificDay(double totalOrder) {
        System.out.println("Discount for ordering on Discount Day: "
                + RoundUpService.roundUp(totalOrder -
                DiscountService.discountForOrderOnSpecificDay(totalOrder)) + "$");
    }

    public void amountToPay(double totalOrder) {
        System.out.println("Amount to pay: " + RoundUpService.roundUp(totalOrder) + "$");
    }

    public void addPizzaQuestion() {
        System.out.println("\nDo you want to order anything else (Type y or n)");
    }

    public void paymentChoice() {
        System.out.println("How would you like to pay:");
        System.out.println("1. Cash");
        System.out.println("2. Credit card");
        System.out.println("3. Online");
    }

    public void pizzaNumberException() {
        System.out.println(PIZZA_NUMBER_EXCEPTION.toString());
    }

    public void paymentChoiceException() {
        System.out.println(PAYMENT_CHOICE_EXCEPTION.toString());
    }
}
