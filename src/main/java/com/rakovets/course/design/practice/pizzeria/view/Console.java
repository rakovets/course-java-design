package com.rakovets.course.design.practice.pizzeria.view;

import com.rakovets.course.design.practice.pizzeria.model.Pizza;
import com.rakovets.course.design.practice.pizzeria.model.Product;
import com.rakovets.course.design.practice.pizzeria.repository.Const;
import com.rakovets.course.design.practice.pizzeria.repository.Discounts;
import com.rakovets.course.design.practice.pizzeria.repository.Storage;
import com.rakovets.course.design.practice.pizzeria.service.Maker;
import com.rakovets.course.design.practice.pizzeria.service.Saver;
import com.rakovets.course.design.practice.pizzeria.service.Seller;

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
        String mainMessage = "Enter command (" + Const.pizzaNames + ", checkout, ingredients, exit): ";
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
                for (String product : Const.pizzaNames) {
                    if (command.equals(product)) {
                        cart.add(product);
                        total += Const.pizzaMap.get(product).getCost();
                        System.out.println(product + " added to cart. Cart: " + cart + " Total to pay: " + total);
                    }
                }
                if (command.equals("checkout")) {
                    System.out.println("Choose payment type " + Const.payments);
                    String payment = null;
                    command = reader.readLine();
                    for (String pay : Const.payments) {
                        if (command.equals(pay)) {
                            payment = pay;
                        }
                    }

                    StringBuilder check = new StringBuilder();
                    check.append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).append("\n");
                    int discount = Discounts.getMaxDiscount(cart.size());
                    for (String productName : cart) {
                        Product product = Const.pizzaMap.get(productName);
                        Maker.makePizza((Pizza) product);
                        Seller.sell(product, payment, discount);
                        check.append(product.getName()).append(" ").append(product.getCost()).append("\n");
                    }

                    check.append("Subtotal: ").append(total).append("\n");
                    check.append("Discount: ").append(discount).append("%\n");
                    total -= total * discount * 0.01;
                    check.append("Total: ").append(total).append("\n\n");
                    System.out.print(check);

                    Saver.autoSaveAll(check);
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
