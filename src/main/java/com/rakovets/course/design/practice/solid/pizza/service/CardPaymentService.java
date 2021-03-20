package com.rakovets.course.design.practice.solid.pizza.service;

import com.rakovets.course.design.practice.solid.pizza.view.CardPaymentViewConsole;

import java.util.Scanner;

public class CardPaymentService {
    public int PIN;
    private static final Scanner scan;
    private static final CardPaymentViewConsole cardPaymentViewConsole;

    static {
        scan = new Scanner(System.in);
        cardPaymentViewConsole = new CardPaymentViewConsole();
    }

    public void enterPIN() {
        cardPaymentViewConsole.enterPIN();
        int count = 0;
        PIN = scan.nextInt();
        while (PIN != 0) {
            PIN = PIN / 10;
            count++;
        }
        if (count != 4) {
            cardPaymentViewConsole.invalidInput();
            enterPIN();
        } else
            cardPaymentViewConsole.approvePayment();
    }
}
