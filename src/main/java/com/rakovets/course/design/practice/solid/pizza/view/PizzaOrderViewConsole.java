package com.rakovets.course.design.practice.solid.pizza.view;

import com.rakovets.course.design.practice.solid.pizza.exceptions.PaymentChoiceException;
import com.rakovets.course.design.practice.solid.pizza.exceptions.PizzaNumberException;
import com.rakovets.course.design.practice.solid.pizza.model.Pizza;
import com.rakovets.course.design.practice.solid.pizza.service.*;
import com.rakovets.course.design.practice.solid.pizza.util.DateFormatUtil;
import com.rakovets.course.design.practice.solid.pizza.util.DiscountUtil;
import com.rakovets.course.design.practice.solid.pizza.util.PizzaPriceUtil;
import com.rakovets.course.design.practice.solid.pizza.util.RoundUtil;

import java.time.LocalDateTime;

public class PizzaOrderViewConsole implements PizzaOrderView {
    private static final PizzaCaloriesService PIZZA_CALORIES_SERVICE;
    private static final PizzaNumberException PIZZA_NUMBER_EXCEPTION;
    private static final PaymentChoiceException PAYMENT_CHOICE_EXCEPTION;

    static {
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
        return DateFormatUtil.localDatePattern(LocalDateTime.now()) + "\t" + Pizza.FOUR_CHEESE +
                "\t" + RoundUtil.up(PizzaPriceUtil.pricePizzaFourCheeseIncludingVAT()) + "$";
    }

    public String orderPizzaMargherita() {
        return DateFormatUtil.localDatePattern(LocalDateTime.now()) + "\t" + Pizza.MARGHERITA +
                "\t" + RoundUtil.up(PizzaPriceUtil.pricePizzaMargheritaIncludingVAT()) + "$";
    }

    public String orderPizzaMeatDelight() {
        return DateFormatUtil.localDatePattern(LocalDateTime.now()) + "\t" + Pizza.MEAT_DELIGHT +
                "\t" + RoundUtil.up(PizzaPriceUtil.pricePizzaMeatDelightIncludingVAT()) + "$";
    }

    public String orderPizzaPepperoni() {
        return DateFormatUtil.localDatePattern(LocalDateTime.now()) + "\t" + Pizza.PEPPERONI +
                "\t" + RoundUtil.up(PizzaPriceUtil.pricePizzaPepperoniIncludingVAT()) + "$";
    }

    public String orderPizzaVegetarian() {
        return DateFormatUtil.localDatePattern(LocalDateTime.now()) + "\t" + Pizza.VEGETARIAN +
                "\t" + RoundUtil.up(PizzaPriceUtil.pricePizzaVegetarianIncludingVAT()) + "$";
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
        System.out.println("Order is " + RoundUtil.up(totalOrder) + "$\nNumber of pizzas: " + size);
    }

    public void discountFor2Pizzas(double totalOrder) {
        System.out.println("Discount for ordering 2 pizzas: "
                + RoundUtil.up(totalOrder -
                DiscountUtil.discountForTwoItems(totalOrder)) + "$");
    }

    public void discountFor3AndMorePizzas(double totalOrder) {
        System.out.println("Discount for ordering 3 & more pizzas: "
                + RoundUtil.up(totalOrder -
                DiscountUtil.discountForThreeAndMoreItems(totalOrder)) + "$");
    }

    public void discountForOrderOnSpecificDay(double totalOrder) {
        System.out.println("Discount for ordering on Discount Day: "
                + RoundUtil.up(totalOrder -
                DiscountUtil.discountForOrderOnSpecificDay(totalOrder)) + "$");
    }

    public void amountToPay(double totalOrder) {
        System.out.println("Amount to pay: " + RoundUtil.up(totalOrder) + "$");
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
