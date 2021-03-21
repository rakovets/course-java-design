package com.rakovets.course.design.practice.solid.pizza.view;

import com.rakovets.course.design.practice.solid.pizza.model.Pizza;
import com.rakovets.course.design.practice.solid.pizza.service.*;

import java.io.IOException;
import java.time.LocalDateTime;

public class PizzaOrderViewConsole implements PizzaOrderView {
    private static final PizzaPriceService pizzaPrice;
    public static PizzaOrderService pizzaOrderService;
    private static final PizzaCaloriesService pizzaCaloriesService;

    static {
        try {
            pizzaOrderService = new PizzaOrderService();
        } catch (IOException e) {
            e.printStackTrace();
        }
        pizzaPrice = new PizzaPriceService();
        pizzaCaloriesService = new PizzaCaloriesService();
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
                "\t" + RoundUpService.roundUp(pizzaPrice.pricePizzaFourCheeseIncludingVAT()) + "$";
    }

    public String orderPizzaMargherita() {
        return DateFormatService.localDatePattern(LocalDateTime.now()) + "\t" + Pizza.MARGHERITA +
                "\t" + RoundUpService.roundUp(pizzaPrice.pricePizzaMargheritaIncludingVAT()) + "$";
    }

    public String orderPizzaMeatDelight() {
        return DateFormatService.localDatePattern(LocalDateTime.now()) + "\t" + Pizza.MEAT_DELIGHT +
                "\t" + RoundUpService.roundUp(pizzaPrice.pricePizzaMeatDelightIncludingVAT()) + "$";
    }

    public String orderPizzaPepperoni() {
        return DateFormatService.localDatePattern(LocalDateTime.now()) + "\t" + Pizza.PEPPERONI +
                "\t" + RoundUpService.roundUp(pizzaPrice.pricePizzaPepperoniIncludingVAT()) + "$";
    }

    public String orderPizzaVegetarian() {
        return DateFormatService.localDatePattern(LocalDateTime.now()) + "\t" + Pizza.VEGETARIAN +
                "\t" + RoundUpService.roundUp(pizzaPrice.pricePizzaVegetarianIncludingVAT()) + "$";
    }

    public void displayCaloriesPizzaFourCheese() {
        System.out.println("Pizza " + Pizza.FOUR_CHEESE + " Calories: " +
                pizzaCaloriesService.caloriesPizzaFourCheese());
    }

    public void displayCaloriesPizzaMargherita() {
        System.out.println("Pizza " + Pizza.MARGHERITA + " Calories: " +
                pizzaCaloriesService.caloriesPizzaMargherita());
    }

    public void displayCaloriesPizzaMeatDelight() {
        System.out.println("Pizza " + Pizza.MEAT_DELIGHT + " Calories: " +
                pizzaCaloriesService.caloriesPizzaMeatDelight());
    }

    public void displayCaloriesPizzaPepperoni() {
        System.out.println("Pizza " + Pizza.PEPPERONI + " Calories: " +
                pizzaCaloriesService.caloriesPizzaPepperoni());
    }

    public void displayCaloriesPizzaVegetarian() {
        System.out.println("Pizza " + Pizza.VEGETARIAN + " Calories: " +
                pizzaCaloriesService.caloriesPizzaVegetarian());
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
}
