package com.rakovets.course.design.practice.solid.pizza.service;

import com.rakovets.course.design.practice.solid.pizza.model.Check;
import com.rakovets.course.design.practice.solid.pizza.model.PaymentMethod;
import com.rakovets.course.design.practice.solid.pizza.repository.OrderRepository;
import com.rakovets.course.design.practice.solid.pizza.util.CheckInt;
import com.rakovets.course.design.practice.solid.pizza.view.CashPaymentViewConsole;
import com.rakovets.course.design.practice.solid.pizza.view.CheckViewConsole;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserOrder {
    public static final CookService COOK;
    public static final OrderRepository ORDER;
    public static final CashPaymentService CASH_PAYMENT_SERVICE;
    public static final CashPaymentViewConsole CASH_PAYMENT_VIEW_CONSOLE;
    public static final Check CHECK;
    public static final CheckViewConsole CHECK_VIEW;
    public static final OnlinePaymentService ONLINE_PAYMENT_SERVICE;
    public static final CardPaymentService CARD_PAYMENT_SERVICE;
    public static final Map<Integer, PaymentMethod> PAYMENT_METHOD;
    public static final Scanner SCANNER;
    public int payment;
    public char ch;
    public int choice;
    public static final CheckInt CHECK_INT;

    static {
        COOK = new CookService();
        CASH_PAYMENT_SERVICE = new CashPaymentService();
        CASH_PAYMENT_VIEW_CONSOLE = new CashPaymentViewConsole();
        CHECK = new Check(new ArrayList<>());
        CHECK_VIEW = new CheckViewConsole();
        ONLINE_PAYMENT_SERVICE = new OnlinePaymentService();
        CARD_PAYMENT_SERVICE = new CardPaymentService();
        SCANNER = new Scanner(System.in);
        ORDER = new OrderRepository(new ArrayList<>());
        CHECK_INT = new CheckInt();

        PAYMENT_METHOD = new HashMap<>();
        PAYMENT_METHOD.put(1, PaymentMethod.CASH);
        PAYMENT_METHOD.put(2, PaymentMethod.CARD);
        PAYMENT_METHOD.put(3, PaymentMethod.ONLINE);
    }
}
