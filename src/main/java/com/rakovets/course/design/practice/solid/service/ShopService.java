package com.rakovets.course.design.practice.solid.service;

import com.rakovets.course.design.practice.solid.model.Pizza;
import com.rakovets.course.design.practice.solid.model.ingredient.Ingredient;
import com.rakovets.course.design.practice.solid.model.payment.Payment;

import java.util.Collection;

public interface ShopService {
    Pizza makePizzaFromTheChef(String name, Collection<Ingredient> ingredients);

    Pizza makePizzaMargaritta(String name, Collection<Ingredient> ingredients);

    Pizza makePizzaPepperoni(String name, Collection<Ingredient> ingredients);

    Pizza makePizzaPesto(String name, Collection<Ingredient> ingredients);

    Pizza makePizzaVegetarian(String name, Collection<Ingredient> ingredients);

    Payment makePaymentByCard(String name, double amount);

    Payment makePaymentByCash(String name, double amount);

    Payment makePaymentByOnline(String name, double amount);
}
