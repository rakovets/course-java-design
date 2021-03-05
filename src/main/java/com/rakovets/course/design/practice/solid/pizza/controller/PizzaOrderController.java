package com.rakovets.course.design.practice.solid.pizza.controller;

import com.rakovets.course.design.practice.solid.pizza.repository.OrderRepository;
import com.rakovets.course.design.practice.solid.pizza.model.Pizza;
import com.rakovets.course.design.practice.solid.pizza.repository.StorageRepository;
import com.rakovets.course.design.practice.solid.pizza.service.*;
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

public class PizzaOrderController {
    private static final Map<Integer, Pizza> pizzas = new HashMap<>();
    private final StorageRepository storage = new StorageRepository();
    private final OrderRepository orderRepository = new OrderRepository(new ArrayList<>());
    private final PizzaOrderViewConsole pizzaOrderViewConsole = new PizzaOrderViewConsole();
    public char ch;
    private final Path filePath = Paths.get("src", "main", "resources", "Orders.txt");
    private final BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(filePath)));

    static {

        pizzas.put(1, Pizza.FOUR_CHEESE);
        pizzas.put(2, Pizza.MARGHERITA);
        pizzas.put(3, Pizza.MEAT_DELIGHT);
        pizzas.put(4, Pizza.PEPPERONI);
        pizzas.put(5, Pizza.VEGETARIAN);

    }

    public PizzaOrderController() throws IOException {
    }

    public void start() {
        pizzaOrderViewConsole.greeting();
    }

    public void choosePizza() throws IOException {
        pizzaOrderViewConsole.pizzaMenu();
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (pizzas.get(choice)) {
            case FOUR_CHEESE:
                pizzaOrderViewConsole.orderPizzaFourCheese();
                storage.changeIngredientQuantity(Pizza.FOUR_CHEESE);
                orderRepository.add(ProfitService.profitPercentage(PizzaCostService.getCostFourCheese()));
                writer.append(DateFormatService.localDatePattern(LocalDateTime.now())).append("\t")
                        .append(String.valueOf(Pizza.FOUR_CHEESE)).append("\t")
                        .append(String.valueOf(RoundUpService.roundUp(ProfitService.profitPercentage(
                                PizzaCostService.getCostFourCheese())))).append("$");
                writer.append('\n');
                break;
            case MARGHERITA:
                pizzaOrderViewConsole.orderPizzaMargherita();
                storage.changeIngredientQuantity(Pizza.MARGHERITA);
                orderRepository.add(ProfitService.profitPercentage(PizzaCostService.getCostMargherita()));
                writer.append(DateFormatService.localDatePattern(LocalDateTime.now())).append("\t")
                        .append(String.valueOf(Pizza.MARGHERITA)).append("\t")
                        .append(String.valueOf(RoundUpService.roundUp(ProfitService.profitPercentage(
                                PizzaCostService.getCostMargherita())))).append("$");
                writer.append('\n');
                break;
            case MEAT_DELIGHT:
                pizzaOrderViewConsole.orderPizzaMeatDelight();
                storage.changeIngredientQuantity(Pizza.MEAT_DELIGHT);
                orderRepository.add(ProfitService.profitPercentage(PizzaCostService.getCostMeatDelight()));
                writer.append(DateFormatService.localDatePattern(LocalDateTime.now())).append("\t")
                        .append(String.valueOf(Pizza.MEAT_DELIGHT)).append("\t")
                        .append(String.valueOf(RoundUpService.roundUp(ProfitService
                                .profitPercentage(PizzaCostService.getCostMeatDelight())))).append("$");
                writer.append('\n');
                break;
            case PEPPERONI:
                pizzaOrderViewConsole.orderPizzaPepperoni();
                storage.changeIngredientQuantity(Pizza.PEPPERONI);
                orderRepository.add(ProfitService.profitPercentage(PizzaCostService.getCostPepperoni()));
                writer.append(DateFormatService.localDatePattern(LocalDateTime.now())).append("\t")
                        .append(String.valueOf(Pizza.PEPPERONI)).append("\t")
                        .append(String.valueOf(RoundUpService.roundUp(ProfitService.profitPercentage(
                                PizzaCostService.getCostPepperoni())))).append("$");
                writer.append('\n');
                break;
            case VEGETARIAN:
                pizzaOrderViewConsole.orderPizzaVegetarian();
                storage.changeIngredientQuantity(Pizza.VEGETARIAN);
                orderRepository.add(ProfitService.profitPercentage(PizzaCostService.getCostVegetarian()));
                writer.append(DateFormatService.localDatePattern(LocalDateTime.now())).append("\t")
                        .append(String.valueOf(Pizza.VEGETARIAN)).append("\t")
                        .append(String.valueOf(RoundUpService.roundUp(ProfitService.profitPercentage(
                                PizzaCostService.getCostVegetarian())))).append("$");
                writer.append('\n');
                break;
        }
        totalOrder();
        discountForTwoItems();
        discountForThreeAndMoreItems();
        discountForOrderOnSpecificDay();
        amountToPay();
        writer.flush();
    }

    public void totalOrder() {
        double totalOrder = orderRepository.totalOrder();
        int size = orderRepository.size();
        pizzaOrderViewConsole.totalOrder(totalOrder, size);
    }

    public void discountForTwoItems() {
        if (orderRepository.size() == 2) {
            double totalOrder = DiscountService.discountForTwoItems(orderRepository.totalOrder());
            pizzaOrderViewConsole.discountFor2Pizzas(totalOrder);
        }
    }

    public void discountForThreeAndMoreItems() {
        if (orderRepository.size() >= 3) {
            double totalOrder = DiscountService.discountForThreeAndMoreItems(orderRepository.totalOrder());
            pizzaOrderViewConsole.discountFor3AndMorePizzas(totalOrder);
        }
    }

    public void discountForOrderOnSpecificDay() {
        if (orderRepository.size() == 1 && LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            double totalOrder = DiscountService.discountForOrderOnSpecificDay(orderRepository.totalOrder());
            pizzaOrderViewConsole.discountForOrderOnSpecificDay(totalOrder);
            pizzaOrderViewConsole.amountToPay(DiscountService.discountForOrderOnSpecificDay(
                    orderRepository.totalOrder()));
        }
        else if (LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            double totalOrder = DiscountService.discountForOrderOnSpecificDay(orderRepository.totalOrder());
            pizzaOrderViewConsole.discountForOrderOnSpecificDay(totalOrder);
        }
    }

    public void amountToPay() {
        if (orderRepository.size() == 2 && LocalDateTime.now().getDayOfWeek() != DayOfWeek.FRIDAY) {
            pizzaOrderViewConsole.amountToPay(DiscountService.discountForTwoItems(orderRepository.totalOrder()));
        }
        else if (orderRepository.size() == 2 && LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            pizzaOrderViewConsole.amountToPay(DiscountService.amountToPayFor2PizzasOnSpecificDay(
                    orderRepository.totalOrder()));
        }
        else if (orderRepository.size() >= 3 && LocalDateTime.now().getDayOfWeek() != DayOfWeek.FRIDAY) {
            pizzaOrderViewConsole.amountToPay(DiscountService.discountForThreeAndMoreItems(
                    orderRepository.totalOrder()));
        }
        else if (orderRepository.size() >= 3 && LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            pizzaOrderViewConsole.amountToPay(DiscountService.amountToPayFor3AndMorePizzasOnSpecificDay(
                    orderRepository.totalOrder()));
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

    public void paymentChoice() {
        pizzaOrderViewConsole.paymentChoice();
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                pizzaOrderViewConsole.cashPayment();
                break;
            case 2:
                pizzaOrderViewConsole.cardPayment();
                break;
            default:
                pizzaOrderViewConsole.onlinePayment();
                break;
        }
    }
}
