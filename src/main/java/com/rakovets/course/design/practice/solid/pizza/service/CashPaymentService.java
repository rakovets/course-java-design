package com.rakovets.course.design.practice.solid.pizza.service;

import com.rakovets.course.design.practice.solid.pizza.view.CashPaymentViewConsole;

import java.util.Scanner;

public class CashPaymentService {
    public static double fullAmount;
    private static final CashPaymentViewConsole cashPaymentServiceViewConsole;

    static {
        cashPaymentServiceViewConsole = new CashPaymentViewConsole();
    }

    public double countChange(double amountToPay) {
        if (fullAmount < amountToPay) {
            cashPaymentServiceViewConsole.notEnoughMoney();
        }
        return RoundUpService.roundUp(fullAmount - amountToPay);
    }

    public void getFullAmount() {
        cashPaymentServiceViewConsole.fullAmountView();
        Scanner scan = new Scanner(System.in);
        fullAmount = scan.nextDouble();
    }
}
