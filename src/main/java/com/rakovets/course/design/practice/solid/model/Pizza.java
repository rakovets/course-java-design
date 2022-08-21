package com.rakovets.course.design.practice.solid.model;

import com.rakovets.course.design.practice.solid.model.ingredient.Ingredient;
import com.rakovets.course.design.practice.solid.service.PizzaState;
import lombok.Getter;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

public class Pizza extends PizzaShopItem implements PizzaState {
    @Getter
    private final Collection<Ingredient> ingredients;

    public Pizza(String name, Collection<Ingredient> ingredients) {
        super(name);
        this.ingredients = ingredients;
    }

    @Override
    public double calculatePrice() {
        return ingredients.stream()
                .mapToDouble(Ingredient::getPrice)
                .sum();
    }

    @Override
    public double calculateWeight() {
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
