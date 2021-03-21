package com.rakovets.course.design.practice.solid.pizza.repository;

import java.util.List;

public class IngredientCaloriesRepository {
    private final List<Integer> totalCalories;

    public IngredientCaloriesRepository(List<Integer> totalCalories) {
        this.totalCalories = totalCalories;
    }

    public void add(int calories) {
        totalCalories.add(calories);
    }

    public int countTotalCalories() {
        return totalCalories.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
