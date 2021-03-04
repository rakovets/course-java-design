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
    public static void start() throws IOException {

        StorageRepository storage = new StorageRepository();
        OrderRepository orderRepository = new OrderRepository(new ArrayList<>());
        PizzaOrderViewConsole pizzaOrderViewConsole = new PizzaOrderViewConsole();
        Map<Integer, Pizza> pizzas = new HashMap<>();

        Scanner scan = new Scanner(System.in);
        char ch;

        Path filePath = Paths.get("src", "main", "resources", "Orders.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(filePath)));

        pizzaOrderViewConsole.greeting();

        do {
            pizzaOrderViewConsole.pizzaMenu();
            pizzas.put(1, Pizza.FOUR_CHEESE);
            pizzas.put(2, Pizza.MARGHERITA);
            pizzas.put(3, Pizza.MEAT_DELIGHT);
            pizzas.put(4, Pizza.PEPPERONI);
            pizzas.put(5, Pizza.VEGETARIAN);

            int choice = scan.nextInt();
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

            double totalOrder = orderRepository.totalOrder();
            int size = orderRepository.size();
            pizzaOrderViewConsole.totalOrder(totalOrder, size);

            if (size == 2) {
                totalOrder = DiscountService.discountForTwoItems(totalOrder);
                pizzaOrderViewConsole.discountFor2Pizzas(totalOrder);
            }

            if (size >= 3) {
                totalOrder = DiscountService.discountForThreeAndMoreItems(totalOrder);
                pizzaOrderViewConsole.discountFor3AndMorePizzas(totalOrder);
            }

            if (LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
                totalOrder = DiscountService.discountForOrderOnSpecificDay(totalOrder);
                pizzaOrderViewConsole.discountForOrderOnSpecificDay(totalOrder);
            }

            pizzaOrderViewConsole.amountToPay(totalOrder);

            pizzaOrderViewConsole.addPizzaQuestion();
            ch = scan.next().charAt(0);
        }
        while (ch == 'Y' || ch == 'y');

        pizzaOrderViewConsole.paymentChoice();
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
        writer.close();
    }
}