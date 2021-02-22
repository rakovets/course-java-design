package com.rakovets.course.design.practice.solid.Pizza.Ingredients;

import java.util.Objects;

public class Oregano implements Ingredient {
    private final double COST_PER_UNIT = 1.10;
    int ID = 31;

    public double getPrice() {
        return COST_PER_UNIT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Oregano)) return false;
        Oregano oregano = (Oregano) o;
        return ID == oregano.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    public String toString() {
        return "Oregano{" +
                "COST_PER_UNIT=" + COST_PER_UNIT +
                '}';
    }
}