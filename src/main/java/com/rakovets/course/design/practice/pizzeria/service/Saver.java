package com.rakovets.course.design.practice.pizzeria.service;

import com.rakovets.course.design.practice.pizzeria.repository.Account;
import com.rakovets.course.design.practice.pizzeria.repository.SellStory;
import com.rakovets.course.design.practice.pizzeria.repository.Storage;

import java.io.File;
import java.util.Map;
import java.util.stream.Collectors;

public class Saver {
    private static String sep = File.separator;
    private static String directory = "src" + sep + "main" + sep + "resources" + sep + "pizzeria" + sep;

    public static void saveAccount() {
        String path = directory + "account.txt";
        Map<String, String> map = Account.getAccount().entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().toString()));
        FileSaver.saveMapToFile(path, map);
    }

    public static void saveIngredients() {
        String path = directory + "storage.txt";
        Map<String, String> map = Storage.getIngredients().entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().toString()));
        FileSaver.saveMapToFile(path, map);
    }

    public static void saveCheck(StringBuilder check) {
        String path = directory + "check.txt";
        FileSaver.addTextToFile(path, check);
    }

    public static void saveSellStoryOfPizzas() {
        String path = directory + "sell_story_pizzas.txt";
        Map<String, String> map = SellStory.getSellStoryOfPizzas().entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey().toString(), e -> e.getValue().toString()));
        FileSaver.saveMapToFile(path, map);
    }

    public static void autoSaveAll(StringBuilder check) {
        saveIngredients();
        saveAccount();
        saveCheck(check);
        saveSellStoryOfPizzas();
    }
}
