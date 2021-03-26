package com.rakovets.course.design.practice.solid.pizza.view;

public interface CreatePizzaView {

    void greeting();

    void menuDough();

    void menuIngredients();

    String orderThinDough();

    String orderTraditionalDough();

    String orderCheese();

    String orderMeat();

    String orderSausages();

    String orderOlives();

    String orderTomatoes();

    String orderPepper();

    String orderOregano();

    String orderSauce();

    String orderCrust();

    void displayCaloriesThinDough();

    void displayCaloriesTraditionalDough();

    void displayCaloriesCheese();

    void displayCaloriesMeat();

    void displayCaloriesSausages();

    void displayCaloriesOlives();

    void displayCaloriesTomatoes();

    void displayCaloriesPepper();

    void displayCaloriesOregano();

    void displayCaloriesSauce();

    void displayCaloriesCrust();

    void totalCalories(int totalCalories);

    void totalOrder(double totalOrder);

    void addDoughQuestion();

    void addIngredientsQuestion();

    void paymentChoice();

    void doughException();

    void ingredientNumberException();

    void paymentChoiceException();

}
