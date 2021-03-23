package com.rakovets.course.design.practice.solid.pizza.service;

import com.rakovets.course.design.practice.solid.pizza.exceptions.CashAmountException;
import com.rakovets.course.design.practice.solid.pizza.view.CashPaymentViewConsole;

import java.util.InputMismatchException;
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
        try {
            cashPaymentServiceViewConsole.fullAmountView();
            Scanner scan = new Scanner(System.in);
            fullAmount = scan.nextDouble();
        } catch (InputMismatchException e) {
            try {
                throw new CashAmountException();
            } catch (CashAmountException ex) {
                ex.printStackTrace();
                getFullAmount();
            }
        }
    }
}
