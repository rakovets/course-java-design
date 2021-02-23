package com.rakovets.course.design.practice.solid.Pizza.Order;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
        return BigDecimal.valueOf(order.stream()
                .mapToDouble(Double::doubleValue)
                .sum()).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public int size() {
        return order.size();
    }
}

