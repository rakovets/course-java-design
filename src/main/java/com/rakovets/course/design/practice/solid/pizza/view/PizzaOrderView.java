package com.rakovets.course.design.practice.solid.pizza.view;

public interface PizzaOrderView {

    void greeting();

    void pizzaMenu();

    String orderPizzaFourCheese();

    String orderPizzaMargherita();

    String orderPizzaMeatDelight();

    String orderPizzaPepperoni();

    String orderPizzaVegetarian();

    void displayInfoPizzaFourCheese();

    void displayInfoPizzaMargherita();

    void displayInfoPizzaMeatDelight();

    void displayInfoPizzaPepperoni();

    void displayInfoPizzaVegetarian();

    void totalOrder(double totalOrder, int size);

    void discountFor2Pizzas(double totalOrder);

    void discountFor3AndMorePizzas(double totalOrder);

    void discountForOrderOnSpecificDay(double totalOrder);

    void amountToPay(double totalOrder);

    void addPizzaQuestion();

    void paymentChoice();

    void invalidInput();

    void pizzaNumberException();

    void paymentChoiceException();

}
