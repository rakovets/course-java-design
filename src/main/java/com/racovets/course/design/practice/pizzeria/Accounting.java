package com.racovets.course.design.practice.pizzeria;

import java.util.ArrayList;
import java.util.List;

public class Accounting {
    private List<Integer> cost = new ArrayList<>();
    private int numberOfSoldPizza;
    private int profit;
    private int proceeds;

    public int getNumberOfSoldPizza() {
        return numberOfSoldPizza;
    }

    public void setNumberOfSoldPizza(int numberOfSoldPizza) {
        this.numberOfSoldPizza = numberOfSoldPizza;
    }

    public long getTotalCost(List<Integer> cost) {
        return cost.stream().reduce(Integer::sum).get();
    }

    public List<Integer> getCost() {
        return cost;
    }

    public void setCost(List<Integer> cost) {
        this.cost = cost;
    }

    public int getProceeds() {
        return proceeds;
    }

    public void setProceeds(int proceeds) {
        this.proceeds = proceeds;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }
}
