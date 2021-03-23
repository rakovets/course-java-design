package com.rakovets.course.design.practice.solid.pizza.service;

import com.rakovets.course.design.practice.solid.pizza.exceptions.*;
import com.rakovets.course.design.practice.solid.pizza.model.Check;
import com.rakovets.course.design.practice.solid.pizza.model.Ingredient;
import com.rakovets.course.design.practice.solid.pizza.model.PaymentMethod;
import com.rakovets.course.design.practice.solid.pizza.repository.IngredientCaloriesRepository;
import com.rakovets.course.design.practice.solid.pizza.repository.OrderRepository;
import com.rakovets.course.design.practice.solid.pizza.view.CashPaymentViewConsole;
import com.rakovets.course.design.practice.solid.pizza.view.CheckViewConsole;
import com.rakovets.course.design.practice.solid.pizza.view.CreatePizzaViewConsole;

import java.util.*;

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
    private static final IngredientCaloriesRepository ingredientCaloriesRepository;
    private static final Map<Integer, PaymentMethod> paymentMethod;
    private static final Scanner scanner;
    public int enteredInt;
    public int doughMenu;
    public int ingredientMenu;
    public int payment;

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
        ingredientCaloriesRepository = new IngredientCaloriesRepository(new ArrayList<>());
        scanner = new Scanner(System.in);

        paymentMethod = new HashMap<>();
        paymentMethod.put(1, PaymentMethod.CASH);
        paymentMethod.put(2, PaymentMethod.CARD);
        paymentMethod.put(3, PaymentMethod.ONLINE);
    }

    public void start() {
        createPizzaViewConsole.greeting();
    }

    public void chooseDough() {
        createPizzaViewConsole.menuDough();
        try {
            doughMenu = checkInt();
            switch (dough.get(doughMenu)) {
                case THIN_DOUGH:
                    orderRepository.add(ingredientPrice.priceThinDoughIncludingVAT());
                    createPizzaViewConsole.displayCaloriesThinDough();
                    ingredientCaloriesRepository.add(Ingredient.THIN_DOUGH.getCalories());
                    cook.thinDough();
                    check.add(createPizzaViewConsole.orderThinDough());
                    break;
                case TRADITIONAL_DOUGH:
                    orderRepository.add(ingredientPrice.priceTraditionalDoughIncludingVAT());
                    createPizzaViewConsole.displayCaloriesTraditionalDough();
                    ingredientCaloriesRepository.add(Ingredient.TRADITIONAL_DOUGH.getCalories());
                    cook.traditionalDough();
                    check.add(createPizzaViewConsole.orderTraditionalDough());
                    break;
            }
        } catch (NullPointerException e) {
            try {
                throw new DoughException();
            } catch (DoughException ex) {
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
        try {
            ingredientMenu = checkInt();
            switch (ingredients.get(ingredientMenu)) {
                case CHEESE:
                    orderRepository.add(ingredientPrice.priceCheeseIncludingVAT());
                    createPizzaViewConsole.displayCaloriesCheese();
                    ingredientCaloriesRepository.add(Ingredient.CHEESE.getCalories());
                    cook.cheese();
                    check.add(createPizzaViewConsole.orderCheese());
                    break;
                case MEAT:
                    orderRepository.add(ingredientPrice.priceMeatIncludingVAT());
                    createPizzaViewConsole.displayCaloriesMeat();
                    ingredientCaloriesRepository.add(Ingredient.MEAT.getCalories());
                    cook.meat();
                    check.add(createPizzaViewConsole.orderMeat());
                    break;
                case SAUSAGES:
                    orderRepository.add(ingredientPrice.priceSausagesIncludingVAT());
                    createPizzaViewConsole.displayCaloriesSausages();
                    ingredientCaloriesRepository.add(Ingredient.SAUSAGES.getCalories());
                    cook.sausages();
                    check.add(createPizzaViewConsole.orderSausages());
                    break;
                case OLIVES:
                    orderRepository.add(ingredientPrice.priceOlivesIncludingVAT());
                    createPizzaViewConsole.displayCaloriesOlives();
                    ingredientCaloriesRepository.add(Ingredient.OLIVES.getCalories());
                    cook.olives();
                    check.add(createPizzaViewConsole.orderOlives());
                    break;
                case TOMATOES:
                    orderRepository.add(ingredientPrice.priceTomatoesIncludingVAT());
                    createPizzaViewConsole.displayCaloriesTomatoes();
                    ingredientCaloriesRepository.add(Ingredient.TOMATOES.getCalories());
                    cook.tomatoes();
                    check.add(createPizzaViewConsole.orderTomatoes());
                    break;
                case PEPPER:
                    orderRepository.add(ingredientPrice.pricePepperIncludingVAT());
                    createPizzaViewConsole.displayCaloriesPepper();
                    ingredientCaloriesRepository.add(Ingredient.PEPPER.getCalories());
                    cook.pepper();
                    check.add(createPizzaViewConsole.orderPepper());
                    break;
                case OREGANO:
                    orderRepository.add(ingredientPrice.priceOreganoIncludingVAT());
                    createPizzaViewConsole.displayCaloriesOregano();
                    ingredientCaloriesRepository.add(Ingredient.OREGANO.getCalories());
                    cook.oregano();
                    check.add(createPizzaViewConsole.orderOregano());
                    break;
                case SAUCE:
                    orderRepository.add(ingredientPrice.priceSauceIncludingVAT());
                    createPizzaViewConsole.displayCaloriesSauce();
                    ingredientCaloriesRepository.add(Ingredient.SAUCE.getCalories());
                    cook.sauce();
                    check.add(createPizzaViewConsole.orderSauce());
                    break;
                case CRUST:
                    orderRepository.add(ingredientPrice.priceCrustIncludingVAT());
                    createPizzaViewConsole.displayCaloriesCrust();
                    ingredientCaloriesRepository.add(Ingredient.CRUST.getCalories());
                    check.add(createPizzaViewConsole.orderCrust());
                    break;
            }
        } catch (NullPointerException e) {
            try {
                throw new IngredientNumberException();
            } catch (IngredientNumberException ex) {
                ex.printStackTrace();
            }
        }
        totalOrder();
        createPizzaViewConsole.totalCalories(ingredientCaloriesRepository.countTotalCalories());
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
        try {
            payment = checkInt();
            switch (paymentMethod.get(payment)) {
                case CASH:
                    checkViewConsole.displayCheckCreatePizza();
                    displayTotalOrder();
                    cashPaymentService.getFullAmount();
                    cashPaymentServiceViewConsole.getChangeCreatePizza();
                    break;
                case CARD:
                    checkViewConsole.displayCheckCreatePizza();
                    displayTotalOrder();
                    cardPaymentService.enterPIN();
                    break;
                case ONLINE:
                    checkViewConsole.displayCheckCreatePizza();
                    displayTotalOrder();
                    onlinePaymentService.addCustomer();
                    break;
            }
        } catch (NullPointerException e) {
            try {
                throw new PaymentChoiceException();
            } catch (PaymentChoiceException ex) {
                ex.printStackTrace();
                paymentChoice();
            }
        }
    }

    public int checkInt() {
        do {
            while (!scanner.hasNextInt()) {
                createPizzaViewConsole.invalidInput();
                scanner.next();
            }
            enteredInt = scanner.nextInt();
        } while (enteredInt <= 0);
        return enteredInt;
    }
}
