package com.rakovets.course.design.practice.solid.Pizza.Ingredients;

import java.util.Objects;

public class Pepper implements Ingredient {
    private final double COST_PER_UNIT = 1.80;
    int ID = 37;

    public double getPrice() {
        return COST_PER_UNIT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pepper)) return false;
        Pepper pepper = (Pepper) o;
        return ID == pepper.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    public String toString() {
        return "Pepper{" +
                "COST_PER_UNIT=" + COST_PER_UNIT +
                '}';
    }
}