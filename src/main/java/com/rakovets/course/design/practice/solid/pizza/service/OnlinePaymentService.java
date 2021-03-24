package com.rakovets.course.design.practice.solid.pizza.service;

import com.rakovets.course.design.practice.solid.pizza.exceptions.CardException;
import com.rakovets.course.design.practice.solid.pizza.model.Customer;
import com.rakovets.course.design.practice.solid.pizza.view.OnlinePaymentViewConsole;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OnlinePaymentService {
    private static final OnlinePaymentViewConsole onlinePaymentView;

    static {
        onlinePaymentView = new OnlinePaymentViewConsole();
    }

    public void addCustomer() {
        Scanner scan = new Scanner(System.in);
        onlinePaymentView.firstName();
        Customer.firstName = scan.next();
        onlinePaymentView.lastName();
        Customer.lastName = scan.next();
        onlinePaymentView.cardNumber();
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
                onlinePaymentView.invalidInput();
                onlinePaymentView.cardNumber();
                enterCardNumber();
            } else {
                onlinePaymentView.displayPayment();
            }
        } catch (InputMismatchException e) {
            try {
                throw new CardException();
            } catch (CardException ex) {
                onlinePaymentView.cardException();
                onlinePaymentView.cardNumber();
                enterCardNumber();
            }
        }
    }
}
