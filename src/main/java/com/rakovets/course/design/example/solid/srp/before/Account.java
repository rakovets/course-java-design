package com.rakovets.course.design.example.solid.srp.before;

public class Account {
    private long id;
    private long balance;
    private String iban;

    public long getId() {
        return id;
    }

    public String getIban() {
        return iban;
    }

    public long getCurrentBalance() {
        return balance;
    }

    public void save() {
        System.out.println("Счет сохранен в базу данных");
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public void transfer(int amount, Account recipient) {
    }

    public TaxTable calculateTaxes(int year) {
        return new TaxTable();
    }
}
