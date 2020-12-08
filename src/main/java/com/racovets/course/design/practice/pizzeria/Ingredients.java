package com.racovets.course.design.practice.pizzeria;

public class Ingredients {
    private String name;
    private int price;
    private int quantity;
    private  IngredientsRepository ingredientsRepository;
    public Ingredients(String name, int price, IngredientsRepository ingredientsRepository) {
        this.name = name;
        this.price = price;
        this.ingredientsRepository = ingredientsRepository;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public IngredientsRepository getIngredientsRepository() {
        return ingredientsRepository;
    }

    public void setIngredientsRepository(IngredientsRepository ingredientsRepository) {
        this.ingredientsRepository = ingredientsRepository;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
