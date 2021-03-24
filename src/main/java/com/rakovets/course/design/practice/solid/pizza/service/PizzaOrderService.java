package com.rakovets.course.design.practice.solid.pizza.service;

import com.rakovets.course.design.practice.solid.pizza.exceptions.PaymentChoiceException;
import com.rakovets.course.design.practice.solid.pizza.exceptions.PizzaNumberException;
import com.rakovets.course.design.practice.solid.pizza.model.Check;
import com.rakovets.course.design.practice.solid.pizza.model.PaymentMethod;
import com.rakovets.course.design.practice.solid.pizza.model.Pizza;
import com.rakovets.course.design.practice.solid.pizza.repository.OrderRepository;
import com.rakovets.course.design.practice.solid.pizza.view.CashPaymentViewConsole;
import com.rakovets.course.design.practice.solid.pizza.view.CheckViewConsole;
import com.rakovets.course.design.practice.solid.pizza.view.PizzaOrderViewConsole;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PizzaOrderService {
    private static final Map<Integer, Pizza> pizzas;
    private static final CookService cook;
    private static final OrderRepository order;
    private static final PizzaOrderViewConsole pizzaOrderView;
    public char ch;
    private static final Path filePath;
    private final BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(filePath)));
    private static final PizzaPriceService pizzaPrice;
    private static final CashPaymentService cashPaymentService;
    private static final CashPaymentViewConsole cashPaymentServiceView;
    public static final Check check;
    private static final CheckViewConsole checkView;
    private static final OnlinePaymentService onlinePaymentService;
    private static final CardPaymentService cardPaymentService;
    private static final Map<Integer, PaymentMethod> paymentMethod;
    private static final Scanner scanner;
    public int enteredInt;
    public int pizzaMenu;
    public int payment;

    static {
        pizzas = new HashMap<>();
        pizzas.put(1, Pizza.FOUR_CHEESE);
        pizzas.put(2, Pizza.MARGHERITA);
        pizzas.put(3, Pizza.MEAT_DELIGHT);
        pizzas.put(4, Pizza.PEPPERONI);
        pizzas.put(5, Pizza.VEGETARIAN);

        cook = new CookService();
        order = new OrderRepository(new ArrayList<>());
        pizzaOrderView = new PizzaOrderViewConsole();
        filePath = Paths.get("src", "main", "resources", "Orders.txt");
        pizzaPrice = new PizzaPriceService();
        cashPaymentService = new CashPaymentService();
        cashPaymentServiceView = new CashPaymentViewConsole();
        check = new Check(new ArrayList<>());
        checkView = new CheckViewConsole();
        onlinePaymentService = new OnlinePaymentService();
        cardPaymentService = new CardPaymentService();
        scanner = new Scanner(System.in);

        paymentMethod = new HashMap<>();
        paymentMethod.put(1, PaymentMethod.CASH);
        paymentMethod.put(2, PaymentMethod.CARD);
        paymentMethod.put(3, PaymentMethod.ONLINE);
    }

    public PizzaOrderService() throws IOException {
    }

    public void start() {
        pizzaOrderView.greeting();
    }

    public void choosePizza() throws IOException {
        pizzaOrderView.pizzaMenu();
        pizzaMenu = checkInt();
        try {
            switch (pizzas.get(pizzaMenu)) {
                case FOUR_CHEESE:
                    pizzaOrderView.orderPizzaFourCheese();
                    pizzaOrderView.displayCaloriesPizzaFourCheese();
                    cook.pizzaFourCheese();
                    check.add(pizzaOrderView.orderPizzaFourCheese());
                    order.add(pizzaPrice.pricePizzaFourCheeseIncludingVAT());
                    writer.append(DateFormatService.localDatePattern(LocalDateTime.now())).append("\t")
                            .append(String.valueOf(Pizza.FOUR_CHEESE)).append("\t")
                            .append(String.valueOf(RoundUpService.roundUp(pizzaPrice
                                    .pricePizzaFourCheeseIncludingVAT()))).append("$");
                    writer.append('\n');
                    break;
                case MARGHERITA:
                    pizzaOrderView.orderPizzaMargherita();
                    pizzaOrderView.displayCaloriesPizzaMargherita();
                    cook.pizzaMargherita();
                    check.add(pizzaOrderView.orderPizzaMargherita());
                    order.add(pizzaPrice.pricePizzaMargheritaIncludingVAT());
                    writer.append(DateFormatService.localDatePattern(LocalDateTime.now())).append("\t")
                            .append(String.valueOf(Pizza.MARGHERITA)).append("\t")
                            .append(String.valueOf(RoundUpService.roundUp(pizzaPrice
                                    .pricePizzaMargheritaIncludingVAT()))).append("$");
                    writer.append('\n');
                    break;
                case MEAT_DELIGHT:
                    pizzaOrderView.orderPizzaMeatDelight();
                    pizzaOrderView.displayCaloriesPizzaMeatDelight();
                    cook.pizzaMeatDelight();
                    check.add(pizzaOrderView.orderPizzaMeatDelight());
                    order.add(pizzaPrice.pricePizzaMeatDelightIncludingVAT());
                    writer.append(DateFormatService.localDatePattern(LocalDateTime.now())).append("\t")
                            .append(String.valueOf(Pizza.MEAT_DELIGHT)).append("\t")
                            .append(String.valueOf(RoundUpService.roundUp(pizzaPrice
                                    .pricePizzaMeatDelightIncludingVAT()))).append("$");
                    writer.append('\n');
                    break;
                case PEPPERONI:
                    pizzaOrderView.orderPizzaPepperoni();
                    pizzaOrderView.displayCaloriesPizzaPepperoni();
                    cook.pizzaPepperoni();
                    check.add(pizzaOrderView.orderPizzaPepperoni());
                    order.add(pizzaPrice.pricePizzaPepperoniIncludingVAT());
                    writer.append(DateFormatService.localDatePattern(LocalDateTime.now())).append("\t")
                            .append(String.valueOf(Pizza.PEPPERONI)).append("\t")
                            .append(String.valueOf(RoundUpService.roundUp(pizzaPrice
                                    .pricePizzaPepperoniIncludingVAT()))).append("$");
                    writer.append('\n');
                    break;
                case VEGETARIAN:
                    pizzaOrderView.orderPizzaVegetarian();
                    pizzaOrderView.displayCaloriesPizzaVegetarian();
                    cook.pizzaVegetarian();
                    check.add(pizzaOrderView.orderPizzaVegetarian());
                    order.add(pizzaPrice.pricePizzaVegetarianIncludingVAT());
                    writer.append(DateFormatService.localDatePattern(LocalDateTime.now())).append("\t")
                            .append(String.valueOf(Pizza.VEGETARIAN)).append("\t")
                            .append(String.valueOf(RoundUpService.roundUp(pizzaPrice
                                    .pricePizzaVegetarianIncludingVAT()))).append("$");
                    writer.append('\n');
                    break;
            }
        } catch (NullPointerException e) {
            try {
                throw new PizzaNumberException();
            } catch (PizzaNumberException ex) {
                pizzaOrderView.pizzaNumberException();
            }
        }
        totalOrder();
        discountForTwoItems();
        discountForThreeAndMoreItems();
        discountForOrderOnSpecificDay();
        amountToPay(order.totalOrder());
        writer.flush();
    }

    public void totalOrder() {
        double totalOrder = order.totalOrder();
        int size = order.size();
        pizzaOrderView.totalOrder(totalOrder, size);
    }

    public void discountForTwoItems() {
        if (order.size() == 2) {
            double totalOrder = DiscountService.discountForTwoItems(order.totalOrder());
            pizzaOrderView.discountFor2Pizzas(totalOrder);
        }
    }

    public void discountForThreeAndMoreItems() {
        if (order.size() >= 3) {
            double totalOrder = DiscountService.discountForThreeAndMoreItems(order.totalOrder());
            pizzaOrderView.discountFor3AndMorePizzas(totalOrder);
        }
    }

    public void discountForOrderOnSpecificDay() {
        if (order.size() == 1 && LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            double totalOrder = DiscountService.discountForOrderOnSpecificDay(order.totalOrder());
            pizzaOrderView.discountForOrderOnSpecificDay(totalOrder);
            pizzaOrderView.amountToPay(DiscountService.discountForOrderOnSpecificDay(
                    order.totalOrder()));
        } else if (LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            double totalOrder = DiscountService.discountForOrderOnSpecificDay(order.totalOrder());
            pizzaOrderView.discountForOrderOnSpecificDay(totalOrder);
        }
    }

    public double amountToPay(double amountToPay) {
        if (order.size() == 2 && LocalDateTime.now().getDayOfWeek() != DayOfWeek.FRIDAY) {
            amountToPay = DiscountService.discountForTwoItems(order.totalOrder());
        } else if (order.size() == 2 && LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            amountToPay = DiscountService.amountToPayFor2PizzasOnSpecificDay(
                    order.totalOrder());
        } else if (order.size() >= 3 && LocalDateTime.now().getDayOfWeek() != DayOfWeek.FRIDAY) {
            amountToPay = DiscountService.discountForThreeAndMoreItems(
                    order.totalOrder());
        } else if (order.size() >= 3 && LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            amountToPay = DiscountService.amountToPayFor3AndMorePizzasOnSpecificDay(
                    order.totalOrder());
        }
        return amountToPay;
    }

    public void createCheck() {
        if (order.size() == 2 && LocalDateTime.now().getDayOfWeek() != DayOfWeek.FRIDAY) {
            pizzaOrderView.amountToPay(DiscountService.discountForTwoItems(order.totalOrder()));
        } else if (order.size() == 2 && LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            pizzaOrderView.amountToPay(DiscountService.amountToPayFor2PizzasOnSpecificDay(
                    order.totalOrder()));
        } else if (order.size() >= 3 && LocalDateTime.now().getDayOfWeek() != DayOfWeek.FRIDAY) {
            pizzaOrderView.amountToPay(DiscountService.discountForThreeAndMoreItems(
                    order.totalOrder()));
        } else if (order.size() >= 3 && LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            pizzaOrderView.amountToPay(DiscountService.amountToPayFor3AndMorePizzasOnSpecificDay(
                    order.totalOrder()));
        }
    }

    public void addPizzaQuestion() throws IOException {
        pizzaOrderView.addPizzaQuestion();
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
        return cashPaymentService.countChange(amountToPay(order.totalOrder()));
    }

    public void paymentChoice() {
        pizzaOrderView.paymentChoice();
        try {
            payment = checkInt();
            switch (paymentMethod.get(payment)) {
                case CASH:
                    checkView.displayCheckPizzaOrder();
                    createCheck();
                    cashPaymentService.getFullAmount();
                    cashPaymentServiceView.getChangePizzaOrder();
                    break;
                case CARD:
                    checkView.displayCheckPizzaOrder();
                    createCheck();
                    cardPaymentService.enterPIN();
                    break;
                case ONLINE:
                    checkView.displayCheckPizzaOrder();
                    createCheck();
                    onlinePaymentService.addCustomer();
                    break;
            }
        } catch (NullPointerException e) {
            try {
                throw new PaymentChoiceException();
            } catch (PaymentChoiceException ex) {
                pizzaOrderView.paymentChoiceException();
                paymentChoice();
            }
        }
    }

    public int checkInt() {
        do {
            while (!scanner.hasNextInt()) {
                pizzaOrderView.invalidInput();
                scanner.next();
            }
            enteredInt = scanner.nextInt();
        } while (enteredInt <= 0);
        return enteredInt;
    }
}
