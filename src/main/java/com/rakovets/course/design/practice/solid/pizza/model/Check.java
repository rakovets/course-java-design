package com.rakovets.course.design.practice.solid.pizza.model;

import java.util.List;

public class Check {
    private final List<String> check;

    public Check(List<String> check) {
        this.check = check;
    }

    public void add(String item) {
        check.add(item);
    }

    public List<String> getItemsInCheck() {
        return check;
    }
}
