package com.rakovets.course.design.practice.solid.Pizza.Ingredients;

import java.util.Objects;

public class TraditionalDough implements Ingredient {
    private final double COST_PER_UNIT = 2.50;
    int ID = 59;

    public double getPrice() {
        return COST_PER_UNIT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TraditionalDough)) return false;
        TraditionalDough that = (TraditionalDough) o;
        return ID == that.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    public String toString() {
        return "TraditionalDough{" +
                "COST_PER_UNIT=" + COST_PER_UNIT +
                '}';
    }
}