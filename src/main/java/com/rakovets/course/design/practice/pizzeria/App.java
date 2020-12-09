package com.rakovets.course.design.practice.pizzeria;

import com.rakovets.course.design.practice.pizzeria.model.Pizza;
import com.rakovets.course.design.practice.pizzeria.model.Product;
import com.rakovets.course.design.practice.pizzeria.repository.Account;
import com.rakovets.course.design.practice.pizzeria.repository.Discounts;
import com.rakovets.course.design.practice.pizzeria.repository.Storage;
import com.rakovets.course.design.practice.pizzeria.service.Loader;
import com.rakovets.course.design.practice.pizzeria.service.Maker;
import com.rakovets.course.design.practice.pizzeria.service.Saver;
import com.rakovets.course.design.practice.pizzeria.service.Seller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        Set<String> pizzaNames = Loader.loadPizzaNames();
        Set<String> payments = Loader.loadPayments();
        Map<String, Product> pizzaMap = pizzaNames.stream().collect(Collectors.toMap(s -> s, Pizza::new));
        Storage.start();
        Storage.checkIngredients();
        Account.start();
        Discounts.start();

        System.out.println(LocalDate.now().getDayOfWeek());
        String mainMessage = "Enter command (" + pizzaNames + ", checkout, ingredients, exit): ";
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
                for (String product : pizzaNames) {
                    if (command.equals(product)) {
                        cart.add(product);
                        total += pizzaMap.get(product).getCost();
                        System.out.println(product + " added to cart. Cart: " + cart + " Total to pay: " + total);
                    }
                }
                if (command.equals("checkout")) {
                    System.out.println("Choose payment type " + payments);
                    String payment = null;
                    command = reader.readLine();
                    for (String pay : payments) {
                        if (command.equals(pay)) {
                            payment = pay;
                        }
                    }

                    StringBuilder check = new StringBuilder();
                    check.append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).append("\n");
                    int discount = Discounts.getMaxDiscount(cart.size());
                    for (String productName : cart) {
                        Product product = pizzaMap.get(productName);
                        Maker.makePizza((Pizza) product);
                        Seller.sell(product, payment, discount);
                        check.append(product.getName()).append(" ").append(product.getCost()).append("\n");
                    }
                    Saver.saveIngredients();
                    Saver.saveAccount();
                    check.append("Subtotal: " + total + "\n");
                    check.append("Discount: " + discount + "%\n");
                    total -= total * discount * 0.01;
                    check.append("Total: " + total + "\n\n");
                    System.out.print(check);
                    Saver.saveCheck(check);
                    total = 0;
                    cart.clear();
                    Storage.checkIngredients();
                    System.out.println(mainMessage);
                }
                if (command.equals("ingredients")) {
                    System.out.println(Storage.printIngredients());
                    System.out.println(mainMessage);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
