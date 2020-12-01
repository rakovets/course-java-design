package com.rakovets.course.design.example.solid.srp;

import com.rakovets.course.design.example.solid.srp.before.Account;
import com.rakovets.course.design.example.solid.srp.before.TaxTable;

/**
 * Класс Account несет ответственность за:
 * <p>
 * - сохранение
 * - логику управление балансом
 * - логику расчета налогов
 * <p>
 * Все эти "задачи" и являются теми самыми мотивами, которые влияют на жизненный цикл класса.
 */
public class SrpExampleBefore {
    private static final Account account = new Account();

    public static void main(String[] args) {
        account.withdraw(100);
        account.transfer(10, new Account());
        account.save();
        TaxTable taxTable = account.calculateTaxes(2014);
        System.out.println(taxTable);
    }
}