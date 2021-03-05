package com.rakovets.course.design.practice.solid.pizza.controller;

import com.rakovets.course.design.practice.solid.pizza.model.Ingredient;
import com.rakovets.course.design.practice.solid.pizza.repository.OrderRepository;
import com.rakovets.course.design.practice.solid.pizza.repository.StorageRepository;
import com.rakovets.course.design.practice.solid.pizza.service.*;
import com.rakovets.course.design.practice.solid.pizza.view.CreatePizzaViewConsole;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CreatePizzaController {
    private final OrderRepository orderRepository = new OrderRepository(new ArrayList<>());
    private final StorageRepository storage = new StorageRepository();
    private final CreatePizzaViewConsole createPizzaViewConsole = new CreatePizzaViewConsole();
    private static final Map<Integer, Ingredient> dough = new HashMap<>();
    private static final Map<Integer, Ingredient> ingredients = new HashMap<>();
    public char ch;

    static {

        dough.put(1, Ingredient.THIN_DOUGH);
        dough.put(2, Ingredient.TRADITIONAL_DOUGH);

        ingredients.put(1, Ingredient.CHEESE);
        ingredients.put(2, Ingredient.MEAT);
        ingredients.put(3, Ingredient.SAUSAGES);
        ingredients.put(4, Ingredient.OLIVES);
        ingredients.put(5, Ingredient.TOMATOES);
        ingredients.put(6, Ingredient.PEPPER);
        ingredients.put(7, Ingredient.OREGANO);
        ingredients.put(8, Ingredient.SAUCE);
        ingredients.put(9, Ingredient.CRUST);

    }

    public void start() {
        createPizzaViewConsole.greeting();
    }

    public void chooseDough() {
        createPizzaViewConsole.menuDough();
        Scanner scan = new Scanner(System.in);
        int cho = scan.nextInt();
        switch (dough.get(cho)) {
            case THIN_DOUGH:
                orderRepository.add(ProfitService.profitPercentage(Ingredient.THIN_DOUGH.getCostPerUnit()));
                storage.changeIngredientQuantity(Ingredient.THIN_DOUGH,
                        storage.getIngredientQuantity(Ingredient.THIN_DOUGH) - 1);
                break;
            case TRADITIONAL_DOUGH:
                orderRepository.add(ProfitService.profitPercentage(Ingredient.TRADITIONAL_DOUGH.getCostPerUnit()));
                storage.changeIngredientQuantity(Ingredient.TRADITIONAL_DOUGH,
                        storage.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH) - 1);
                break;
        }
    }

    public void chooseIngredients() {
        createPizzaViewConsole.menuIngredients();
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        switch (ingredients.get(choice)) {
            case CHEESE:
                orderRepository.add(ProfitService.profitPercentage(Ingredient.CHEESE.getCostPerUnit()));
                storage.changeIngredientQuantity(Ingredient.CHEESE,
                        storage.getIngredientQuantity(Ingredient.CHEESE) - 1);
                break;
            case MEAT:
                orderRepository.add(ProfitService.profitPercentage(Ingredient.MEAT.getCostPerUnit()));
                storage.changeIngredientQuantity(Ingredient.MEAT,
                        storage.getIngredientQuantity(Ingredient.MEAT) - 1);
                break;
            case SAUSAGES:
                orderRepository.add(ProfitService.profitPercentage(Ingredient.SAUSAGES.getCostPerUnit()));
                storage.changeIngredientQuantity(Ingredient.SAUSAGES,
                        storage.getIngredientQuantity(Ingredient.SAUSAGES) - 1);
                break;
            case OLIVES:
                orderRepository.add(ProfitService.profitPercentage(Ingredient.OLIVES.getCostPerUnit()));
                storage.changeIngredientQuantity(Ingredient.OLIVES,
                        storage.getIngredientQuantity(Ingredient.OLIVES) - 1);
                break;
            case TOMATOES:
                orderRepository.add(ProfitService.profitPercentage(Ingredient.TOMATOES.getCostPerUnit()));
                storage.changeIngredientQuantity(Ingredient.TOMATOES,
                        storage.getIngredientQuantity(Ingredient.TOMATOES) - 1);
                break;
            case PEPPER:
                orderRepository.add(ProfitService.profitPercentage(Ingredient.PEPPER.getCostPerUnit()));
                storage.changeIngredientQuantity(Ingredient.PEPPER,
                        storage.getIngredientQuantity(Ingredient.PEPPER) - 1);
                break;
            case OREGANO:
                orderRepository.add(ProfitService.profitPercentage(Ingredient.OREGANO.getCostPerUnit()));
                storage.changeIngredientQuantity(Ingredient.OREGANO,
                        storage.getIngredientQuantity(Ingredient.OREGANO) - 1);
                break;
            case SAUCE:
                orderRepository.add(ProfitService.profitPercentage(Ingredient.SAUCE.getCostPerUnit()));
                storage.changeIngredientQuantity(Ingredient.SAUCE,
                        storage.getIngredientQuantity(Ingredient.SAUCE) - 1);
                break;
            case CRUST:
                orderRepository.add(ProfitService.profitPercentage(Ingredient.CRUST.getCostPerUnit()));
                break;
        }
        totalOrder();
    }

    public void totalOrder() {
        double totalOrder = RoundUpService.roundUp(orderRepository.totalOrder());
        createPizzaViewConsole.totalOrder(totalOrder);
    }

    public void addIngredientsQuestion() {
        createPizzaViewConsole.addIngredientsQuestion();
        Scanner scan = new Scanner(System.in);
        ch = scan.next().charAt(0);
        if (ch == 'Y' || ch == 'y') {
            chooseIngredients();
            addIngredientsQuestion();
        } else {
            paymentChoice();
        }
    }

    public void paymentChoice() {
        createPizzaViewConsole.paymentChoice();
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    createPizzaViewConsole.cashPayment();
                    break;
                case 2:
                    createPizzaViewConsole.cardPayment();
                    break;
                default:
                    createPizzaViewConsole.onlinePayment();
                    break;
        }
    }
}