package com.rakovets.course.design.practice.solid.model;

import com.rakovets.course.design.practice.solid.model.ingredient.Ingredient;
import com.rakovets.course.design.practice.solid.service.Price;
import com.rakovets.course.design.practice.solid.service.Weight;
import lombok.Getter;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

public class Pizza extends PizzaShopItem implements Price, Weight {
    @Getter
    private final Collection<Ingredient> ingredients;

    public Pizza(String name, Collection<Ingredient> ingredients) {
        super(name);
        this.ingredients = ingredients;
    }

    @Override
    public double getPrice() {
        return ingredients.stream()
                .mapToDouble(Ingredient::getPrice)
                .sum();
    }

    @Override
    public double getWeight() {
        return ingredients.stream()
                .mapToDouble(Ingredient::getWeight).sum();
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
        Pizza pizza = (Pizza) o;
        return ingredients.equals(pizza.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ingredients);
    }

    @Override
    public String toString() {
        return ingredients.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
