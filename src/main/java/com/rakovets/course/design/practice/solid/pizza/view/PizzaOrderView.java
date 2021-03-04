package com.rakovets.course.design.practice.solid.pizza.view;

public interface PizzaOrderView {

    void greeting();

    void pizzaMenu();

    void orderPizzaFourCheese();

    void orderPizzaMargherita();

    void orderPizzaMeatDelight();

    void orderPizzaPepperoni();

    void orderPizzaVegetarian();

    void totalOrder(double totalOrder, int size);

    void discountFor2Pizzas(double totalOrder);

    void discountFor3AndMorePizzas(double totalOrder);

    void discountForOrderOnSpecificDay(double totalOrder);

    void amountToPay(double totalOrder);

    void addPizzaQuestion();

    void paymentChoice();

    void cashPayment();

    void cardPayment();

    void onlinePayment();

}
