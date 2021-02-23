package com.rakovets.course.design.practice.solid.Pizza.Order;

import com.rakovets.course.design.practice.solid.Pizza.Finance.CardPayment;
import com.rakovets.course.design.practice.solid.Pizza.Finance.CashPayment;
import com.rakovets.course.design.practice.solid.Pizza.Finance.OnlinePayment;
import com.rakovets.course.design.practice.solid.Pizza.Finance.Profit;
import com.rakovets.course.design.practice.solid.Pizza.Ingredients.*;

import java.util.ArrayList;
import java.util.Scanner;

public class CreatePizza {

    public static void main(String[] args) {

        Order order = new Order(new ArrayList<>());
        ThinDough thinDough = new ThinDough();
        TraditionalDough traditionalDough = new TraditionalDough();
        Cheese cheese = new Cheese();
        Meat meat = new Meat();
        Sausages sausages = new Sausages();
        Olives olives = new Olives();
        Tomatoes tomatoes = new Tomatoes();
        Pepper pepper = new Pepper();
        Oregano oregano = new Oregano();
        Sauce sauce = new Sauce();
        Crust crust = new Crust();
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
            order.add(profit.profitPercentage(thinDough.getPrice()));
            storage.changeIngredientQuantity(thinDough, storage.getIngredientQuantity(thinDough),
                    storage.getIngredientQuantity(thinDough) - 1);
        } else {
            order.add(profit.profitPercentage(traditionalDough.getPrice()));
            storage.changeIngredientQuantity(traditionalDough, storage.getIngredientQuantity(traditionalDough),
                    storage.getIngredientQuantity(traditionalDough) - 1);
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
                    order.add(profit.profitPercentage(cheese.getPrice()));
                    storage.changeIngredientQuantity(cheese, storage.getIngredientQuantity(cheese),
                            storage.getIngredientQuantity(cheese) - 1);
                    break;
                case 2:
                    order.add(profit.profitPercentage(meat.getPrice()));
                    storage.changeIngredientQuantity(meat, storage.getIngredientQuantity(meat),
                            storage.getIngredientQuantity(meat) - 1);
                    break;
                case 3:
                    order.add(profit.profitPercentage(sausages.getPrice()));
                    storage.changeIngredientQuantity(sausages, storage.getIngredientQuantity(sausages),
                            storage.getIngredientQuantity(sausages) - 1);
                    break;
                case 4:
                    order.add(profit.profitPercentage(olives.getPrice()));
                    storage.changeIngredientQuantity(olives, storage.getIngredientQuantity(olives),
                            storage.getIngredientQuantity(olives) - 1);
                    break;
                case 5:
                    order.add(profit.profitPercentage(tomatoes.getPrice()));
                    storage.changeIngredientQuantity(tomatoes, storage.getIngredientQuantity(tomatoes),
                            storage.getIngredientQuantity(tomatoes) - 1);
                    break;
                case 6:
                    order.add(profit.profitPercentage(pepper.getPrice()));
                    storage.changeIngredientQuantity(pepper, storage.getIngredientQuantity(pepper),
                            storage.getIngredientQuantity(pepper) - 1);
                    break;
                case 7:
                    order.add(profit.profitPercentage(oregano.getPrice()));
                    storage.changeIngredientQuantity(oregano, storage.getIngredientQuantity(oregano),
                            storage.getIngredientQuantity(oregano) - 1);
                    break;
                case 8:
                    order.add(profit.profitPercentage(sauce.getPrice()));
                    storage.changeIngredientQuantity(sauce, storage.getIngredientQuantity(sauce),
                            storage.getIngredientQuantity(sauce) - 1);
                    break;
                default:
                    order.add(profit.profitPercentage(crust.getPrice()));
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