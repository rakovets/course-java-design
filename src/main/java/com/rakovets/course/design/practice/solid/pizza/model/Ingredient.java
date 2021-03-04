package com.rakovets.course.design.practice.solid.pizza.model;

public enum Ingredient {
    CHEESE(2.50),
    CRUST(2.00),
    MEAT(5.20),
    OLIVES(2.50),
    OREGANO(1.10),
    PEPPER(1.80),
    SAUCE(1.00),
    SAUSAGES(6.00),
    THIN_DOUGH(1.90),
    TOMATOES(1.50),
    TRADITIONAL_DOUGH(2.50);
    private final double costPerUnit;

    Ingredient(double costPerUnit) {
        this.costPerUnit = costPerUnit;
    }

    public double getCostPerUnit() {
        return costPerUnit;
    }
}