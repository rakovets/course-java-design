package com.rakovets.course.design.practice.pizzeria;

import com.racovets.course.design.practice.pizzeria.*;
import com.racovets.course.design.practice.pizzeria.model.*;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PizzeriaDemo {
    private static IngredientsRepository ingredientsRepo;
    private static Map<Ingredients, Integer> mapIngredientsRepo;
    private static Map<Ingredients, Integer> recipe1;
    private static Map<Ingredients, Integer> recipe2;
    private static Map<Ingredients, Integer> recipe3;
    private static Map<Ingredients, Integer> recipe4;
    private static Map<Ingredients, Integer> recipe5;
    private static PizzaRepository pizzaRepository;
    private static List<Pizza> pizzaList;
    private static OrderPizza orderPizza;
    private static BufferedReader bf;
    private static BufferedWriter bw;
    static {
        mapIngredientsRepo = new HashMap<>();
        mapIngredientsRepo.put(new Sauce("sauce1", 12), 100);
        mapIngredientsRepo.put(new Sauce("sauce2", 7), 100);
        mapIngredientsRepo.put(new Cheese("cheese1", 30), 100);
        mapIngredientsRepo.put(new Cheese("cheese2", 15), 100);
        mapIngredientsRepo.put(new Meat("meat1", 30), 100);
        mapIngredientsRepo.put(new Meat("meat2", 10), 100);
        mapIngredientsRepo.put(new Vegetables("vegetables1", 5), 100);
        mapIngredientsRepo.put(new Vegetables("vegetables2", 1), 50);

        ingredientsRepo = new IngredientsRepository(mapIngredientsRepo);

        recipe1 = new HashMap<>();
        recipe1.put(new Sauce("sauce1", 12), 5);
        recipe1.put(new Meat("meat1", 30), 10);
        recipe1.put(new Cheese("cheese1", 30), 10);
        recipe1.put(new Vegetables("vegetable1", 5), 5);

        recipe2 = new HashMap<>();
        recipe2.put(new Sauce("sauce2", 7), 10);
        recipe2.put(new Vegetables("vegetables2", 1), 10);
        recipe2.put(new Cheese("cheese2", 15), 10);

        recipe3 = new HashMap<>();
        recipe3.put(new Sauce("sauce2", 7), 10);
        recipe3.put(new Meat("meat2", 10), 10);
        recipe3.put(new Vegetables("vegetables1", 5), 15);

        recipe4 = new HashMap<>();
        recipe4.put(new Cheese("cheese1", 30), 15);
        recipe4.put(new Cheese("cheese2", 15), 15);
        recipe4.put(new Vegetables("vegetables1", 5), 10);
        recipe4.put(new Vegetables("vegetables2", 1), 10);
        recipe4.put(new Meat("meat1", 30), 15);

        recipe5 = new HashMap<>();
        recipe5.put(new Meat("meat1", 30), 15);
        recipe5.put(new Sauce("sauce2", 7), 15);
        recipe5.put(new Vegetables("vegetables1", 5), 15);
        recipe5.put(new Cheese("cheese2", 15), 10);

        pizzaList = new ArrayList<>();
        pizzaList.add(new Pizza("pizza1", new Recipe(recipe1), 700));
        pizzaList.add(new Pizza("pizza2", new Recipe(recipe2), 500));
        pizzaList.add(new Pizza("pizza3", new Recipe(recipe3), 600));
        pizzaList.add(new Pizza("pizza4", new Recipe(recipe4), 1000));
        pizzaList.add(new Pizza("pizza5", new Recipe(recipe5), 900));

        pizzaRepository = new PizzaRepository(pizzaList);

        orderPizza = new OrderPizza();
        bf = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main (String[] args) throws IOException {

        while (!orderPizza.isClosed()) {
            int pizzaCount;
            String continueChoice;
            do {
                System.out.println("Choose pizza:");
                System.out.print("Enter a number: \n" +
                        "1 - Pizza1\n" +
                        "2 - Pizza2\n" +
                        "3 - Pizza3\n" +
                        "4 - Pizza4\n" +
                        "5 - Pizza5\n");
                int choice = Integer.parseInt(bf.readLine());
                System.out.println("Enter a count of chosen pizza");
                pizzaCount = Integer.parseInt(bf.readLine());
                Pizza pizza = pizzaRepository.getPizza(choice);
                pizza.setAvailableForOrder(ingredientsRepo, pizzaCount);
                if (pizza.isAvailableForOrder()) {
                    int pizzaCost = pizza.getPrice() * pizzaCount;
                    orderPizza.setTotalCost(pizzaCost);
                    orderPizza.getOrderMap().put(pizza, pizzaCount);
                    ingredientsRepo.consumeIngredients(pizza, pizzaCount);
                    ingredientsRepo.infoAboutLackingIngredients();
                } else {
                    System.out.println("This pizza is not available for order");
                }
                System.out.println("Do you want to choose another pizza? Press 'Y' or 'N'");
                continueChoice = bf.readLine();
            } while (continueChoice.equalsIgnoreCase("Y"));
            orderPizza.setLocalDateTimeOfOrder(LocalDateTime.now());
            orderPizza.isDiscount();
            orderPizza.getTotalCostWithDiscount();
            orderPizza.printOrderCheck();
            ingredientsRepo.viewIngredients();
            orderPizza.setClosed();
        }
    }
}
