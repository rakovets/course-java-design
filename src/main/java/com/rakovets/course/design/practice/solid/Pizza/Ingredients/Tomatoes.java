package com.rakovets.course.design.practice.solid.Pizza.Ingredients;

import java.util.Objects;

public class Tomatoes implements Ingredient {
    private final double COST_PER_UNIT = 1.50;
    int ID = 53;

    public double getPrice() {
        return COST_PER_UNIT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tomatoes)) return false;
        Tomatoes tomatoes = (Tomatoes) o;
        return ID == tomatoes.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    public String toString() {
        return "Tomatoes{" +
                "COST_PER_UNIT=" + COST_PER_UNIT +
                '}';
    }
}