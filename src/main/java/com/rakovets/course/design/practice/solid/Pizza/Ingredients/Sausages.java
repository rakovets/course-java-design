package com.rakovets.course.design.practice.solid.Pizza.Ingredients;

import java.util.Objects;

public class Sausages implements Ingredient {
    private final double COST_PER_UNIT = 6.00;
    int ID = 43;

    public double getPrice() {
        return COST_PER_UNIT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sausages)) return false;
        Sausages sausages = (Sausages) o;
        return ID == sausages.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    public String toString() {
        return "Sausages{" +
                "COST_PER_UNIT=" + COST_PER_UNIT +
                '}';
    }
}