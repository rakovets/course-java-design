package com.rakovets.course.design.practice.solid.PizzaEnum.Order;

import com.rakovets.course.design.practice.solid.PizzaEnum.Finance.*;
import com.rakovets.course.design.practice.solid.PizzaEnum.Ingredients.*;
import com.rakovets.course.design.practice.solid.PizzaEnum.Pizzas.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class PizzaOrder {

    public static void main(String[] args) throws IOException {

        CashPayment cashPayment = new CashPayment();
        CardPayment cardPayment = new CardPayment();
        OnlinePayment onlinePayment = new OnlinePayment();
        Storage storage = new Storage();
        Order order = new Order(new ArrayList<>());
        Profit profit = new Profit();

        Scanner scan = new Scanner(System.in);

        String filePath = "src/main/resources/Orders.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

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

            switch (choice) {
                case 1:
                    System.out.println(DateFormat.localDatePattern(LocalDateTime.now()) + "\t" + Pizza.FOUR_CHEESE +
                            "\t" + (BigDecimal.valueOf((profit.profitPercentage(Pizza.FOUR_CHEESE.getCost())))
                            .setScale(2, RoundingMode.HALF_UP).doubleValue()) + "$");
                    order.add(BigDecimal.valueOf((profit.profitPercentage(Pizza.FOUR_CHEESE.getCost())))
                            .setScale(2, RoundingMode.HALF_UP).doubleValue());
                    storage.changeIngredientQuantity(Ingredient.TRADITIONAL_DOUGH,
                            storage.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH),
                            storage.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH) - 1);
                    storage.changeIngredientQuantity(Ingredient.SAUCE,
                            storage.getIngredientQuantity(Ingredient.SAUCE),
                            storage.getIngredientQuantity(Ingredient.SAUCE) - Ingredient.SAUCE.getQuantity());
                    storage.changeIngredientQuantity(Ingredient.CHEESE, storage.getIngredientQuantity(Ingredient.CHEESE),
                            storage.getIngredientQuantity(Ingredient.CHEESE) - Ingredient.CHEESE.getQuantity() * 4);
                    storage.changeIngredientQuantity(Ingredient.OREGANO, storage.getIngredientQuantity(Ingredient.OREGANO),
                            storage.getIngredientQuantity(Ingredient.OREGANO) - Ingredient.OREGANO.getQuantity());
                    writer.append(DateFormat.localDatePattern(LocalDateTime.now())).append("\t")
                            .append(String.valueOf(Pizza.FOUR_CHEESE)).append("\t")
                            .append(String.valueOf(BigDecimal.valueOf(profit.profitPercentage(Pizza.FOUR_CHEESE.getCost()))
                                    .setScale(2, RoundingMode.HALF_UP).doubleValue())).append("$");
                    writer.append('\n');
                    break;
                case 2:
                    System.out.println(DateFormat.localDatePattern(LocalDateTime.now()) + "\t" + Pizza.MARGHERITA +
                            "\t" + (BigDecimal.valueOf((profit.profitPercentage(Pizza.MARGHERITA.getCost())))
                            .setScale(2, RoundingMode.HALF_UP).doubleValue()) + "$");
                    order.add(BigDecimal.valueOf((profit.profitPercentage(Pizza.MARGHERITA.getCost())))
                            .setScale(2, RoundingMode.HALF_UP).doubleValue());
                    storage.changeIngredientQuantity(Ingredient.TRADITIONAL_DOUGH, storage.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH),
                            storage.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH) - 1);
                    storage.changeIngredientQuantity(Ingredient.SAUCE, storage.getIngredientQuantity(Ingredient.SAUCE),
                            storage.getIngredientQuantity(Ingredient.SAUCE) - Ingredient.SAUCE.getQuantity());
                    storage.changeIngredientQuantity(Ingredient.CHEESE, storage.getIngredientQuantity(Ingredient.CHEESE),
                            storage.getIngredientQuantity(Ingredient.CHEESE) - Ingredient.CHEESE.getQuantity() * 2);
                    storage.changeIngredientQuantity(Ingredient.TOMATOES, storage.getIngredientQuantity(Ingredient.TOMATOES),
                            storage.getIngredientQuantity(Ingredient.TOMATOES) - Ingredient.TOMATOES.getQuantity() * 2);
                    storage.changeIngredientQuantity(Ingredient.OREGANO, storage.getIngredientQuantity(Ingredient.OREGANO),
                            storage.getIngredientQuantity(Ingredient.OREGANO) - Ingredient.OREGANO.getQuantity());
                    writer.append(DateFormat.localDatePattern(LocalDateTime.now())).append("\t")
                            .append(String.valueOf(Pizza.MARGHERITA)).append("\t")
                            .append(String.valueOf(BigDecimal.valueOf(profit.profitPercentage(Pizza.MARGHERITA.getCost()))
                                    .setScale(2, RoundingMode.HALF_UP).doubleValue())).append("$");
                    writer.append('\n');
                    break;
                case 3:
                    System.out.println(DateFormat.localDatePattern(LocalDateTime.now()) + "\t" + Pizza.MEAT_DELIGHT +
                            "\t" + (BigDecimal.valueOf((profit.profitPercentage(Pizza.MEAT_DELIGHT.getCost())))
                            .setScale(2, RoundingMode.HALF_UP).doubleValue()) + "$");
                    order.add(BigDecimal.valueOf((profit.profitPercentage(Pizza.MEAT_DELIGHT.getCost())))
                            .setScale(2, RoundingMode.HALF_UP).doubleValue());
                    storage.changeIngredientQuantity(Ingredient.TRADITIONAL_DOUGH, storage.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH),
                            storage.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH) - 1);
                    storage.changeIngredientQuantity(Ingredient.SAUCE, storage.getIngredientQuantity(Ingredient.SAUCE),
                            storage.getIngredientQuantity(Ingredient.SAUCE) - Ingredient.SAUCE.getQuantity());
                    storage.changeIngredientQuantity(Ingredient.CHEESE, storage.getIngredientQuantity(Ingredient.CHEESE),
                            storage.getIngredientQuantity(Ingredient.CHEESE) - Ingredient.CHEESE.getQuantity());
                    storage.changeIngredientQuantity(Ingredient.MEAT, storage.getIngredientQuantity(Ingredient.MEAT),
                            storage.getIngredientQuantity(Ingredient.MEAT) - Ingredient.MEAT.getQuantity() * 2);
                    storage.changeIngredientQuantity(Ingredient.SAUSAGES, storage.getIngredientQuantity(Ingredient.SAUSAGES),
                            storage.getIngredientQuantity(Ingredient.SAUSAGES) - Ingredient.SAUSAGES.getQuantity() * 2);
                    writer.append(DateFormat.localDatePattern(LocalDateTime.now())).append("\t")
                            .append(String.valueOf(Pizza.MEAT_DELIGHT)).append("\t")
                            .append(String.valueOf(BigDecimal.valueOf(profit.profitPercentage(Pizza.MEAT_DELIGHT.getCost()))
                                    .setScale(2, RoundingMode.HALF_UP).doubleValue())).append("$");
                    writer.append('\n');
                    break;
                case 4:
                    System.out.println(DateFormat.localDatePattern(LocalDateTime.now()) + "\t" + Pizza.PEPPERONI +
                            "\t" + (BigDecimal.valueOf((profit.profitPercentage(Pizza.PEPPERONI.getCost())))
                            .setScale(2, RoundingMode.HALF_UP).doubleValue()) + "$");
                    order.add(BigDecimal.valueOf((profit.profitPercentage(Pizza.PEPPERONI.getCost())))
                            .setScale(2, RoundingMode.HALF_UP).doubleValue());
                    storage.changeIngredientQuantity(Ingredient.TRADITIONAL_DOUGH, storage.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH),
                            storage.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH) - 1);
                    storage.changeIngredientQuantity(Ingredient.SAUCE, storage.getIngredientQuantity(Ingredient.SAUCE),
                            storage.getIngredientQuantity(Ingredient.SAUCE) - Ingredient.SAUCE.getQuantity());
                    storage.changeIngredientQuantity(Ingredient.MEAT, storage.getIngredientQuantity(Ingredient.MEAT),
                            storage.getIngredientQuantity(Ingredient.MEAT) - Ingredient.MEAT.getQuantity() * 3);
                    storage.changeIngredientQuantity(Ingredient.CHEESE, storage.getIngredientQuantity(Ingredient.CHEESE),
                            storage.getIngredientQuantity(Ingredient.CHEESE) - Ingredient.CHEESE.getQuantity());
                    writer.append(DateFormat.localDatePattern(LocalDateTime.now())).append("\t")
                            .append(String.valueOf(Pizza.PEPPERONI)).append("\t")
                            .append(String.valueOf(BigDecimal.valueOf(profit.profitPercentage(Pizza.PEPPERONI.getCost()))
                            .setScale(2, RoundingMode.HALF_UP).doubleValue())).append("$");
                    writer.append('\n');
                    break;
                default:
                    System.out.println(DateFormat.localDatePattern(LocalDateTime.now()) + "\t" + Pizza.VEGETARIAN +
                            "\t" + (BigDecimal.valueOf((profit.profitPercentage(Pizza.VEGETARIAN.getCost())))
                            .setScale(2, RoundingMode.HALF_UP).doubleValue()) + "$");
                    order.add(BigDecimal.valueOf((profit.profitPercentage(Pizza.VEGETARIAN.getCost())))
                            .setScale(2, RoundingMode.HALF_UP).doubleValue());
                    storage.changeIngredientQuantity(Ingredient.TRADITIONAL_DOUGH, storage.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH),
                            storage.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH) - 1);
                    storage.changeIngredientQuantity(Ingredient.SAUCE, storage.getIngredientQuantity(Ingredient.SAUCE),
                            storage.getIngredientQuantity(Ingredient.SAUCE) - Ingredient.SAUCE.getQuantity());
                    storage.changeIngredientQuantity(Ingredient.CHEESE, storage.getIngredientQuantity(Ingredient.CHEESE),
                            storage.getIngredientQuantity(Ingredient.CHEESE) - Ingredient.CHEESE.getQuantity());
                    storage.changeIngredientQuantity(Ingredient.TOMATOES, storage.getIngredientQuantity(Ingredient.TOMATOES),
                            storage.getIngredientQuantity(Ingredient.TOMATOES) - Ingredient.TOMATOES.getQuantity() * 2);
                    storage.changeIngredientQuantity(Ingredient.PEPPER, storage.getIngredientQuantity(Ingredient.PEPPER),
                            storage.getIngredientQuantity(Ingredient.PEPPER) - Ingredient.PEPPER.getQuantity() * 2);
                    storage.changeIngredientQuantity(Ingredient.OLIVES, storage.getIngredientQuantity(Ingredient.OLIVES),
                            storage.getIngredientQuantity(Ingredient.OLIVES) - Ingredient.OLIVES.getQuantity() * 2);
                    writer.append(DateFormat.localDatePattern(LocalDateTime.now())).append("\t")
                            .append(String.valueOf(Pizza.VEGETARIAN)).append("\t")
                            .append(String.valueOf(BigDecimal.valueOf(profit.profitPercentage(Pizza.VEGETARIAN.getCost()))
                                    .setScale(2, RoundingMode.HALF_UP).doubleValue())).append("$");
                    writer.append('\n');
                    break;
            }

            double totalOrder = order.totalOrder();
            int size = order.size();
            System.out.println("Order is " + totalOrder + "$\nNumber of pizzas: " + size);

            Discount discount = new Discount();

            if (size == 2) {
                totalOrder = discount.discountForTwoItems(totalOrder);
                System.out.println("Discount for ordering 2 pizzas: "
                        + BigDecimal.valueOf((totalOrder - discount.discountForTwoItems(totalOrder)))
                        .setScale(2, RoundingMode.HALF_UP).doubleValue() + "$");
            }

            if (size >= 3) {
                totalOrder = discount.discountForThreeAndMoreItems(totalOrder);
                System.out.println("Discount for ordering 3 & more pizzas: "
                        + BigDecimal.valueOf((totalOrder - discount.discountForThreeAndMoreItems(totalOrder)))
                        .setScale(2, RoundingMode.HALF_UP).doubleValue() + "$");
            }

            if (LocalDateTime.now().getDayOfWeek() == DayOfWeek.WEDNESDAY) {
                totalOrder = discount.discountForOrderOnSpecificDay(totalOrder);
                System.out.println("Discount for ordering on Discount Day: "
                        + BigDecimal.valueOf((totalOrder - discount.discountForOrderOnSpecificDay(totalOrder)))
                        .setScale(2, RoundingMode.HALF_UP).doubleValue() + "$");
            }

            System.out.println("Amount to pay: " + BigDecimal.valueOf(totalOrder)
                    .setScale(2, RoundingMode.HALF_UP).doubleValue() + "$");

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