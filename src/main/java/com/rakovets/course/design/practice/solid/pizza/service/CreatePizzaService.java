package com.rakovets.course.design.practice.solid.pizza.service;

import com.rakovets.course.design.practice.solid.pizza.exceptions.UserInputException;
import com.rakovets.course.design.practice.solid.pizza.model.Check;
import com.rakovets.course.design.practice.solid.pizza.model.Ingredient;
import com.rakovets.course.design.practice.solid.pizza.repository.OrderRepository;
import com.rakovets.course.design.practice.solid.pizza.view.CashPaymentViewConsole;
import com.rakovets.course.design.practice.solid.pizza.view.CheckViewConsole;
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
    private static final CashPaymentService cashPaymentService;
    private static final CashPaymentViewConsole cashPaymentServiceViewConsole;
    public static final Check check;
    private static final CheckViewConsole checkViewConsole;
    private static final OnlinePaymentService onlinePaymentService;
    private static final CardPaymentService cardPaymentService;

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
        cashPaymentService = new CashPaymentService();
        cashPaymentServiceViewConsole = new CashPaymentViewConsole();
        check = new Check(new ArrayList<>());
        checkViewConsole = new CheckViewConsole();
        onlinePaymentService = new OnlinePaymentService();
        cardPaymentService = new CardPaymentService();
    }

    public void start() {
        createPizzaViewConsole.greeting();
    }

    public void chooseDough() {
        createPizzaViewConsole.menuDough();
        Scanner scan = new Scanner(System.in);
        int cho = scan.nextInt();
        try {
            switch (dough.get(cho)) {
                case THIN_DOUGH:
                    orderRepository.add(ingredientPrice.priceThinDoughIncludingVAT());
                    cook.thinDough();
                    check.add(createPizzaViewConsole.orderThinDough());
                    break;
                case TRADITIONAL_DOUGH:
                    orderRepository.add(ingredientPrice.priceTraditionalDoughIncludingVAT());
                    cook.traditionalDough();
                    check.add(createPizzaViewConsole.orderTraditionalDough());
                    break;
            }
        } catch (NullPointerException e) {
            try {
                throw new UserInputException(cho);
            } catch (UserInputException ex) {
                ex.printStackTrace();
                addDoughQuestion();
            }
        }
    }

    public void addDoughQuestion() {
        createPizzaViewConsole.addDoughQuestion();
        Scanner scan = new Scanner(System.in);
        ch = scan.next().charAt(0);
        if (ch == 'Y' || ch == 'y') {
            chooseDough();
        } else {
            chooseIngredients();
        }
    }

    public void chooseIngredients() {
        createPizzaViewConsole.menuIngredients();
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        try {
            switch (ingredients.get(choice)) {
                case CHEESE:
                    orderRepository.add(ingredientPrice.priceCheeseIncludingVAT());
                    cook.cheese();
                    check.add(createPizzaViewConsole.orderCheese());
                    break;
                case MEAT:
                    orderRepository.add(ingredientPrice.priceMeatIncludingVAT());
                    cook.meat();
                    check.add(createPizzaViewConsole.orderMeat());
                    break;
                case SAUSAGES:
                    orderRepository.add(ingredientPrice.priceSausagesIncludingVAT());
                    cook.sausages();
                    check.add(createPizzaViewConsole.orderSausages());
                    break;
                case OLIVES:
                    orderRepository.add(ingredientPrice.priceOlivesIncludingVAT());
                    cook.olives();
                    check.add(createPizzaViewConsole.orderOlives());
                    break;
                case TOMATOES:
                    orderRepository.add(ingredientPrice.priceTomatoesIncludingVAT());
                    cook.tomatoes();
                    check.add(createPizzaViewConsole.orderTomatoes());
                    break;
                case PEPPER:
                    orderRepository.add(ingredientPrice.pricePepperIncludingVAT());
                    cook.pepper();
                    check.add(createPizzaViewConsole.orderPepper());
                    break;
                case OREGANO:
                    orderRepository.add(ingredientPrice.priceOreganoIncludingVAT());
                    cook.oregano();
                    check.add(createPizzaViewConsole.orderOregano());
                    break;
                case SAUCE:
                    orderRepository.add(ingredientPrice.priceSauceIncludingVAT());
                    cook.sauce();
                    check.add(createPizzaViewConsole.orderSauce());
                    break;
                case CRUST:
                    orderRepository.add(ingredientPrice.priceCrustIncludingVAT());
                    check.add(createPizzaViewConsole.orderCrust());
                    break;
            }
            totalOrder();
        } catch (NullPointerException e) {
            try {
                throw new UserInputException(choice);
            } catch (UserInputException ex) {
                ex.printStackTrace();
            }
        }
    }

    public double totalOrder() {
        return RoundUpService.roundUp(orderRepository.totalOrder());
    }

    public void displayTotalOrder() {
        double totalOrder = RoundUpService.roundUp(orderRepository.totalOrder());
        createPizzaViewConsole.totalOrder(totalOrder);
    }

    public double getChange() {
        return cashPaymentService.countChange(totalOrder());
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
                checkViewConsole.displayCheckCreatePizza();
                displayTotalOrder();
                cashPaymentService.getFullAmount();
                cashPaymentServiceViewConsole.getChangeCreatePizza();
                break;
            case 2:
                checkViewConsole.displayCheckCreatePizza();
                displayTotalOrder();
                cardPaymentService.enterPIN();
                break;
            default:
                checkViewConsole.displayCheckCreatePizza();
                displayTotalOrder();
                onlinePaymentService.addCustomer();
                break;
        }
    }
}
