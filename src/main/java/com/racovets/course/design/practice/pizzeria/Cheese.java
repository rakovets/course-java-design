package com.racovets.course.design.practice.pizzeria;

import java.time.temporal.ChronoUnit;

public class Cheese extends Ingredients {
    private Accounting accounting;
    public Cheese (String name, int price, IngredientsRepository ingredientsRepository) {
        super(name, price, ingredientsRepository);
    }
    public void addCheeseToRepository(Cheese cheese, int cheeseQuantity) {
        getIngredientsRepository().getIngredients().put(cheese.getName(), getIngredientsRepository().getIngredients().get(cheese.getName()) + cheeseQuantity);
        int cheeseCost = cheese.getPrice() * cheeseQuantity;
        accounting.getCost().add(cheeseCost);
    }
}
