package com.rakovets.course.design.practice.solid.pizza.service;

import com.rakovets.course.design.practice.solid.pizza.exceptions.PinException;
import com.rakovets.course.design.practice.solid.pizza.view.CardPaymentViewConsole;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CardPaymentService {
    public int PIN;
    private static final CardPaymentViewConsole cardPaymentView;

    static {
        cardPaymentView = new CardPaymentViewConsole();
    }

    public void enterPIN() {
        try {
            cardPaymentView.enterPIN();
            Scanner scan = new Scanner(System.in);
            int count = 0;
            PIN = scan.nextInt();
            while (PIN != 0) {
                PIN = PIN / 10;
                count++;
            }
            if (count != 4) {
                cardPaymentView.invalidInput();
                enterPIN();
            } else {
                cardPaymentView.approvePayment();
            }
        } catch (InputMismatchException e) {
            try {
                throw new PinException();
            } catch (PinException ex) {
                cardPaymentView.pinException();
                enterPIN();
            }
        }
    }
}
