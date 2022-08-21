package com.rakovets.course.design.practice.solid.model;

import com.rakovets.course.design.practice.solid.service.Name;

import java.util.Objects;

public abstract class PizzaShopItem implements Name {
    private final String name;

    protected PizzaShopItem(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PizzaShopItem that = (PizzaShopItem) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
