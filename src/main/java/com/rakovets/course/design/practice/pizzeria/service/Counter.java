package com.rakovets.course.design.practice.pizzeria.service;

import com.rakovets.course.design.practice.pizzeria.repository.SellStory;

import java.time.LocalDateTime;
import java.util.Map;

public class Counter {
    public static void addPizzaCostToSellStory(Double cost) {
        Map<LocalDateTime, Double> story = SellStory.getSellStoryOfPizzas();
        story.put(LocalDateTime.now(), cost);
    }
}
