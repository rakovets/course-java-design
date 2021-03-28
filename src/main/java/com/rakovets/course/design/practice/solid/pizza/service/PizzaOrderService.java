package com.rakovets.course.design.practice.solid.pizza.service;

import com.rakovets.course.design.practice.solid.pizza.exceptions.PaymentChoiceException;
import com.rakovets.course.design.practice.solid.pizza.exceptions.PizzaNumberException;
import com.rakovets.course.design.practice.solid.pizza.model.Check;
import com.rakovets.course.design.practice.solid.pizza.model.PaymentMethod;
import com.rakovets.course.design.practice.solid.pizza.model.Pizza;
import com.rakovets.course.design.practice.solid.pizza.repository.OrderRepository;
import com.rakovets.course.design.practice.solid.pizza.util.CheckUtil;
import com.rakovets.course.design.practice.solid.pizza.util.DiscountUtil;
import com.rakovets.course.design.practice.solid.pizza.util.PizzaPriceUtil;
import com.rakovets.course.design.practice.solid.pizza.view.CashPaymentViewConsole;
import com.rakovets.course.design.practice.solid.pizza.view.CheckViewConsole;
import com.rakovets.course.design.practice.solid.pizza.view.PizzaOrderViewConsole;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PizzaOrderService {
    private static final Map<Integer, Pizza> PIZZAS;
    private static final PizzaOrderViewConsole PIZZA_ORDER_VIEW;
    private static final CookService COOK;
    private static final OrderRepository ORDER;
    private static final CashPaymentService CASH_PAYMENT;
    private static final CashPaymentViewConsole CASH_PAYMENT_VIEW;
    public static final Check CHECK;
    private static final CheckViewConsole CHECK_VIEW;
    private static final OnlinePaymentService ONLINE_PAYMENT;
    private static final CardPaymentService CARD_PAYMENT;
    private static final Map<Integer, PaymentMethod> PAYMENT_METHOD;
    public int payment;
    public char ch;
    public int choice;

    static {
        PIZZAS = new HashMap<>();
        PIZZAS.put(1, Pizza.FOUR_CHEESE);
        PIZZAS.put(2, Pizza.MARGHERITA);
        PIZZAS.put(3, Pizza.MEAT_DELIGHT);
        PIZZAS.put(4, Pizza.PEPPERONI);
        PIZZAS.put(5, Pizza.VEGETARIAN);

        PIZZA_ORDER_VIEW = new PizzaOrderViewConsole();
        COOK = new CookService();
        CASH_PAYMENT = new CashPaymentService();
        CASH_PAYMENT_VIEW = new CashPaymentViewConsole();
        CHECK = new Check(new ArrayList<>());
        CHECK_VIEW = new CheckViewConsole();
        ONLINE_PAYMENT = new OnlinePaymentService();
        CARD_PAYMENT = new CardPaymentService();
        ORDER = new OrderRepository(new ArrayList<>());

        PAYMENT_METHOD = new HashMap<>();
        PAYMENT_METHOD.put(1, PaymentMethod.CASH);
        PAYMENT_METHOD.put(2, PaymentMethod.CARD);
        PAYMENT_METHOD.put(3, PaymentMethod.ONLINE);
    }

    public PizzaOrderService() {
    }

    public void start() {
        PIZZA_ORDER_VIEW.greeting();
    }

    public void choosePizza() {
        PIZZA_ORDER_VIEW.pizzaMenu();
        choice = CheckUtil.checkInt();
        try {
            switch (PIZZAS.get(choice)) {
                case FOUR_CHEESE:
                    PIZZA_ORDER_VIEW.orderPizzaFourCheese();
                    PIZZA_ORDER_VIEW.displayInfoPizzaFourCheese();
                    COOK.pizzaFourCheese();
                    CHECK.add(PIZZA_ORDER_VIEW.orderPizzaFourCheese());
                    ORDER.add(PizzaPriceUtil.pricePizzaFourCheeseIncludingVAT());
                    break;
                case MARGHERITA:
                    PIZZA_ORDER_VIEW.orderPizzaMargherita();
                    PIZZA_ORDER_VIEW.displayInfoPizzaMargherita();
                    COOK.pizzaMargherita();
                    CHECK.add(PIZZA_ORDER_VIEW.orderPizzaMargherita());
                    ORDER.add(PizzaPriceUtil.pricePizzaMargheritaIncludingVAT());
                    break;
                case MEAT_DELIGHT:
                    PIZZA_ORDER_VIEW.orderPizzaMeatDelight();
                    PIZZA_ORDER_VIEW.displayInfoPizzaMeatDelight();
                    COOK.pizzaMeatDelight();
                    CHECK.add(PIZZA_ORDER_VIEW.orderPizzaMeatDelight());
                    ORDER.add(PizzaPriceUtil.pricePizzaMeatDelightIncludingVAT());
                    break;
                case PEPPERONI:
                    PIZZA_ORDER_VIEW.orderPizzaPepperoni();
                    PIZZA_ORDER_VIEW.displayInfoPizzaPepperoni();
                    COOK.pizzaPepperoni();
                    CHECK.add(PIZZA_ORDER_VIEW.orderPizzaPepperoni());
                    ORDER.add(PizzaPriceUtil.pricePizzaPepperoniIncludingVAT());
                    break;
                case VEGETARIAN:
                    PIZZA_ORDER_VIEW.orderPizzaVegetarian();
                    PIZZA_ORDER_VIEW.displayInfoPizzaVegetarian();
                    COOK.pizzaVegetarian();
                    CHECK.add(PIZZA_ORDER_VIEW.orderPizzaVegetarian());
                    ORDER.add(PizzaPriceUtil.pricePizzaVegetarianIncludingVAT());
                    break;
            }
        } catch (NullPointerException e) {
            try {
                throw new PizzaNumberException();
            } catch (PizzaNumberException ex) {
                PIZZA_ORDER_VIEW.pizzaNumberException();
            }
        }
        totalOrder();
        discountForTwoItems();
        discountForThreeAndMoreItems();
        discountForOrderOnSpecificDay();
        amountToPay(ORDER.totalOrder());
    }

    public void totalOrder() {
        double totalOrder = ORDER.totalOrder();
        int size = ORDER.size();
        PIZZA_ORDER_VIEW.totalOrder(totalOrder, size);
    }

    public void discountForTwoItems() {
        if (ORDER.size() == 2) {
            double totalOrder = DiscountUtil.discountForTwoItems(ORDER.totalOrder());
            PIZZA_ORDER_VIEW.discountFor2Pizzas(totalOrder);
        }
    }

    public void discountForThreeAndMoreItems() {
        if (ORDER.size() >= 3) {
            double totalOrder = DiscountUtil.discountForThreeAndMoreItems(ORDER.totalOrder());
            PIZZA_ORDER_VIEW.discountFor3AndMorePizzas(totalOrder);
        }
    }

    public void discountForOrderOnSpecificDay() {
        if (ORDER.size() == 1 && LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            double totalOrder = DiscountUtil.discountForOrderOnSpecificDay(ORDER.totalOrder());
            PIZZA_ORDER_VIEW.discountForOrderOnSpecificDay(totalOrder);
            PIZZA_ORDER_VIEW.amountToPay(DiscountUtil.discountForOrderOnSpecificDay(
                    ORDER.totalOrder()));
        } else if (LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            double totalOrder = DiscountUtil.discountForOrderOnSpecificDay(ORDER.totalOrder());
            PIZZA_ORDER_VIEW.discountForOrderOnSpecificDay(totalOrder);
        }
    }

    public double amountToPay(double amountToPay) {
        if (ORDER.size() == 2 && LocalDateTime.now().getDayOfWeek() != DayOfWeek.FRIDAY) {
            amountToPay = DiscountUtil.discountForTwoItems(ORDER.totalOrder());
        } else if (ORDER.size() == 2 && LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            amountToPay = DiscountUtil.amountToPayFor2PizzasOnSpecificDay(
                    ORDER.totalOrder());
        } else if (ORDER.size() >= 3 && LocalDateTime.now().getDayOfWeek() != DayOfWeek.FRIDAY) {
            amountToPay = DiscountUtil.discountForThreeAndMoreItems(
                    ORDER.totalOrder());
        } else if (ORDER.size() >= 3 && LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            amountToPay = DiscountUtil.amountToPayFor3AndMorePizzasOnSpecificDay(
                    ORDER.totalOrder());
        }
        return amountToPay;
    }

    public void createCheck() {
        if (ORDER.size() == 2 && LocalDateTime.now().getDayOfWeek() != DayOfWeek.FRIDAY) {
            PIZZA_ORDER_VIEW.amountToPay(DiscountUtil.discountForTwoItems(ORDER.totalOrder()));
        } else if (ORDER.size() == 2 && LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            PIZZA_ORDER_VIEW.amountToPay(DiscountUtil.amountToPayFor2PizzasOnSpecificDay(
                    ORDER.totalOrder()));
        } else if (ORDER.size() >= 3 && LocalDateTime.now().getDayOfWeek() != DayOfWeek.FRIDAY) {
            PIZZA_ORDER_VIEW.amountToPay(DiscountUtil.discountForThreeAndMoreItems(
                    ORDER.totalOrder()));
        } else if (ORDER.size() >= 3 && LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            PIZZA_ORDER_VIEW.amountToPay(DiscountUtil.amountToPayFor3AndMorePizzasOnSpecificDay(
                    ORDER.totalOrder()));
        }
    }

    public void addPizzaQuestion() throws IOException {
        PIZZA_ORDER_VIEW.addPizzaQuestion();
        Scanner scan = new Scanner(System.in);
        ch = scan.next().charAt(0);
        if (ch == 'Y' || ch == 'y') {
            choosePizza();
            addPizzaQuestion();
        } else {
            paymentChoice();
        }
    }

    public double getChange() {
        return CASH_PAYMENT.countChange(amountToPay(ORDER.totalOrder()));
    }

    public void paymentChoice() throws IOException {
        CHECK.checkInFile();
        PIZZA_ORDER_VIEW.paymentChoice();
        try {
            payment = CheckUtil.checkInt();
            switch (PAYMENT_METHOD.get(payment)) {
                case CASH:
                    CHECK_VIEW.displayCheckPizzaOrder();
                    createCheck();
                    CASH_PAYMENT.getFullAmount();
                    CASH_PAYMENT_VIEW.getChangePizzaOrder();
                    break;
                case CARD:
                    CHECK_VIEW.displayCheckPizzaOrder();
                    createCheck();
                    CARD_PAYMENT.enterPIN();
                    break;
                case ONLINE:
                    CHECK_VIEW.displayCheckPizzaOrder();
                    createCheck();
                    ONLINE_PAYMENT.addCustomer();
                    break;
            }
        } catch (NullPointerException e) {
            try {
                throw new PaymentChoiceException();
            } catch (PaymentChoiceException ex) {
                PIZZA_ORDER_VIEW.paymentChoiceException();
                paymentChoice();
            }
        }
    }
}
