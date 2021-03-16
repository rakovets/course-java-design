package com.rakovets.course.design.practice.solid.pizza.view;

public interface CreatePizzaView {

    void greeting();

    void menuDough();

    void menuIngredients();

    void totalOrder(double totalOrder);

    void addDoughQuestion();

    void addIngredientsQuestion();

    void paymentChoice();

    void cashPayment();

    void cardPayment();

    void onlinePayment();

}
