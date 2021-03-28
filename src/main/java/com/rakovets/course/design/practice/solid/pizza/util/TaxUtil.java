package com.rakovets.course.design.practice.solid.pizza.util;

public final class TaxUtil {

    private TaxUtil() {
    }

    public static double VAT(double priceWithoutVAT) { return priceWithoutVAT * 0.2; }

}
