package com.rakovets.course.design.practice.solid.Pizza.Controller;

import com.rakovets.course.design.practice.solid.Pizza.Repository.Order;
import com.rakovets.course.design.practice.solid.Pizza.Repository.Pizza;
import com.rakovets.course.design.practice.solid.Pizza.Repository.Storage;
import com.rakovets.course.design.practice.solid.Pizza.Service.*;

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

public class PizzaOrder {
    public static void start() throws IOException {

        CashPayment cashPayment = new CashPayment();
        CardPayment cardPayment = new CardPayment();
        OnlinePayment onlinePayment = new OnlinePayment();
        Storage storage = new Storage();
        Order order = new Order(new ArrayList<>());

        Scanner scan = new Scanner(System.in);

        Path filePath = Paths.get("src", "main", "resources", "Orders.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(filePath)));

        System.out.println("\nWELCOME TO PIZZERIA!");
        System.out.println("Choose what pizza you would like to order:");
        char ch;

        do {
            System.out.println("1. Four Cheese");
            System.out.println("2. Margherita");
            System.out.println("3. Meat Delight");
            System.out.println("4. Pepperoni");
            System.out.println("5. Vegetarian");
            int choice = scan.nextInt();

            Map<Integer, Pizza> pizzas = new HashMap<>();
            pizzas.put(1, Pizza.FOUR_CHEESE);
            pizzas.put(2, Pizza.MARGHERITA);
            pizzas.put(3, Pizza.MEAT_DELIGHT);
            pizzas.put(4, Pizza.PEPPERONI);
            pizzas.put(5, Pizza.VEGETARIAN);

            switch (pizzas.get(choice)) {
                case FOUR_CHEESE:
                    System.out.println(DateFormat.localDatePattern(LocalDateTime.now()) + "\t" + Pizza.FOUR_CHEESE +
                            "\t" + RoundUp.roundUp(Profit.profitPercentage(PizzaCost.getCostFourCheese())) + "$");
                    storage.changeIngredientQuantity(Pizza.FOUR_CHEESE);
                    order.add(Profit.profitPercentage(PizzaCost.getCostFourCheese()));
                    writer.append(DateFormat.localDatePattern(LocalDateTime.now())).append("\t")
                            .append(String.valueOf(Pizza.FOUR_CHEESE)).append("\t")
                            .append(String.valueOf(RoundUp.roundUp(Profit.profitPercentage(PizzaCost
                                    .getCostFourCheese())))).append("$");
                    writer.append('\n');
                    break;
                case MARGHERITA:
                    System.out.println(DateFormat.localDatePattern(LocalDateTime.now()) + "\t" + Pizza.MARGHERITA +
                            "\t" + RoundUp.roundUp(Profit.profitPercentage(PizzaCost.getCostMargherita())) + "$");
                    storage.changeIngredientQuantity(Pizza.MARGHERITA);
                    order.add(Profit.profitPercentage(PizzaCost.getCostMargherita()));
                    writer.append(DateFormat.localDatePattern(LocalDateTime.now())).append("\t")
                            .append(String.valueOf(Pizza.MARGHERITA)).append("\t")
                            .append(String.valueOf(RoundUp.roundUp(Profit.profitPercentage(PizzaCost
                                    .getCostMargherita())))).append("$");
                    writer.append('\n');
                    break;
                case MEAT_DELIGHT:
                    System.out.println(DateFormat.localDatePattern(LocalDateTime.now()) + "\t" + Pizza.MEAT_DELIGHT +
                            "\t" + RoundUp.roundUp(Profit.profitPercentage(PizzaCost.getCostMeatDelight())) + "$");
                    storage.changeIngredientQuantity(Pizza.MEAT_DELIGHT);
                    order.add(Profit.profitPercentage(PizzaCost.getCostMeatDelight()));
                    writer.append(DateFormat.localDatePattern(LocalDateTime.now())).append("\t")
                            .append(String.valueOf(Pizza.MEAT_DELIGHT)).append("\t")
                            .append(String.valueOf(RoundUp.roundUp(Profit
                                    .profitPercentage(PizzaCost.getCostMeatDelight())))).append("$");
                    writer.append('\n');
                    break;
                case PEPPERONI:
                    System.out.println(DateFormat.localDatePattern(LocalDateTime.now()) + "\t" + Pizza.PEPPERONI +
                            "\t" + RoundUp.roundUp(Profit.profitPercentage(PizzaCost.getCostPepperoni())) + "$");
                    storage.changeIngredientQuantity(Pizza.PEPPERONI);
                    order.add(Profit.profitPercentage(PizzaCost.getCostPepperoni()));
                    writer.append(DateFormat.localDatePattern(LocalDateTime.now())).append("\t")
                            .append(String.valueOf(Pizza.PEPPERONI)).append("\t")
                            .append(String.valueOf(RoundUp.roundUp(Profit.profitPercentage(PizzaCost
                                    .getCostPepperoni())))).append("$");
                    writer.append('\n');
                    break;
                case VEGETARIAN:
                    System.out.println(DateFormat.localDatePattern(LocalDateTime.now()) + "\t" + Pizza.VEGETARIAN +
                            "\t" + RoundUp.roundUp(Profit.profitPercentage(PizzaCost.getCostVegetarian())) + "$");
                    storage.changeIngredientQuantity(Pizza.VEGETARIAN);
                    order.add(Profit.profitPercentage(PizzaCost.getCostVegetarian()));
                    writer.append(DateFormat.localDatePattern(LocalDateTime.now())).append("\t")
                            .append(String.valueOf(Pizza.VEGETARIAN)).append("\t")
                            .append(String.valueOf(RoundUp.roundUp(Profit.profitPercentage(PizzaCost
                                    .getCostVegetarian())))).append("$");
                    writer.append('\n');
                    break;
            }

            double totalOrder = order.totalOrder();
            int size = order.size();
            System.out.println("Order is " + RoundUp.roundUp(totalOrder) + "$\nNumber of pizzas: " + size);

            if (size == 2) {
                totalOrder = Discount.discountForTwoItems(totalOrder);
                System.out.println("Discount for ordering 2 pizzas: "
                        + RoundUp.roundUp(totalOrder - Discount.discountForTwoItems(totalOrder)) + "$");
            }

            if (size >= 3) {
                totalOrder = Discount.discountForThreeAndMoreItems(totalOrder);
                System.out.println("Discount for ordering 3 & more pizzas: "
                        + RoundUp.roundUp(totalOrder - Discount.discountForThreeAndMoreItems(totalOrder)) + "$");
            }

            if (LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
                totalOrder = Discount.discountForOrderOnSpecificDay(totalOrder);
                System.out.println("Discount for ordering on Discount Day: "
                        + RoundUp.roundUp(totalOrder - Discount.discountForOrderOnSpecificDay(totalOrder)) + "$");
            }

            System.out.println("Amount to pay: " + RoundUp.roundUp(totalOrder) + "$");

            System.out.println("\nDo you want to order anything else (Type y or n)");
            ch = scan.next().charAt(0);
        }

        while (ch == 'Y' || ch == 'y');

        System.out.println("How would you like to pay:");
        System.out.println("1. Cash");
        System.out.println("2. Credit card");
        System.out.println("3. Online");
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                System.out.println(cashPayment.toString());
                break;
            case 2:
                System.out.println(cardPayment.toString());
                break;
            default:
                System.out.println(onlinePayment.toString());
                break;
        }
        writer.close();
    }
}