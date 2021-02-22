package com.rakovets.course.design.practice.solid.Pizza.Ingredients;

import java.util.Objects;

public class Olives implements Ingredient {
    private final double COST_PER_UNIT = 2.50;
    int ID = 29;

    public double getPrice() {
        return COST_PER_UNIT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Olives)) return false;
        Olives olives = (Olives) o;
        return ID == olives.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    public String toString() {
        return "Olives{" +
                "COST_PER_UNIT=" + COST_PER_UNIT +
                '}';
    }
}