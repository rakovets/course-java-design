package com.rakovets.course.design.example.pattern.strategy.example.strategies;

/**
 * Общий интерфейс всех стратегий.
 */
public interface PayStrategy {
    boolean pay(int paymentAmount);

    void collectPaymentDetails();
}

