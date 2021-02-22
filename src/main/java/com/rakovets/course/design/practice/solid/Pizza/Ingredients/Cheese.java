package com.rakovets.course.design.practice.solid.Pizza.Ingredients;

import java.util.Objects;

public class Cheese implements Ingredient {
    private final double COST_PER_UNIT = 2.50;
    int ID = 17;

    public double getPrice() {
        return COST_PER_UNIT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cheese)) return false;
        Cheese cheese = (Cheese) o;
        return ID == cheese.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    public String toString() {
        return "Cheese{" +
                "COST_PER_UNIT=" + COST_PER_UNIT +
                '}';
    }
}