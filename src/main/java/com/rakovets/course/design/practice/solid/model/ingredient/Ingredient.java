package com.rakovets.course.design.practice.solid.model.ingredient;

import com.rakovets.course.design.practice.solid.model.PizzaShopItem;
import com.rakovets.course.design.practice.solid.service.Price;
import com.rakovets.course.design.practice.solid.service.Weight;
import lombok.Setter;

import java.util.Objects;

public abstract class Ingredient extends PizzaShopItem implements Price, Weight {
    @Setter
    private double price;
    @Setter
    private double weight;

    protected Ingredient(String name, double price, double weight) {
        super(name);
        this.price = price;
        this.weight = weight;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Ingredient that = (Ingredient) o;
        return Double.compare(that.price, price) == 0 && Double.compare(that.weight, weight) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), price, weight);
    }

    @Override
    public String toString() {
        return String.format("%nName: %s | " + "Price: %.2f$ | " + "Weight: %.2f", getName(), getPrice(), getWeight());
    }
}
