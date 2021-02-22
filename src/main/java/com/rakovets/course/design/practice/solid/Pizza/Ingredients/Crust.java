package com.rakovets.course.design.practice.solid.Pizza.Ingredients;

import java.util.Objects;

public class Crust implements Ingredient {
    private final double COST_PER_UNIT = 2.00;
    int ID = 19;

    public double getPrice() {
        return COST_PER_UNIT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Crust)) return false;
        Crust crust = (Crust) o;
        return ID == crust.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    public String toString() {
        return "Crust{" +
                "COST_PER_UNIT=" + COST_PER_UNIT +
                '}';
    }
}