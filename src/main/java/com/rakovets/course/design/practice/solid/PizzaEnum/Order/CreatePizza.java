package com.rakovets.course.design.practice.solid.PizzaEnum.Order;

import com.rakovets.course.design.practice.solid.PizzaEnum.Finance.CardPayment;
import com.rakovets.course.design.practice.solid.PizzaEnum.Finance.CashPayment;
import com.rakovets.course.design.practice.solid.PizzaEnum.Finance.OnlinePayment;
import com.rakovets.course.design.practice.solid.PizzaEnum.Finance.Profit;
import com.rakovets.course.design.practice.solid.PizzaEnum.Ingredients.*;

import java.util.ArrayList;
import java.util.Scanner;

public class CreatePizza {

    public static void main(String[] args) {

        Order order = new Order(new ArrayList<>());
        CashPayment cashPayment = new CashPayment();
        CardPayment cardPayment = new CardPayment();
        OnlinePayment onlinePayment = new OnlinePayment();
        Profit profit = new Profit();
        Storage storage = new Storage();

        Scanner scan = new Scanner(System.in);

        System.out.println("\nWELCOME TO PIZZERIA!");
        System.out.println("You can create your own pizza");
        char ch;

        System.out.println("Choose type of dough you would like to have:");
        System.out.println("1. Thin Dough");
        System.out.println("2. Traditional Dough");

        int cho = scan.nextInt();
        if (cho == 1) {
            order.add(profit.profitPercentage(Ingredient.THIN_DOUGH.getCostPerUnit()));
            storage.changeIngredientQuantity(Ingredient.THIN_DOUGH, storage.getIngredientQuantity(Ingredient.THIN_DOUGH),
                    storage.getIngredientQuantity(Ingredient.THIN_DOUGH) - 1);
        } else {
            order.add(profit.profitPercentage(Ingredient.TRADITIONAL_DOUGH.getCostPerUnit()));
            storage.changeIngredientQuantity(Ingredient.TRADITIONAL_DOUGH, storage.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH),
                    storage.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH) - 1);
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

            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    order.add(profit.profitPercentage(Ingredient.CHEESE.getCostPerUnit()));
                    storage.changeIngredientQuantity(Ingredient.CHEESE, storage.getIngredientQuantity(Ingredient.CHEESE),
                            storage.getIngredientQuantity(Ingredient.CHEESE) - 1);
                    break;
                case 2:
                    order.add(profit.profitPercentage(Ingredient.MEAT.getCostPerUnit()));
                    storage.changeIngredientQuantity(Ingredient.MEAT, storage.getIngredientQuantity(Ingredient.MEAT),
                            storage.getIngredientQuantity(Ingredient.MEAT) - 1);
                    break;
                case 3:
                    order.add(profit.profitPercentage(Ingredient.SAUSAGES.getCostPerUnit()));
                    storage.changeIngredientQuantity(Ingredient.SAUSAGES, storage.getIngredientQuantity(Ingredient.SAUSAGES),
                            storage.getIngredientQuantity(Ingredient.SAUSAGES) - 1);
                    break;
                case 4:
                    order.add(profit.profitPercentage(Ingredient.OLIVES.getCostPerUnit()));
                    storage.changeIngredientQuantity(Ingredient.OLIVES, storage.getIngredientQuantity(Ingredient.OLIVES),
                            storage.getIngredientQuantity(Ingredient.OLIVES) - 1);
                    break;
                case 5:
                    order.add(profit.profitPercentage(Ingredient.TOMATOES.getCostPerUnit()));
                    storage.changeIngredientQuantity(Ingredient.TOMATOES, storage.getIngredientQuantity(Ingredient.TOMATOES),
                            storage.getIngredientQuantity(Ingredient.TOMATOES) - 1);
                    break;
                case 6:
                    order.add(profit.profitPercentage(Ingredient.PEPPER.getCostPerUnit()));
                    storage.changeIngredientQuantity(Ingredient.PEPPER, storage.getIngredientQuantity(Ingredient.PEPPER),
                            storage.getIngredientQuantity(Ingredient.PEPPER) - 1);
                    break;
                case 7:
                    order.add(profit.profitPercentage(Ingredient.OREGANO.getCostPerUnit()));
                    storage.changeIngredientQuantity(Ingredient.OREGANO, storage.getIngredientQuantity(Ingredient.OREGANO),
                            storage.getIngredientQuantity(Ingredient.OREGANO) - 1);
                    break;
                case 8:
                    order.add(profit.profitPercentage(Ingredient.SAUCE.getCostPerUnit()));
                    storage.changeIngredientQuantity(Ingredient.SAUCE, storage.getIngredientQuantity(Ingredient.SAUCE),
                            storage.getIngredientQuantity(Ingredient.SAUCE) - 1);
                    break;
                default:
                    order.add(profit.profitPercentage(Ingredient.CRUST.getCostPerUnit()));
                    break;
            }

            double totalOrder = order.totalOrder();

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