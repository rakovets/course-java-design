package com.rakovets.course.design.practice.solid.service.impl;

import com.rakovets.course.design.practice.solid.model.Pizza;
import com.rakovets.course.design.practice.solid.model.ingredient.Ingredient;
import com.rakovets.course.design.practice.solid.service.ShopService;

import java.util.Collection;

public class ShopServiceImpl implements ShopService {
    @Override
    public Pizza makePizzaFromTheChef(String name, Collection<Ingredient> ingredients) {
        return new Pizza(name, ingredients);
    }

    @Override
    public Pizza makePizzaMargaritta(String name, Collection<Ingredient> ingredients) {
        return new Pizza(name, ingredients);
    }

    @Override
    public Pizza makePizzaPepperoni(String name, Collection<Ingredient> ingredients) {
        return new Pizza(name, ingredients);
    }

    @Override
    public Pizza makePizzaPesto(String name, Collection<Ingredient> ingredients) {
        return new Pizza(name, ingredients);
    }

    @Override
    public Pizza makePizzaVegetarian(String name, Collection<Ingredient> ingredients) {
        return new Pizza(name, ingredients);
    }
}
