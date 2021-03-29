package com.rakovets.course.design.practice.solid.pizza.util;

public final class TaxUtil {

    private TaxUtil() {
    }

    public static double VAT(double priceWithoutVAT) { return priceWithoutVAT * 0.2; }

    public static double VATonRevenue(double revenue) { return revenue * 20 / 120; }

    public static double CorporateIncomeTax(double profit) { return profit * 0.82; }

}
