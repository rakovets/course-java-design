package com.rakovets.course.design.practice.solid.pizza.service;

import com.rakovets.course.design.practice.solid.pizza.exceptions.CardException;
import com.rakovets.course.design.practice.solid.pizza.model.Customer;
import com.rakovets.course.design.practice.solid.pizza.view.OnlinePaymentViewConsole;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OnlinePaymentService {
    private static final OnlinePaymentViewConsole onlinePaymentViewConsole;

    static {
        onlinePaymentViewConsole = new OnlinePaymentViewConsole();
    }

    public void addCustomer() {
        Scanner scan = new Scanner(System.in);
        onlinePaymentViewConsole.firstName();
        Customer.firstName = scan.next();
        onlinePaymentViewConsole.lastName();
        Customer.lastName = scan.next();
        onlinePaymentViewConsole.cardNumber();
        enterCardNumber();
    }

    public void enterCardNumber() {
        try {
            int count = 0;
            Scanner scan = new Scanner(System.in);
            Customer.cardNumber = scan.nextLong();
            while (Customer.cardNumber != 0) {
                Customer.cardNumber = Customer.cardNumber / 10;
                count++;
            }
            if (count != 16) {
                onlinePaymentViewConsole.invalidInput();
                onlinePaymentViewConsole.cardNumber();
                enterCardNumber();
            } else {
                onlinePaymentViewConsole.displayPayment();
            }
        } catch (InputMismatchException e) {
            try {
                throw new CardException();
            } catch (CardException ex) {
                ex.printStackTrace();
                onlinePaymentViewConsole.cardNumber();
                enterCardNumber();
            }
        }
    }
}
