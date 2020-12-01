package com.rakovets.course.design.example.solid.srp.after;

public class TaxCalculator {
    public TaxTable calculateTaxes(Account account, int year) {
        return new TaxTable();
    }
}
