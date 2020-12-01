package com.rakovets.course.design.example.solid.srp;


import com.rakovets.course.design.example.solid.srp.after.Account;
import com.rakovets.course.design.example.solid.srp.after.AccountRepository;
import com.rakovets.course.design.example.solid.srp.after.TaxCalculator;
import com.rakovets.course.design.example.solid.srp.after.TaxTable;

/**
 * S - Разделение обязаностей
 */
public class SrpExampleAfter {
    private static final AccountRepository repository = new AccountRepository();
    private static final TaxCalculator taxCalculator = new TaxCalculator();

    public static void main(String[] args) {
        Account account = repository.getById(125);
        account.withdraw(100);
        repository.save(account);
        TaxTable taxTable = taxCalculator.calculateTaxes(account, 2020);
        System.out.println(taxTable);
    }
}