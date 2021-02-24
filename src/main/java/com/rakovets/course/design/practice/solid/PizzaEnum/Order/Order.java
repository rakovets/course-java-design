package com.rakovets.course.design.practice.solid.PizzaEnum.Order;

import java.util.List;

public class Order {
    private final List<Double> order;

    public Order(List<Double> order) {
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

