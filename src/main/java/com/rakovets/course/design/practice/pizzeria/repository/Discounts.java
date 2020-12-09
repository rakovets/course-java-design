package com.rakovets.course.design.practice.pizzeria.repository;

import com.rakovets.course.design.practice.pizzeria.service.Loader;

import java.time.LocalDate;
import java.util.Map;

public class Discounts {
    private static Map<String, Integer> byDay;
    private static Map<Integer, Integer> byAmountOfPizzas;

    public static void start() {
        byDay = Loader.loadDiscountsByDay();
        byAmountOfPizzas = Loader.loadDiscountsByAmountOfPizzas();
    }

    public static Map<String, Integer> getByDay() {
        return byDay;
    }

    public static Map<Integer, Integer> getByAmountOfPizzas() {
        return byAmountOfPizzas;
    }

    public static int getMaxDiscount(int amountOfPizzas) {
        int max = 0;
        for(Map.Entry<Integer, Integer> entry : byAmountOfPizzas.entrySet()) {
            if (entry.getKey() >= amountOfPizzas) {
                int value = entry.getValue();
                if (max < value) max = value;
            }
        }
        for (Map.Entry<String, Integer> entry : byDay.entrySet()) {
            if (LocalDate.now().getDayOfWeek().toString().equals(entry.getKey().toUpperCase())) {
                int value = entry.getValue();
                if (max < value) max = value;
            }
        }
        return max;
    }
}
