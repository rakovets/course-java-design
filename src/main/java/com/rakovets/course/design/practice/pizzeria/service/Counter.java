package com.rakovets.course.design.practice.pizzeria.service;

import com.rakovets.course.design.practice.pizzeria.repository.SellStory;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.Map;

public class Counter {
    public static void addPizzaCostToSellStory(Double cost) {
        Map<LocalDateTime, Double> story = SellStory.getSellStoryOfPizzas();
        story.put(LocalDateTime.now(), cost);
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int getSoldPizzas(LocalDateTime from) {
        Map<LocalDateTime, Double> story = SellStory.getSellStoryOfPizzas();
        int pizzas = 0;
        for (Map.Entry<LocalDateTime, Double> entry : story.entrySet()) {
            if (entry.getKey().isAfter(from)) {
                pizzas++;
            }
        }
        return pizzas;
    }

    public static double getProceeds(LocalDateTime from) {
        Map<LocalDateTime, Double> story = SellStory.getSellStoryOfPizzas();
        double proceeds = 0;
        for (Map.Entry<LocalDateTime, Double> entry : story.entrySet()) {
            if (entry.getKey().isAfter(from)) {
                proceeds += entry.getValue();
            }
        }
        return Calc.round(proceeds);
    }

    public static double getIncome(LocalDateTime from) {
        double profitability = 0.2;
        return Calc.round(getProceeds(from) * profitability);

    }
}
