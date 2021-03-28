package com.rakovets.course.design.practice.solid.pizza.service;

import com.rakovets.course.design.practice.solid.pizza.exceptions.DoughException;
import com.rakovets.course.design.practice.solid.pizza.exceptions.IngredientNumberException;
import com.rakovets.course.design.practice.solid.pizza.exceptions.PaymentChoiceException;
import com.rakovets.course.design.practice.solid.pizza.model.Check;
import com.rakovets.course.design.practice.solid.pizza.model.Ingredient;
import com.rakovets.course.design.practice.solid.pizza.model.PaymentMethod;
import com.rakovets.course.design.practice.solid.pizza.repository.IngredientCaloriesRepository;
import com.rakovets.course.design.practice.solid.pizza.repository.OrderRepository;
import com.rakovets.course.design.practice.solid.pizza.util.CheckIntUtil;
import com.rakovets.course.design.practice.solid.pizza.util.RoundUtil;
import com.rakovets.course.design.practice.solid.pizza.view.CashPaymentViewConsole;
import com.rakovets.course.design.practice.solid.pizza.view.CheckViewConsole;
import com.rakovets.course.design.practice.solid.pizza.view.CreatePizzaViewConsole;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CreatePizzaService {
    private static final CreatePizzaViewConsole CREATE_PIZZA_VIEW;
    private static final Map<Integer, Ingredient> DOUGH;
    private static final Map<Integer, Ingredient> INGREDIENTS;
    private static final IngredientPriceService INGREDIENT_PRICE;
    private static final IngredientCaloriesRepository INGREDIENT_CALORIES;
    private static final CookService COOK;
    private static final OrderRepository ORDER;
    private static final CashPaymentService CASH_PAYMENT;
    private static final CashPaymentViewConsole CASH_PAYMENT_VIEW;
    public static final Check CHECK;
    private static final CheckViewConsole CHECK_VIEW;
    private static final OnlinePaymentService ONLINE_PAYMENT;
    private static final CardPaymentService CARD_PAYMENT;
    private static final Map<Integer, PaymentMethod> PAYMENT_METHOD;
    public int payment;
    public char ch;
    public int choice;
    private static final CheckIntUtil CHECK_INT;

    static {
        DOUGH = new HashMap<>();
        DOUGH.put(1, Ingredient.THIN_DOUGH);
        DOUGH.put(2, Ingredient.TRADITIONAL_DOUGH);

        INGREDIENTS = new HashMap<>();
        INGREDIENTS.put(1, Ingredient.CHEESE);
        INGREDIENTS.put(2, Ingredient.MEAT);
        INGREDIENTS.put(3, Ingredient.SAUSAGES);
        INGREDIENTS.put(4, Ingredient.OLIVES);
        INGREDIENTS.put(5, Ingredient.TOMATOES);
        INGREDIENTS.put(6, Ingredient.PEPPER);
        INGREDIENTS.put(7, Ingredient.OREGANO);
        INGREDIENTS.put(8, Ingredient.SAUCE);
        INGREDIENTS.put(9, Ingredient.CRUST);

        CREATE_PIZZA_VIEW = new CreatePizzaViewConsole();
        INGREDIENT_PRICE = new IngredientPriceService();
        INGREDIENT_CALORIES = new IngredientCaloriesRepository(new ArrayList<>());
        COOK = new CookService();
        CASH_PAYMENT = new CashPaymentService();
        CASH_PAYMENT_VIEW = new CashPaymentViewConsole();
        CHECK = new Check(new ArrayList<>());
        CHECK_VIEW = new CheckViewConsole();
        ONLINE_PAYMENT = new OnlinePaymentService();
        CARD_PAYMENT = new CardPaymentService();
        ORDER = new OrderRepository(new ArrayList<>());
        CHECK_INT = new CheckIntUtil();

        PAYMENT_METHOD = new HashMap<>();
        PAYMENT_METHOD.put(1, PaymentMethod.CASH);
        PAYMENT_METHOD.put(2, PaymentMethod.CARD);
        PAYMENT_METHOD.put(3, PaymentMethod.ONLINE);
    }

    public void start() {
        CREATE_PIZZA_VIEW.greeting();
    }

    public void chooseDough() {
        CREATE_PIZZA_VIEW.menuDough();
        try {
            choice = CHECK_INT.checkInt();
            switch (DOUGH.get(choice)) {
                case THIN_DOUGH:
                    ORDER.add(INGREDIENT_PRICE.priceThinDoughIncludingVAT());
                    CREATE_PIZZA_VIEW.displayCaloriesThinDough();
                    INGREDIENT_CALORIES.add(Ingredient.THIN_DOUGH.getCalories());
                    COOK.thinDough();
                    CHECK.add(CREATE_PIZZA_VIEW.orderThinDough());
                    break;
                case TRADITIONAL_DOUGH:
                    ORDER.add(INGREDIENT_PRICE.priceTraditionalDoughIncludingVAT());
                    CREATE_PIZZA_VIEW.displayCaloriesTraditionalDough();
                    INGREDIENT_CALORIES.add(Ingredient.TRADITIONAL_DOUGH.getCalories());
                    COOK.traditionalDough();
                    CHECK.add(CREATE_PIZZA_VIEW.orderTraditionalDough());
                    break;
            }
        } catch (NullPointerException e) {
            try {
                throw new DoughException();
            } catch (DoughException ex) {
                CREATE_PIZZA_VIEW.doughException();
                addDoughQuestion();
            }
        }
    }

    public void addDoughQuestion() {
        CREATE_PIZZA_VIEW.addDoughQuestion();
        Scanner scan = new Scanner(System.in);
        ch = scan.next().charAt(0);
        if (ch == 'Y' || ch == 'y') {
            chooseDough();
        } else {
            chooseIngredients();
        }
    }

    public void chooseIngredients() {
        CREATE_PIZZA_VIEW.menuIngredients();
        try {
            choice = CHECK_INT.checkInt();
            switch (INGREDIENTS.get(choice)) {
                case CHEESE:
                    ORDER.add(INGREDIENT_PRICE.priceCheeseIncludingVAT());
                    CREATE_PIZZA_VIEW.displayCaloriesCheese();
                    INGREDIENT_CALORIES.add(Ingredient.CHEESE.getCalories());
                    COOK.cheese();
                    CHECK.add(CREATE_PIZZA_VIEW.orderCheese());
                    break;
                case MEAT:
                    ORDER.add(INGREDIENT_PRICE.priceMeatIncludingVAT());
                    CREATE_PIZZA_VIEW.displayCaloriesMeat();
                    INGREDIENT_CALORIES.add(Ingredient.MEAT.getCalories());
                    COOK.meat();
                    CHECK.add(CREATE_PIZZA_VIEW.orderMeat());
                    break;
                case SAUSAGES:
                    ORDER.add(INGREDIENT_PRICE.priceSausagesIncludingVAT());
                    CREATE_PIZZA_VIEW.displayCaloriesSausages();
                    INGREDIENT_CALORIES.add(Ingredient.SAUSAGES.getCalories());
                    COOK.sausages();
                    CHECK.add(CREATE_PIZZA_VIEW.orderSausages());
                    break;
                case OLIVES:
                    ORDER.add(INGREDIENT_PRICE.priceOlivesIncludingVAT());
                    CREATE_PIZZA_VIEW.displayCaloriesOlives();
                    INGREDIENT_CALORIES.add(Ingredient.OLIVES.getCalories());
                    COOK.olives();
                    CHECK.add(CREATE_PIZZA_VIEW.orderOlives());
                    break;
                case TOMATOES:
                    ORDER.add(INGREDIENT_PRICE.priceTomatoesIncludingVAT());
                    CREATE_PIZZA_VIEW.displayCaloriesTomatoes();
                    INGREDIENT_CALORIES.add(Ingredient.TOMATOES.getCalories());
                    COOK.tomatoes();
                    CHECK.add(CREATE_PIZZA_VIEW.orderTomatoes());
                    break;
                case PEPPER:
                    ORDER.add(INGREDIENT_PRICE.pricePepperIncludingVAT());
                    CREATE_PIZZA_VIEW.displayCaloriesPepper();
                    INGREDIENT_CALORIES.add(Ingredient.PEPPER.getCalories());
                    COOK.pepper();
                    CHECK.add(CREATE_PIZZA_VIEW.orderPepper());
                    break;
                case OREGANO:
                    ORDER.add(INGREDIENT_PRICE.priceOreganoIncludingVAT());
                    CREATE_PIZZA_VIEW.displayCaloriesOregano();
                    INGREDIENT_CALORIES.add(Ingredient.OREGANO.getCalories());
                    COOK.oregano();
                    CHECK.add(CREATE_PIZZA_VIEW.orderOregano());
                    break;
                case SAUCE:
                    ORDER.add(INGREDIENT_PRICE.priceSauceIncludingVAT());
                    CREATE_PIZZA_VIEW.displayCaloriesSauce();
                    INGREDIENT_CALORIES.add(Ingredient.SAUCE.getCalories());
                    COOK.sauce();
                    CHECK.add(CREATE_PIZZA_VIEW.orderSauce());
                    break;
                case CRUST:
                    ORDER.add(INGREDIENT_PRICE.priceCrustIncludingVAT());
                    CREATE_PIZZA_VIEW.displayCaloriesCrust();
                    INGREDIENT_CALORIES.add(Ingredient.CRUST.getCalories());
                    CHECK.add(CREATE_PIZZA_VIEW.orderCrust());
                    break;
            }
        } catch (NullPointerException e) {
            try {
                throw new IngredientNumberException();
            } catch (IngredientNumberException ex) {
                CREATE_PIZZA_VIEW.ingredientNumberException();
            }
        }
        totalOrder();
        CREATE_PIZZA_VIEW.totalCalories(INGREDIENT_CALORIES.countTotalCalories());
    }

    public double totalOrder() {
        return RoundUtil.up(ORDER.totalOrder());
    }

    public void displayTotalOrder() {
        double totalOrder = RoundUtil.up(ORDER.totalOrder());
        CREATE_PIZZA_VIEW.totalOrder(totalOrder);
    }

    public double getChange() {
        return CASH_PAYMENT.countChange(totalOrder());
    }

    public void addIngredientsQuestion() {
        CREATE_PIZZA_VIEW.addIngredientsQuestion();
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
        CREATE_PIZZA_VIEW.paymentChoice();
        try {
            payment = CHECK_INT.checkInt();
            switch (PAYMENT_METHOD.get(payment)) {
                case CASH:
                    CHECK_VIEW.displayCheckCreatePizza();
                    displayTotalOrder();
                    CASH_PAYMENT.getFullAmount();
                    CASH_PAYMENT_VIEW.getChangeCreatePizza();
                    break;
                case CARD:
                    CHECK_VIEW.displayCheckCreatePizza();
                    displayTotalOrder();
                    CARD_PAYMENT.enterPIN();
                    break;
                case ONLINE:
                    CHECK_VIEW.displayCheckCreatePizza();
                    displayTotalOrder();
                    ONLINE_PAYMENT.addCustomer();
                    break;
            }
        } catch (NullPointerException e) {
            try {
                throw new PaymentChoiceException();
            } catch (PaymentChoiceException ex) {
                CREATE_PIZZA_VIEW.paymentChoiceException();
                paymentChoice();
            }
        }
    }
}
