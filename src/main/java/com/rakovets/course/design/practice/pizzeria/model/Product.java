package com.rakovets.course.design.practice.pizzeria.model;

import com.rakovets.course.design.practice.pizzeria.service.Loader;

public class Product {
    protected String name;
    protected double cost;

    public Product(String name) {
        this.name = name;
        cost = Loader.loadCost(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
