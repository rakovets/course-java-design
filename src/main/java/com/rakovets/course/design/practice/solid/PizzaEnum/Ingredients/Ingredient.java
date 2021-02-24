package com.rakovets.course.design.practice.solid.PizzaEnum.Ingredients;

public enum Ingredient {
    CHEESE(2.50, 1),
    CRUST(2.00, 1),
    MEAT(5.20, 1),
    OLIVES(2.50, 1),
    OREGANO(1.10, 1),
    PEPPER(1.80, 1),
    SAUCE(1.00, 1),
    SAUSAGES(6.00, 1),
    THIN_DOUGH(1.90, 1),
    TOMATOES(1.50, 1),
    TRADITIONAL_DOUGH(2.50, 1);
    private final double costPerUnit;
    private final int quantity;

    Ingredient(double costPerUnit, int quantity) {
        this.costPerUnit = costPerUnit;
        this.quantity = quantity;
    }

    public double getCostPerUnit() {
        return costPerUnit;
    }

    public int getQuantity() {
        return quantity;
    }
}