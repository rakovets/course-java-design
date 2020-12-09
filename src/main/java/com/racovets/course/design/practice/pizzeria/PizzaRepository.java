package com.racovets.course.design.practice.pizzeria;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PizzaRepository {
    List<Pizza> pizzaList = new ArrayList<>();
    public PizzaRepository (List<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }
    public Pizza getPizza(int choice) {
        return pizzaList.get(choice - 1);
    }
}
