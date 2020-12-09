package com.racovets.course.design.practice.pizzeria.model;

public abstract class Ingredients {
    private String name;
    private int price;

    public Ingredients(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Ingredients ingredients = (Ingredients) obj;
        return name.equals(ingredients.getName()) && price == ingredients.getPrice();
    }

    @Override
    public String toString() {
        return name + " price: " + price;
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
