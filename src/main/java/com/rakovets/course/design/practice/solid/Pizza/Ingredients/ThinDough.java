package com.rakovets.course.design.practice.solid.Pizza.Ingredients;

import java.util.Objects;

public class ThinDough implements Ingredient {
    private final double COST_PER_UNIT = 1.90;
    int ID = 47;

    public double getPrice() {
        return COST_PER_UNIT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ThinDough)) return false;
        ThinDough thinDough = (ThinDough) o;
        return ID == thinDough.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    public String toString() {
        return "ThinDough{" +
                "COST_PER_UNIT=" + COST_PER_UNIT +
                '}';
    }
}