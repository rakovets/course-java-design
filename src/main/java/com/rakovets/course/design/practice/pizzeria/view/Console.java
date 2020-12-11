package com.rakovets.course.design.practice.pizzeria.view;

import com.rakovets.course.design.practice.pizzeria.model.Pizza;
import com.rakovets.course.design.practice.pizzeria.model.Product;
import com.rakovets.course.design.practice.pizzeria.repository.Starter;
import com.rakovets.course.design.practice.pizzeria.repository.Discounts;
import com.rakovets.course.design.practice.pizzeria.repository.Storage;
import com.rakovets.course.design.practice.pizzeria.service.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.PriorityQueue;
import java.util.Queue;

public class Console {
    public static void start() {
        Storage.checkIngredients();
        String mainMessage = "Enter command (" + Starter.pizzaNames + ", checkout, info, exit): ";
        System.out.println(mainMessage);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command;
        Queue<String> cart = new PriorityQueue<>();
        double total = 0;

        while (true) {
            try {
                command = reader.readLine();
                if (command.equals("exit")) {
                    break;
                }
                for (String productName : Starter.pizzaNames) {
                    if (command.equals(productName)) {
                        cart.add(productName);
                        total += Starter.pizzaMap.get(productName).getCost();
                        System.out.println(productName + " added to cart. Cart: " + cart + ". Total to pay: " + total);
                    }
                }
                if (command.equals("checkout")) {
                    System.out.println("Choose payment type " + Starter.payments + ":");
                    String payment = null;
                    command = reader.readLine();
                    for (String pay : Starter.payments) {
                        if (command.equals(pay)) {
                            payment = pay;
                        }
                    }

                    StringBuilder check = new StringBuilder();
                    check.append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).append("\n");
                    int discount = Discounts.getMaxDiscount(cart.size());
                    for (String productName : cart) {
                        Product product = Starter.pizzaMap.get(productName);
                        Maker.makePizza((Pizza) product);
                        Seller.sell(product, payment, discount);
                        check.append(product.getName()).append(" ").append(product.getCost()).append("\n");
                    }

                    check.append("Subtotal: ").append(total).append("\n");
                    check.append("Discount: ").append(discount).append("%\n");
                    total -= total * discount * 0.01;
                    total = Calc.round(total);
                    check.append("Total: ").append(total).append("\n\n");
                    System.out.print(check);
                    
                    Saver.autoSave(check);
                    total = 0;
                    cart.clear();
                    Storage.checkIngredients();
                    System.out.println(mainMessage);
                }
                if (command.equals("info")) {
                    System.out.println("Choose: sold_pizzas, proceeds, income, ingredients");
                    command = reader.readLine();
                    if (command.equals("ingredients")) {
                        System.out.println(Storage.printIngredients());
                        System.out.println(mainMessage);
                    }
                    if (command.equals("sold_pizzas")
                        || command.equals("proceeds")
                            ||  command.equals("income")) {
                        System.out.println("Choose period for last... (hour, day, week, month):");
                        getInfo(command, reader.readLine());
                        System.out.println(mainMessage);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void getInfo(String command, String period) {
        LocalDateTime from = switch (period) {
            case "hour" -> LocalDateTime.now().minusHours(1);
            case "day" -> LocalDateTime.now().minusDays(1);
            case "week" -> LocalDateTime.now().minusWeeks(1);
            case "month" -> LocalDateTime.now().minusMonths(1);
            default -> null;
        };
        switch (command) {
            case "sold_pizzas" -> System.out.println(Counter.getSoldPizzas(from));
            case "proceeds" -> System.out.println(Counter.getProceeds(from));
            case "income" -> System.out.println(Counter.getIncome(from));
        }

    }
}
