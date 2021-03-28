package com.rakovets.course.design.practice.solid.pizza.util;

public final class DiscountUtil {

    private DiscountUtil() {
    }

    public static double discountForTwoItems(double totalOrder) { return totalOrder * 0.9; }

    public static double discountForThreeAndMoreItems(double totalOrder) { return totalOrder * 0.8; }

    public static double discountForOrderOnSpecificDay(double totalOrder) { return totalOrder * 0.85; }

    public static double amountToPayFor2PizzasOnSpecificDay(double totalOrder) {
        return totalOrder - (totalOrder - discountForTwoItems(totalOrder)) - (totalOrder -
                discountForOrderOnSpecificDay(totalOrder));
    }

    public static double amountToPayFor3AndMorePizzasOnSpecificDay(double totalOrder) {
        return totalOrder - (totalOrder - discountForThreeAndMoreItems(totalOrder)) - (totalOrder -
                discountForOrderOnSpecificDay(totalOrder));
    }
}