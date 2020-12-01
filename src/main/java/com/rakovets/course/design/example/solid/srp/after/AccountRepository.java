package com.rakovets.course.design.example.solid.srp.after;

public class AccountRepository {
    public Account getById(long id) {
        return new Account();
    }

    public Account getByIban(String iban) {
        return new Account();
    }

    public void save(Account account) {
        System.out.println("Счет сохранен в базу данных");
    }
}
