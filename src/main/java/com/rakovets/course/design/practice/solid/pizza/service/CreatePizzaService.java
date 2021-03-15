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
    private static final IngredientPriceService ingredientPrice;

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
        ingredientPrice = new IngredientPriceService();
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
                orderRepository.add(ingredientPrice.priceThinDoughIncludingVAT());
                cook.thinDough();
                break;
            case TRADITIONAL_DOUGH:
                orderRepository.add(ingredientPrice.priceTraditionalDoughIncludingVAT());
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
                orderRepository.add(ingredientPrice.priceCheeseIncludingVAT());
                cook.cheese();
                break;
            case MEAT:
                orderRepository.add(ingredientPrice.priceMeatIncludingVAT());
                cook.meat();
                break;
            case SAUSAGES:
                orderRepository.add(ingredientPrice.priceSausagesIncludingVAT());
                cook.sausages();
                break;
            case OLIVES:
                orderRepository.add(ingredientPrice.priceOlivesIncludingVAT());
                cook.olives();
                break;
            case TOMATOES:
                orderRepository.add(ingredientPrice.priceTomatoesIncludingVAT());
                cook.tomatoes();
                break;
            case PEPPER:
                orderRepository.add(ingredientPrice.pricePepperIncludingVAT());
                cook.pepper();
                break;
            case OREGANO:
                orderRepository.add(ingredientPrice.priceOreganoIncludingVAT());
                cook.oregano();
                break;
            case SAUCE:
                orderRepository.add(ingredientPrice.priceSauceIncludingVAT());
                cook.sauce();
                break;
            case CRUST:
                orderRepository.add(ingredientPrice.priceCrustIncludingVAT());
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