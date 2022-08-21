package com.rakovets.course.design.practice.solid.service.impl;

import com.rakovets.course.design.practice.solid.model.Pizza;
import com.rakovets.course.design.practice.solid.model.ingredient.Ingredient;
import com.rakovets.course.design.practice.solid.service.ShopService;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public final class ShopServiceImpl implements ShopService {
    @Contract("_, _ -> new")
    @Override
    public @NotNull Pizza makePizzaFromTheChef(String name, Collection<Ingredient> ingredients) {
        return new Pizza(name, ingredients);
    }

    @Contract("_, _ -> new")
    @Override
    public @NotNull Pizza makePizzaMargaritta(String name, Collection<Ingredient> ingredients) {
        return new Pizza(name, ingredients);
    }

    @Contract("_, _ -> new")
    @Override
    public @NotNull Pizza makePizzaPepperoni(String name, Collection<Ingredient> ingredients) {
        return new Pizza(name, ingredients);
    }

    @Contract("_, _ -> new")
    @Override
    public @NotNull Pizza makePizzaPesto(String name, Collection<Ingredient> ingredients) {
        return new Pizza(name, ingredients);
    }

    @Contract("_, _ -> new")
    @Override
    public @NotNull Pizza makePizzaVegetarian(String name, Collection<Ingredient> ingredients) {
        return new Pizza(name, ingredients);
    }
}
