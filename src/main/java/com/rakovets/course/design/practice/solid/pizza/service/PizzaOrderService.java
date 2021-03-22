package com.rakovets.course.design.practice.solid.pizza.service;

import com.rakovets.course.design.practice.solid.pizza.exceptions.UserInputException;
import com.rakovets.course.design.practice.solid.pizza.model.Check;
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
import java.util.*;

public class PizzaOrderService {
    private static final Map<Integer, Pizza> pizzas;
    private static final CookService cook;
    private static final OrderRepository order;
    private static final PizzaOrderViewConsole pizzaOrderViewConsole;
    public char ch;
    private static final Path filePath;
    private final BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(filePath)));
    private static final PizzaPriceService pizzaPrice;
    private static final CashPaymentService cashPaymentService;
    private static final CashPaymentViewConsole cashPaymentServiceViewConsole;
    public static final Check check;
    private static final CheckViewConsole checkViewConsole;
    private static final OnlinePaymentService onlinePaymentService;
    private static final CardPaymentService cardPaymentService;

    static {
        pizzas = new HashMap<>();
        pizzas.put(1, Pizza.FOUR_CHEESE);
        pizzas.put(2, Pizza.MARGHERITA);
        pizzas.put(3, Pizza.MEAT_DELIGHT);
        pizzas.put(4, Pizza.PEPPERONI);
        pizzas.put(5, Pizza.VEGETARIAN);

        cook = new CookService();
        order = new OrderRepository(new ArrayList<>());
        pizzaOrderViewConsole = new PizzaOrderViewConsole();
        filePath = Paths.get("src", "main", "resources", "Orders.txt");
        pizzaPrice = new PizzaPriceService();
        cashPaymentService = new CashPaymentService();
        cashPaymentServiceViewConsole = new CashPaymentViewConsole();
        check = new Check(new ArrayList<>());
        checkViewConsole = new CheckViewConsole();
        onlinePaymentService = new OnlinePaymentService();
        cardPaymentService = new CardPaymentService();
    }

    public PizzaOrderService() throws IOException {
    }

    public void start() {
        pizzaOrderViewConsole.greeting();
    }

    public void choosePizza() throws IOException {
        try {
            pizzaOrderViewConsole.pizzaMenu();
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (pizzas.get(choice)) {
                case FOUR_CHEESE:
                    pizzaOrderViewConsole.orderPizzaFourCheese();
                    pizzaOrderViewConsole.displayCaloriesPizzaFourCheese();
                    cook.pizzaFourCheese();
                    check.add(pizzaOrderViewConsole.orderPizzaFourCheese());
                    order.add(pizzaPrice.pricePizzaFourCheeseIncludingVAT());
                    writer.append(DateFormatService.localDatePattern(LocalDateTime.now())).append("\t")
                            .append(String.valueOf(Pizza.FOUR_CHEESE)).append("\t")
                            .append(String.valueOf(RoundUpService.roundUp(pizzaPrice
                                    .pricePizzaFourCheeseIncludingVAT()))).append("$");
                    writer.append('\n');
                    break;
                case MARGHERITA:
                    pizzaOrderViewConsole.orderPizzaMargherita();
                    pizzaOrderViewConsole.displayCaloriesPizzaMargherita();
                    cook.pizzaMargherita();
                    check.add(pizzaOrderViewConsole.orderPizzaMargherita());
                    order.add(pizzaPrice.pricePizzaMargheritaIncludingVAT());
                    writer.append(DateFormatService.localDatePattern(LocalDateTime.now())).append("\t")
                            .append(String.valueOf(Pizza.MARGHERITA)).append("\t")
                            .append(String.valueOf(RoundUpService.roundUp(pizzaPrice
                                    .pricePizzaMargheritaIncludingVAT()))).append("$");
                    writer.append('\n');
                    break;
                case MEAT_DELIGHT:
                    pizzaOrderViewConsole.orderPizzaMeatDelight();
                    pizzaOrderViewConsole.displayCaloriesPizzaMeatDelight();
                    cook.pizzaMeatDelight();
                    check.add(pizzaOrderViewConsole.orderPizzaMeatDelight());
                    order.add(pizzaPrice.pricePizzaMeatDelightIncludingVAT());
                    writer.append(DateFormatService.localDatePattern(LocalDateTime.now())).append("\t")
                            .append(String.valueOf(Pizza.MEAT_DELIGHT)).append("\t")
                            .append(String.valueOf(RoundUpService.roundUp(pizzaPrice
                                    .pricePizzaMeatDelightIncludingVAT()))).append("$");
                    writer.append('\n');
                    break;
                case PEPPERONI:
                    pizzaOrderViewConsole.orderPizzaPepperoni();
                    pizzaOrderViewConsole.displayCaloriesPizzaPepperoni();
                    cook.pizzaPepperoni();
                    check.add(pizzaOrderViewConsole.orderPizzaPepperoni());
                    order.add(pizzaPrice.pricePizzaPepperoniIncludingVAT());
                    writer.append(DateFormatService.localDatePattern(LocalDateTime.now())).append("\t")
                            .append(String.valueOf(Pizza.PEPPERONI)).append("\t")
                            .append(String.valueOf(RoundUpService.roundUp(pizzaPrice
                                    .pricePizzaPepperoniIncludingVAT()))).append("$");
                    writer.append('\n');
                    break;
                case VEGETARIAN:
                    pizzaOrderViewConsole.orderPizzaVegetarian();
                    pizzaOrderViewConsole.displayCaloriesPizzaVegetarian();
                    cook.pizzaVegetarian();
                    check.add(pizzaOrderViewConsole.orderPizzaVegetarian());
                    order.add(pizzaPrice.pricePizzaVegetarianIncludingVAT());
                    writer.append(DateFormatService.localDatePattern(LocalDateTime.now())).append("\t")
                            .append(String.valueOf(Pizza.VEGETARIAN)).append("\t")
                            .append(String.valueOf(RoundUpService.roundUp(pizzaPrice
                                    .pricePizzaVegetarianIncludingVAT()))).append("$");
                    writer.append('\n');
                    break;
            }
            totalOrder();
            discountForTwoItems();
            discountForThreeAndMoreItems();
            discountForOrderOnSpecificDay();
            amountToPay(order.totalOrder());
            writer.flush();
        } catch (NullPointerException | InputMismatchException e) {
            try {
                throw new UserInputException();
            } catch (UserInputException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void totalOrder() {
        double totalOrder = order.totalOrder();
        int size = order.size();
        pizzaOrderViewConsole.totalOrder(totalOrder, size);
    }

    public void discountForTwoItems() {
        if (order.size() == 2) {
            double totalOrder = DiscountService.discountForTwoItems(order.totalOrder());
            pizzaOrderViewConsole.discountFor2Pizzas(totalOrder);
        }
    }

    public void discountForThreeAndMoreItems() {
        if (order.size() >= 3) {
            double totalOrder = DiscountService.discountForThreeAndMoreItems(order.totalOrder());
            pizzaOrderViewConsole.discountFor3AndMorePizzas(totalOrder);
        }
    }

    public void discountForOrderOnSpecificDay() {
        if (order.size() == 1 && LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            double totalOrder = DiscountService.discountForOrderOnSpecificDay(order.totalOrder());
            pizzaOrderViewConsole.discountForOrderOnSpecificDay(totalOrder);
            pizzaOrderViewConsole.amountToPay(DiscountService.discountForOrderOnSpecificDay(
                    order.totalOrder()));
        } else if (LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            double totalOrder = DiscountService.discountForOrderOnSpecificDay(order.totalOrder());
            pizzaOrderViewConsole.discountForOrderOnSpecificDay(totalOrder);
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
            pizzaOrderViewConsole.amountToPay(DiscountService.discountForTwoItems(order.totalOrder()));
        } else if (order.size() == 2 && LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            pizzaOrderViewConsole.amountToPay(DiscountService.amountToPayFor2PizzasOnSpecificDay(
                    order.totalOrder()));
        } else if (order.size() >= 3 && LocalDateTime.now().getDayOfWeek() != DayOfWeek.FRIDAY) {
            pizzaOrderViewConsole.amountToPay(DiscountService.discountForThreeAndMoreItems(
                    order.totalOrder()));
        } else if (order.size() >= 3 && LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            pizzaOrderViewConsole.amountToPay(DiscountService.amountToPayFor3AndMorePizzasOnSpecificDay(
                    order.totalOrder()));
        }
    }

    public void addPizzaQuestion() throws IOException {
        pizzaOrderViewConsole.addPizzaQuestion();
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
        try {
            pizzaOrderViewConsole.paymentChoice();
            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    checkViewConsole.displayCheckPizzaOrder();
                    createCheck();
                    cashPaymentService.getFullAmount();
                    cashPaymentServiceViewConsole.getChangePizzaOrder();
                    break;
                case 2:
                    checkViewConsole.displayCheckPizzaOrder();
                    createCheck();
                    cardPaymentService.enterPIN();
                    break;
                default:
                    checkViewConsole.displayCheckPizzaOrder();
                    createCheck();
                    onlinePaymentService.addCustomer();
                    break;
            }
        } catch (InputMismatchException e) {
            try {
                throw new UserInputException();
            } catch (UserInputException ex) {
                ex.printStackTrace();
                paymentChoice();
            }
        }
    }
}
