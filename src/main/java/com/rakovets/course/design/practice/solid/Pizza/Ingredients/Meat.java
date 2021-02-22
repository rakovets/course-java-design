package com.rakovets.course.design.practice.solid.Pizza.Ingredients;

import java.util.Objects;

public class Meat implements Ingredient {
    private final double COST_PER_UNIT = 5.20;
    int ID = 23;

    public double getPrice() {
        return COST_PER_UNIT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Meat)) return false;
        Meat meat = (Meat) o;
        return ID == meat.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    public String toString() {
        return "Meat{" +
                "COST_PER_UNIT=" + COST_PER_UNIT +
                '}';
    }
}