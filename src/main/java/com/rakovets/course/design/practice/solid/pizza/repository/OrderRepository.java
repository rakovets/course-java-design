package com.rakovets.course.design.practice.solid.pizza.repository;

import java.util.List;

public class OrderRepository {
    private final List<Double> order;

    public OrderRepository(List<Double> order) {
        this.order = order;
    }

    public void add(double price) {
        order.add(price);
    }

    public double totalOrder() {
        return order.stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    public int size() {
        return order.size();
    }
}

