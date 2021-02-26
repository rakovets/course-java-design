package com.rakovets.course.design.practice.solid.Pizza.Controller;

import com.rakovets.course.design.practice.solid.Pizza.Repository.Ingredient;
import com.rakovets.course.design.practice.solid.Pizza.Repository.Order;
import com.rakovets.course.design.practice.solid.Pizza.Repository.Storage;
import com.rakovets.course.design.practice.solid.Pizza.Service.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CreatePizza {
    public static void start() {

        Order order = new Order(new ArrayList<>());
        CashPayment cashPayment = new CashPayment();
        CardPayment cardPayment = new CardPayment();
        OnlinePayment onlinePayment = new OnlinePayment();
        Storage storage = new Storage();

        Scanner scan = new Scanner(System.in);

        System.out.println("\nWELCOME TO PIZZERIA!");
        System.out.println("You can create your own pizza");
        char ch;

        System.out.println("Choose type of dough you would like to have:");
        System.out.println("1. Thin Dough");
        System.out.println("2. Traditional Dough");

        Map<Integer, Ingredient> dough = new HashMap<>();
        dough.put(1, Ingredient.THIN_DOUGH);
        dough.put(2, Ingredient.TRADITIONAL_DOUGH);

        int cho = scan.nextInt();

        switch (dough.get(cho)) {
            case THIN_DOUGH:
                order.add(Profit.profitPercentage(Ingredient.THIN_DOUGH.getCostPerUnit()));
                storage.changeIngredientQuantity(Ingredient.THIN_DOUGH, storage.getIngredientQuantity(Ingredient.THIN_DOUGH),
                        storage.getIngredientQuantity(Ingredient.THIN_DOUGH) - 1);
                break;
            case TRADITIONAL_DOUGH:
                order.add(Profit.profitPercentage(Ingredient.TRADITIONAL_DOUGH.getCostPerUnit()));
                storage.changeIngredientQuantity(Ingredient.TRADITIONAL_DOUGH,
                        storage.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH),
                        storage.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH) - 1);
                break;
        }

        System.out.println("Choose ingredients you would like to have in your pizza:");

        do {
            System.out.println("1. Cheese");
            System.out.println("2. Meat");
            System.out.println("3. Sausages");
            System.out.println("4. Olives");
            System.out.println("5. Tomatoes");
            System.out.println("6. Pepper");
            System.out.println("7. Oregano");
            System.out.println("8. Sauce");
            System.out.println("9. Cheese crust");

            Map<Integer, Ingredient> ingredients = new HashMap<>();
            ingredients.put(1, Ingredient.CHEESE);
            ingredients.put(2, Ingredient.MEAT);
            ingredients.put(3, Ingredient.SAUSAGES);
            ingredients.put(4, Ingredient.OLIVES);
            ingredients.put(5, Ingredient.TOMATOES);
            ingredients.put(6, Ingredient.PEPPER);
            ingredients.put(7, Ingredient.OREGANO);
            ingredients.put(8, Ingredient.SAUCE);
            ingredients.put(9, Ingredient.CRUST);

            int choice = scan.nextInt();
            switch (ingredients.get(choice)) {
                case CHEESE:
                    order.add(Profit.profitPercentage(Ingredient.CHEESE.getCostPerUnit()));
                    storage.changeIngredientQuantity(Ingredient.CHEESE, storage.getIngredientQuantity(Ingredient.CHEESE),
                            storage.getIngredientQuantity(Ingredient.CHEESE) - 1);
                    break;
                case MEAT:
                    order.add(Profit.profitPercentage(Ingredient.MEAT.getCostPerUnit()));
                    storage.changeIngredientQuantity(Ingredient.MEAT, storage.getIngredientQuantity(Ingredient.MEAT),
                            storage.getIngredientQuantity(Ingredient.MEAT) - 1);
                    break;
                case SAUSAGES:
                    order.add(Profit.profitPercentage(Ingredient.SAUSAGES.getCostPerUnit()));
                    storage.changeIngredientQuantity(Ingredient.SAUSAGES, storage.getIngredientQuantity(Ingredient.SAUSAGES),
                            storage.getIngredientQuantity(Ingredient.SAUSAGES) - 1);
                    break;
                case OLIVES:
                    order.add(Profit.profitPercentage(Ingredient.OLIVES.getCostPerUnit()));
                    storage.changeIngredientQuantity(Ingredient.OLIVES, storage.getIngredientQuantity(Ingredient.OLIVES),
                            storage.getIngredientQuantity(Ingredient.OLIVES) - 1);
                    break;
                case TOMATOES:
                    order.add(Profit.profitPercentage(Ingredient.TOMATOES.getCostPerUnit()));
                    storage.changeIngredientQuantity(Ingredient.TOMATOES, storage.getIngredientQuantity(Ingredient.TOMATOES),
                            storage.getIngredientQuantity(Ingredient.TOMATOES) - 1);
                    break;
                case PEPPER:
                    order.add(Profit.profitPercentage(Ingredient.PEPPER.getCostPerUnit()));
                    storage.changeIngredientQuantity(Ingredient.PEPPER, storage.getIngredientQuantity(Ingredient.PEPPER),
                            storage.getIngredientQuantity(Ingredient.PEPPER) - 1);
                    break;
                case OREGANO:
                    order.add(Profit.profitPercentage(Ingredient.OREGANO.getCostPerUnit()));
                    storage.changeIngredientQuantity(Ingredient.OREGANO, storage.getIngredientQuantity(Ingredient.OREGANO),
                            storage.getIngredientQuantity(Ingredient.OREGANO) - 1);
                    break;
                case SAUCE:
                    order.add(Profit.profitPercentage(Ingredient.SAUCE.getCostPerUnit()));
                    storage.changeIngredientQuantity(Ingredient.SAUCE, storage.getIngredientQuantity(Ingredient.SAUCE),
                            storage.getIngredientQuantity(Ingredient.SAUCE) - 1);
                    break;
                case CRUST:
                    order.add(Profit.profitPercentage(Ingredient.CRUST.getCostPerUnit()));
                    break;
            }

            double totalOrder = RoundUp.roundUp(order.totalOrder());

            System.out.println("Total order is " + totalOrder + "$");

            System.out.println("\nDo you want to add more ingredients? (Type y or n)");
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
    }
}