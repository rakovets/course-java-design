package com.rakovets.course.design.practice.pizzeria.service;

import com.rakovets.course.design.practice.pizzeria.model.Product;
import com.rakovets.course.design.practice.pizzeria.repository.Account;

import java.util.Map;

public class Seller {
    public static void sell(Product product, String payment, int discount) {
        Map<String, Double> account = Account.getAccount();
        double cost = product.getCost();
        cost -= cost * discount * 0.01;
        double newValue = account.get(payment) + cost;
        newValue = Calc.round(newValue);
        cost = Calc.round(cost);

        account.put(payment, newValue);
        Counter.addPizzaCostToSellStory(cost);
    }
}
