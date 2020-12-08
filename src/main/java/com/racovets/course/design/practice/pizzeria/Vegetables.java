package com.racovets.course.design.practice.pizzeria;

public class Vegetables extends Ingredients {
    private Accounting accounting;
    public Vegetables (String name, int price, IngredientsRepository ingredientsRepository) {
        super(name, price, ingredientsRepository);
    }
    public void addVegetablesToRepository(Vegetables vegetables, int vegetablesQuantity) {
        getIngredientsRepository().getIngredients().put(vegetables.getName(), getIngredientsRepository().getIngredients().get(vegetables.getName()) + vegetablesQuantity);
        int vegetablesCost = vegetables.getPrice() * vegetablesQuantity;
        accounting.getCost().add(vegetablesCost);
    }
}
