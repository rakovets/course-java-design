package com.rakovets.course.design.practice.solid.service.impl;

import com.rakovets.course.design.practice.solid.model.Pizza;
import com.rakovets.course.design.practice.solid.model.ingredient.Ingredient;
import com.rakovets.course.design.practice.solid.model.payment.Card;
import com.rakovets.course.design.practice.solid.model.payment.Cash;
import com.rakovets.course.design.practice.solid.model.payment.Online;
import com.rakovets.course.design.practice.solid.model.payment.Payment;
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

    @Contract(pure = true)
    @Override
    public @NotNull Payment makePaymentByCard(String name, double amount) {
        return new Card(name, amount);
    }

    @Contract(pure = true)
    @Override
    public @NotNull Payment makePaymentByCash(String name, double amount) {
        return new Cash(name, amount);
    }

    @Contract(pure = true)
    @Override
    public @NotNull Payment makePaymentByOnline(String name, double amount) {
        return new Online(name, amount);
    }
}
