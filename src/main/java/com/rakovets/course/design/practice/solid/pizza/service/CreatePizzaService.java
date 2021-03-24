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
    private static final CreatePizzaViewConsole createPizzaView;
    private static final Map<Integer, Ingredient> dough;
    private static final Map<Integer, Ingredient> ingredients;
    private static final CookService cook;
    public char ch;
    private static final IngredientPriceService ingredientPrice;
    private static final CashPaymentService cashPaymentService;
    private static final CashPaymentViewConsole cashPaymentServiceView;
    public static final Check check;
    private static final CheckViewConsole checkView;
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
        createPizzaView = new CreatePizzaViewConsole();
        cook = new CookService();
        ingredientPrice = new IngredientPriceService();
        cashPaymentService = new CashPaymentService();
        cashPaymentServiceView = new CashPaymentViewConsole();
        check = new Check(new ArrayList<>());
        checkView = new CheckViewConsole();
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
        createPizzaView.greeting();
    }

    public void chooseDough() {
        createPizzaView.menuDough();
        try {
            doughMenu = checkInt();
            switch (dough.get(doughMenu)) {
                case THIN_DOUGH:
                    orderRepository.add(ingredientPrice.priceThinDoughIncludingVAT());
                    createPizzaView.displayCaloriesThinDough();
                    ingredientCaloriesRepository.add(Ingredient.THIN_DOUGH.getCalories());
                    cook.thinDough();
                    check.add(createPizzaView.orderThinDough());
                    break;
                case TRADITIONAL_DOUGH:
                    orderRepository.add(ingredientPrice.priceTraditionalDoughIncludingVAT());
                    createPizzaView.displayCaloriesTraditionalDough();
                    ingredientCaloriesRepository.add(Ingredient.TRADITIONAL_DOUGH.getCalories());
                    cook.traditionalDough();
                    check.add(createPizzaView.orderTraditionalDough());
                    break;
            }
        } catch (NullPointerException e) {
            try {
                throw new DoughException();
            } catch (DoughException ex) {
                createPizzaView.doughException();
                addDoughQuestion();
            }
        }
    }

    public void addDoughQuestion() {
        createPizzaView.addDoughQuestion();
        Scanner scan = new Scanner(System.in);
        ch = scan.next().charAt(0);
        if (ch == 'Y' || ch == 'y') {
            chooseDough();
        } else {
            chooseIngredients();
        }
    }

    public void chooseIngredients() {
        createPizzaView.menuIngredients();
        try {
            ingredientMenu = checkInt();
            switch (ingredients.get(ingredientMenu)) {
                case CHEESE:
                    orderRepository.add(ingredientPrice.priceCheeseIncludingVAT());
                    createPizzaView.displayCaloriesCheese();
                    ingredientCaloriesRepository.add(Ingredient.CHEESE.getCalories());
                    cook.cheese();
                    check.add(createPizzaView.orderCheese());
                    break;
                case MEAT:
                    orderRepository.add(ingredientPrice.priceMeatIncludingVAT());
                    createPizzaView.displayCaloriesMeat();
                    ingredientCaloriesRepository.add(Ingredient.MEAT.getCalories());
                    cook.meat();
                    check.add(createPizzaView.orderMeat());
                    break;
                case SAUSAGES:
                    orderRepository.add(ingredientPrice.priceSausagesIncludingVAT());
                    createPizzaView.displayCaloriesSausages();
                    ingredientCaloriesRepository.add(Ingredient.SAUSAGES.getCalories());
                    cook.sausages();
                    check.add(createPizzaView.orderSausages());
                    break;
                case OLIVES:
                    orderRepository.add(ingredientPrice.priceOlivesIncludingVAT());
                    createPizzaView.displayCaloriesOlives();
                    ingredientCaloriesRepository.add(Ingredient.OLIVES.getCalories());
                    cook.olives();
                    check.add(createPizzaView.orderOlives());
                    break;
                case TOMATOES:
                    orderRepository.add(ingredientPrice.priceTomatoesIncludingVAT());
                    createPizzaView.displayCaloriesTomatoes();
                    ingredientCaloriesRepository.add(Ingredient.TOMATOES.getCalories());
                    cook.tomatoes();
                    check.add(createPizzaView.orderTomatoes());
                    break;
                case PEPPER:
                    orderRepository.add(ingredientPrice.pricePepperIncludingVAT());
                    createPizzaView.displayCaloriesPepper();
                    ingredientCaloriesRepository.add(Ingredient.PEPPER.getCalories());
                    cook.pepper();
                    check.add(createPizzaView.orderPepper());
                    break;
                case OREGANO:
                    orderRepository.add(ingredientPrice.priceOreganoIncludingVAT());
                    createPizzaView.displayCaloriesOregano();
                    ingredientCaloriesRepository.add(Ingredient.OREGANO.getCalories());
                    cook.oregano();
                    check.add(createPizzaView.orderOregano());
                    break;
                case SAUCE:
                    orderRepository.add(ingredientPrice.priceSauceIncludingVAT());
                    createPizzaView.displayCaloriesSauce();
                    ingredientCaloriesRepository.add(Ingredient.SAUCE.getCalories());
                    cook.sauce();
                    check.add(createPizzaView.orderSauce());
                    break;
                case CRUST:
                    orderRepository.add(ingredientPrice.priceCrustIncludingVAT());
                    createPizzaView.displayCaloriesCrust();
                    ingredientCaloriesRepository.add(Ingredient.CRUST.getCalories());
                    check.add(createPizzaView.orderCrust());
                    break;
            }
        } catch (NullPointerException e) {
            try {
                throw new IngredientNumberException();
            } catch (IngredientNumberException ex) {
                createPizzaView.ingredientNumberException();
            }
        }
        totalOrder();
        createPizzaView.totalCalories(ingredientCaloriesRepository.countTotalCalories());
    }

    public double totalOrder() {
        return RoundUpService.roundUp(orderRepository.totalOrder());
    }

    public void displayTotalOrder() {
        double totalOrder = RoundUpService.roundUp(orderRepository.totalOrder());
        createPizzaView.totalOrder(totalOrder);
    }

    public double getChange() {
        return cashPaymentService.countChange(totalOrder());
    }

    public void addIngredientsQuestion() {
        createPizzaView.addIngredientsQuestion();
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
        createPizzaView.paymentChoice();
        try {
            payment = checkInt();
            switch (paymentMethod.get(payment)) {
                case CASH:
                    checkView.displayCheckCreatePizza();
                    displayTotalOrder();
                    cashPaymentService.getFullAmount();
                    cashPaymentServiceView.getChangeCreatePizza();
                    break;
                case CARD:
                    checkView.displayCheckCreatePizza();
                    displayTotalOrder();
                    cardPaymentService.enterPIN();
                    break;
                case ONLINE:
                    checkView.displayCheckCreatePizza();
                    displayTotalOrder();
                    onlinePaymentService.addCustomer();
                    break;
            }
        } catch (NullPointerException e) {
            try {
                throw new PaymentChoiceException();
            } catch (PaymentChoiceException ex) {
                createPizzaView.paymentChoiceException();
                paymentChoice();
            }
        }
    }

    public int checkInt() {
        do {
            while (!scanner.hasNextInt()) {
                createPizzaView.invalidInput();
                scanner.next();
            }
            enteredInt = scanner.nextInt();
        } while (enteredInt <= 0);
        return enteredInt;
    }
}
