package com.rakovets.course.design.practice.solid.Pizza.Order;

import com.rakovets.course.design.practice.solid.Pizza.Finance.CardPayment;
import com.rakovets.course.design.practice.solid.Pizza.Finance.CashPayment;
import com.rakovets.course.design.practice.solid.Pizza.Finance.Discount;
import com.rakovets.course.design.practice.solid.Pizza.Finance.OnlinePayment;
import com.rakovets.course.design.practice.solid.Pizza.Ingredients.*;
import com.rakovets.course.design.practice.solid.Pizza.Pizzas.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class PizzaOrder {

    public static void main(String[] args) throws IOException {

        FourCheese fourCheese = new FourCheese();
        Margherita margherita = new Margherita();
        MeatDelight meatDelight = new MeatDelight();
        Pepperoni pepperoni = new Pepperoni();
        Vegetarian vegetarian = new Vegetarian();
        CashPayment cashPayment = new CashPayment();
        CardPayment cardPayment = new CardPayment();
        OnlinePayment onlinePayment = new OnlinePayment();
        Storage storage = new Storage();
        Cheese cheese = new Cheese();
        Meat meat = new Meat();
        Olives olives = new Olives();
        Oregano oregano = new Oregano();
        Pepper pepper = new Pepper();
        Sauce sauce = new Sauce();
        Sausages sausages = new Sausages();
        Tomatoes tomatoes = new Tomatoes();
        TraditionalDough traditionalDough = new TraditionalDough();
        Order order = new Order(new ArrayList<>());

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
                    System.out.println(DateFormat.localDatePattern(LocalDateTime.now()) + "\t" + fourCheese.toString());
                    order.add(fourCheese.getPrice());
                    storage.changeIngredientQuantity(traditionalDough, storage.getIngredientQuantity(traditionalDough),
                            storage.getIngredientQuantity(traditionalDough) - 1);
                    storage.changeIngredientQuantity(sauce, storage.getIngredientQuantity(sauce),
                            storage.getIngredientQuantity(sauce) - 1);
                    storage.changeIngredientQuantity(cheese, storage.getIngredientQuantity(cheese),
                            storage.getIngredientQuantity(cheese) - 4);
                    storage.changeIngredientQuantity(oregano, storage.getIngredientQuantity(oregano),
                            storage.getIngredientQuantity(oregano) - 1);
                    writer.append(DateFormat.localDatePattern(LocalDateTime.now())).append("\t")
                            .append(fourCheese.toString());
                    writer.append('\n');
                    break;
                case 2:
                    System.out.println(DateFormat.localDatePattern(LocalDateTime.now()) + "\t" + margherita.toString());
                    order.add(margherita.getPrice());
                    storage.changeIngredientQuantity(traditionalDough, storage.getIngredientQuantity(traditionalDough),
                            storage.getIngredientQuantity(traditionalDough) - 1);
                    storage.changeIngredientQuantity(sauce, storage.getIngredientQuantity(sauce),
                            storage.getIngredientQuantity(sauce) - 1);
                    storage.changeIngredientQuantity(cheese, storage.getIngredientQuantity(cheese),
                            storage.getIngredientQuantity(cheese) - 2);
                    storage.changeIngredientQuantity(tomatoes, storage.getIngredientQuantity(tomatoes),
                            storage.getIngredientQuantity(tomatoes) - 2);
                    storage.changeIngredientQuantity(oregano, storage.getIngredientQuantity(oregano),
                            storage.getIngredientQuantity(oregano) - 1);
                    writer.append(DateFormat.localDatePattern(LocalDateTime.now())).append("\t")
                            .append(margherita.toString());
                    writer.append('\n');
                    break;
                case 3:
                    System.out.println(DateFormat.localDatePattern(LocalDateTime.now()) + "\t" + meatDelight.toString());
                    order.add(meatDelight.getPrice());
                    storage.changeIngredientQuantity(traditionalDough, storage.getIngredientQuantity(traditionalDough),
                            storage.getIngredientQuantity(traditionalDough) - 1);
                    storage.changeIngredientQuantity(sauce, storage.getIngredientQuantity(sauce),
                            storage.getIngredientQuantity(sauce) - 1);
                    storage.changeIngredientQuantity(cheese, storage.getIngredientQuantity(cheese),
                            storage.getIngredientQuantity(cheese) - 1);
                    storage.changeIngredientQuantity(meat, storage.getIngredientQuantity(meat),
                            storage.getIngredientQuantity(meat) - 2);
                    storage.changeIngredientQuantity(sausages, storage.getIngredientQuantity(sausages),
                            storage.getIngredientQuantity(sausages) - 2);
                    writer.append(DateFormat.localDatePattern(LocalDateTime.now())).append("\t")
                            .append(meatDelight.toString());
                    writer.append('\n');
                    break;
                case 4:
                    System.out.println(DateFormat.localDatePattern(LocalDateTime.now()) + "\t" + pepperoni.toString());
                    order.add(pepperoni.getPrice());
                    storage.changeIngredientQuantity(traditionalDough, storage.getIngredientQuantity(traditionalDough),
                            storage.getIngredientQuantity(traditionalDough) - 1);
                    storage.changeIngredientQuantity(sauce, storage.getIngredientQuantity(sauce),
                            storage.getIngredientQuantity(sauce) - 1);
                    storage.changeIngredientQuantity(meat, storage.getIngredientQuantity(meat),
                            storage.getIngredientQuantity(meat) - 3);
                    storage.changeIngredientQuantity(cheese, storage.getIngredientQuantity(cheese),
                            storage.getIngredientQuantity(cheese) - 1);
                    writer.append(DateFormat.localDatePattern(LocalDateTime.now())).append("\t")
                            .append(pepperoni.toString());
                    writer.append('\n');
                    break;
                default:
                    System.out.println(DateFormat.localDatePattern(LocalDateTime.now()) + "\t" + vegetarian.toString());
                    order.add(vegetarian.getPrice());
                    storage.changeIngredientQuantity(traditionalDough, storage.getIngredientQuantity(traditionalDough),
                            storage.getIngredientQuantity(traditionalDough) - 1);
                    storage.changeIngredientQuantity(sauce, storage.getIngredientQuantity(sauce),
                            storage.getIngredientQuantity(sauce) - 2);
                    storage.changeIngredientQuantity(cheese, storage.getIngredientQuantity(cheese),
                            storage.getIngredientQuantity(cheese) - 1);
                    storage.changeIngredientQuantity(tomatoes, storage.getIngredientQuantity(tomatoes),
                            storage.getIngredientQuantity(tomatoes) - 2);
                    storage.changeIngredientQuantity(pepper, storage.getIngredientQuantity(pepper),
                            storage.getIngredientQuantity(pepper) - 2);
                    storage.changeIngredientQuantity(olives, storage.getIngredientQuantity(olives),
                            storage.getIngredientQuantity(olives) - 2);
                    writer.append(DateFormat.localDatePattern(LocalDateTime.now())).append("\t")
                            .append(vegetarian.toString());
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

            if (LocalDateTime.now().getDayOfWeek() == DayOfWeek.MONDAY) {
                totalOrder = discount.discountForOrderOnMonday(totalOrder);
                System.out.println("Discount for ordering on Monday: "
                        + BigDecimal.valueOf((totalOrder - discount.discountForOrderOnMonday(totalOrder)))
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