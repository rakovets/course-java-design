package com.rakovets.course.design.practice.solid.Pizza.Ingredients;

import java.util.Objects;

public class Sauce implements Ingredient {
    private final double COST_PER_UNIT = 1.00;
    int ID = 41;

    public double getPrice() {
        return COST_PER_UNIT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sauce)) return false;
        Sauce sauce = (Sauce) o;
        return ID == sauce.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    public String toString() {
        return "Sauce{" +
                "COST_PER_UNIT=" + COST_PER_UNIT +
                '}';
    }
}