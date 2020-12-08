package com.racovets.course.design.practice.pizzeria;

import java.lang.reflect.Method;

public class Meat extends Ingredients {
    private IngredientsRepository ingredientsRepository;
    private Accounting accounting;
    public Meat (String name, int price, IngredientsRepository ingredientsRepository) {
        super(name, price, ingredientsRepository);
    }
    public void addMeatToRepository(Meat meat, int meatQuantity) {
        getIngredientsRepository().getIngredients().put(meat.getName(), getIngredientsRepository().getIngredients().get(meat.getName()) + meatQuantity);
        int meatCost = meat.getPrice() * meatQuantity;
        accounting.getCost().add(meatCost);
    }
}
