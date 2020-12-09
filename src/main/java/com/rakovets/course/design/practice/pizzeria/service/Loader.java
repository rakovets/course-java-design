package com.rakovets.course.design.practice.pizzeria.service;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class Loader {
    private static String sep = File.separator;
    private static String directory = "src" + sep + "main" + sep + "resources" + sep + "pizzeria" + sep;

    public static Map<String, Double> loadAccount() {
        String path = directory + "account.txt";
        return FileLoader.loadMap(path)
                .entrySet().stream().
                        collect(Collectors.toMap(Map.Entry::getKey, e -> Double.parseDouble(e.getValue())));
    }

    public static Map<String, Integer> loadIngredients() {
        String path = directory + "storage.txt";
        return valueToInteger(FileLoader.loadMap(path));
    }

    public static Map<String, Integer> loadRecepie(String name) {
        String path = directory + "recepies" + sep + name + ".txt";
        return valueToInteger(FileLoader.loadMap(path));
    }

    public static double loadCost(String name) {
        String path = directory + "price_pizzas.txt";
        Optional<String> string = FileLoader.loadMap(path).entrySet().stream().
                filter(e -> e.getKey().equals(name)).map(Map.Entry::getValue).findFirst();
        return Double.parseDouble(string.get());
    }

    public static Set<String> loadPizzaNames() {
        String path = directory + "price_pizzas.txt";;
        return FileLoader.loadMap(path).keySet();
    }

    public static Set<String> loadPayments() {
        String path = directory + "account.txt";
        return FileLoader.loadMap(path).keySet();
    }

    public static Map<String, Integer> loadDiscountsByDay() {
        String path = directory + "discounts" + sep + "days.txt";
        return valueToInteger(FileLoader.loadMap(path));
    }

    public static Map<Integer, Integer> loadDiscountsByAmountOfPizzas() {
        String path = directory + "discounts" + sep + "amount_of_pizzas.txt";
        return FileLoader.loadMap(path).entrySet().stream().
                collect(Collectors.toMap(e -> Integer.parseInt(e.getKey()), e -> Integer.parseInt(e.getValue())));
    }

    private static Map<String, Integer> valueToInteger(Map<String, String> map) {
        return map.entrySet().stream().
                collect(Collectors.toMap(Map.Entry::getKey, e -> Integer.parseInt(e.getValue())));
    }
}