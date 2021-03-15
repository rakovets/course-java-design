package com.rakovets.course.design.practice.solid.pizza.view;

import com.rakovets.course.design.practice.solid.pizza.service.CardPaymentService;
import com.rakovets.course.design.practice.solid.pizza.service.CashPaymentService;
import com.rakovets.course.design.practice.solid.pizza.service.OnlinePaymentService;

public class CreatePizzaViewConsole implements CreatePizzaView {
    private static final CashPaymentService cashPaymentService;
    private static final CardPaymentService cardPaymentService;
    private static final OnlinePaymentService onlinePaymentService;

    static {
        cashPaymentService = new CashPaymentService();
        cardPaymentService = new CardPaymentService();
        onlinePaymentService = new OnlinePaymentService();
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

    public void totalOrder(double totalOrder) {
        System.out.println("Total order is " + totalOrder + "$");
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

    public void cashPayment() {
        System.out.println(cashPaymentService.toString());
    }

    public void cardPayment() {
        System.out.println(cardPaymentService.toString());
    }

    public void onlinePayment() {
        System.out.println(onlinePaymentService.toString());
    }
}