package com.rakovets.course.design.practice.solid.pizza.service;

import com.rakovets.course.design.practice.solid.pizza.model.Customer;
import com.rakovets.course.design.practice.solid.pizza.view.OnlinePaymentViewConsole;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OnlinePaymentService {
    public static final List<Customer> customer;
    private static final OnlinePaymentViewConsole onlinePaymentViewConsole;

    static {
        customer = new ArrayList<>();
        onlinePaymentViewConsole = new OnlinePaymentViewConsole();
    }

    public void addCustomer() {
        Scanner scan = new Scanner(System.in);
        onlinePaymentViewConsole.addCustomerView();
        customer.add(new Customer(scan.next(), scan.nextInt()));
    }

    public String toString() {
        return customer.toString();
    }
}
