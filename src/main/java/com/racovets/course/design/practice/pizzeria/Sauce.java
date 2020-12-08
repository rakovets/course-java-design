package com.racovets.course.design.practice.pizzeria;

public class Sauce extends Ingredients {
    private Accounting accounting;
    public Sauce (String name, int price, IngredientsRepository ingredientsRepository) {
        super(name, price, ingredientsRepository);
    }

    public void addSauceToRepository(Sauce sauce, int sauceQuantity){
        getIngredientsRepository().getIngredients().put(sauce.getName(), getIngredientsRepository().getIngredients().get(sauce.getName()) + sauceQuantity);
        int sauceCost = sauce.getPrice() * sauceQuantity;
        accounting.getCost().add(sauceCost);
    }


}
