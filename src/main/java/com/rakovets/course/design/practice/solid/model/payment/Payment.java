package com.rakovets.course.design.practice.solid.model.payment;

import com.rakovets.course.design.practice.solid.service.Name;
import lombok.Getter;

import java.util.Objects;

public abstract class Payment implements Name {
    private final String name;
    @Getter
    private final double amount;

    protected Payment(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Payment payment = (Payment) o;
        return Double.compare(payment.amount, amount) == 0 && name.equals(payment.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amount);
    }
}
