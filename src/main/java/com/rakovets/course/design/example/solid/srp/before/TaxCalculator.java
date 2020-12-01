package com.rakovets.course.design.example.solid.srp.before;

import com.rakovets.course.design.example.solid.srp.after.Account;

public class TaxCalculator {
    public TaxTable calculateTaxes(Account account, int year) {
        return new TaxTable();
    }
}
