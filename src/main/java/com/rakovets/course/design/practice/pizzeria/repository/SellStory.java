package com.rakovets.course.design.practice.pizzeria.repository;

import java.time.LocalDateTime;
import java.util.Map;

public class SellStory {
    private static Map<LocalDateTime, Double> sellStoryOfPizzas;

    public static Map<LocalDateTime, Double> getSellStoryOfPizzas() {
        return sellStoryOfPizzas;
    }

    public static void setSellStoryOfPizzas(Map<LocalDateTime, Double> sellStoryOfPizzas) {
        SellStory.sellStoryOfPizzas = sellStoryOfPizzas;
    }
}
