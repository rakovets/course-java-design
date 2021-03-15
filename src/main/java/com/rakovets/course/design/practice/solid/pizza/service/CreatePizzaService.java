package com.rakovets.course.design.practice.solid.pizza.service;

import com.rakovets.course.design.practice.solid.pizza.model.Ingredient;
import com.rakovets.course.design.practice.solid.pizza.repository.OrderRepository;
import com.rakovets.course.design.practice.solid.pizza.view.CreatePizzaViewConsole;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CreatePizzaService {
    private static final OrderRepository orderRepository;

    private static final CreatePizzaViewConsole createPizzaViewConsole;
    private static final Map<Integer, Ingredient> dough;
    private static final Map<Integer, Ingredient> ingredients;
    private static final CookService cook;
    public char ch;

    static {
        dough = new HashMap<>();
        dough.put(1, Ingredient.THIN_DOUGH);
        dough.put(2, Ingredient.TRADITIONAL_DOUGH);

        ingredients = new HashMap<>();
        ingredients.put(1, Ingredient.CHEESE);
        ingredients.put(2, Ingredient.MEAT);
        ingredients.put(3, Ingredient.SAUSAGES);
        ingredients.put(4, Ingredient.OLIVES);
        ingredients.put(5, Ingredient.TOMATOES);
        ingredients.put(6, Ingredient.PEPPER);
        ingredients.put(7, Ingredient.OREGANO);
        ingredients.put(8, Ingredient.SAUCE);
        ingredients.put(9, Ingredient.CRUST);

        orderRepository = new OrderRepository(new ArrayList<>());
        createPizzaViewConsole = new CreatePizzaViewConsole();
        cook = new CookService();
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
                cook.thinDough();
                break;
            case TRADITIONAL_DOUGH:
                orderRepository.add(ProfitService.profitPercentage(Ingredient.TRADITIONAL_DOUGH.getCostPerUnit()));
                cook.traditionalDough();
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
                cook.cheese();
                break;
            case MEAT:
                orderRepository.add(ProfitService.profitPercentage(Ingredient.MEAT.getCostPerUnit()));
                cook.meet();
                break;
            case SAUSAGES:
                orderRepository.add(ProfitService.profitPercentage(Ingredient.SAUSAGES.getCostPerUnit()));
                cook.sausages();
                break;
            case OLIVES:
                orderRepository.add(ProfitService.profitPercentage(Ingredient.OLIVES.getCostPerUnit()));
                cook.olives();
                break;
            case TOMATOES:
                orderRepository.add(ProfitService.profitPercentage(Ingredient.TOMATOES.getCostPerUnit()));
                cook.tomatoes();
                break;
            case PEPPER:
                orderRepository.add(ProfitService.profitPercentage(Ingredient.PEPPER.getCostPerUnit()));
                cook.pepper();
                break;
            case OREGANO:
                orderRepository.add(ProfitService.profitPercentage(Ingredient.OREGANO.getCostPerUnit()));
                cook.oregano();
                break;
            case SAUCE:
                orderRepository.add(ProfitService.profitPercentage(Ingredient.SAUCE.getCostPerUnit()));
                cook.sauce();
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