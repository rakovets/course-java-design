package com.rakovets.course.design.practice.pizzeria.repository;

import com.rakovets.course.design.practice.pizzeria.model.Pizza;
import com.rakovets.course.design.practice.pizzeria.model.Product;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rakovets.course.design.practice.pizzeria.service.Loader.*;

public class Starter {
    public static Set<String> payments;
    public static Set<String> pizzaNames;
    public static Map<String, Product> pizzaMap;

    public static void start() {
        Storage.setIngredients(loadIngredients());
        Account.setAccount(loadAccount());
        Discounts.setByDay(loadDiscountsByDay());
        Discounts.setByAmountOfPizzas(loadDiscountsByAmountOfPizzas());
        SellStory.setSellStoryOfPizzas(loadSellStoryOfPizzas());
        payments = loadPayments();
        pizzaNames = loadPizzaNames();
        pizzaMap = pizzaNames.stream().collect(Collectors.toMap(s -> s, Pizza::new));
    }
}
