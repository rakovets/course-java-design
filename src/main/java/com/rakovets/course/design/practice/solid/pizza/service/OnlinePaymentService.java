package com.rakovets.course.design.practice.solid.pizza.service;

import com.rakovets.course.design.practice.solid.pizza.model.Customer;
import com.rakovets.course.design.practice.solid.pizza.view.OnlinePaymentViewConsole;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OnlinePaymentService {
    public static final List<Customer> customer;
    private static final OnlinePaymentViewConsole onlinePaymentViewConsole;
    private static final Scanner scan;

    static {
        customer = new ArrayList<>();
        onlinePaymentViewConsole = new OnlinePaymentViewConsole();
        scan = new Scanner(System.in);
    }

    public void addCustomer() {
        onlinePaymentViewConsole.addCustomerView();
        customer.add(new Customer(scan.next(), scan.nextInt()));
        onlinePaymentViewConsole.displayPayment();
    }

    public String toString() {
        return customer.toString();
    }
}
