package com.rakovets.course.design.practice.pizzeria.repository;

import java.util.Map;

public class Account {
    private static Map<String, Double> account;

    public static Map<String, Double> getAccount() {
        return account;
    }

    public static void setAccount(Map<String, Double> account) {
        Account.account = account;
    }
}
