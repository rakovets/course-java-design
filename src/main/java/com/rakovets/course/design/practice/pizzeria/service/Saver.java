package com.rakovets.course.design.practice.pizzeria.service;

import com.rakovets.course.design.practice.pizzeria.repository.Account;
import com.rakovets.course.design.practice.pizzeria.repository.SellStory;
import com.rakovets.course.design.practice.pizzeria.repository.Storage;

import java.io.File;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Saver {
    private static String sep = File.separator;
    private static String directory = "src" + sep + "main" + sep + "resources" + sep + "pizzeria" + sep;

    public static void saveAccount() {
        String path = directory + "account.txt";
        Map<String, String> map = stringalization(Account.getAccount());
        FileSaver.saveMapToFile(path, map);
    }

    public static void saveIngredients() {
        String path = directory + "storage.txt";
        Map<String, String> map = stringalization(Storage.getIngredients());
        FileSaver.saveMapToFile(path, map);
    }

    public static void saveCheck(StringBuilder check) {
        String path = directory + "check.txt";
        FileSaver.addTextToFile(path, check);
    }

    public static void saveSellStoryOfPizzas() {
        String path = directory + "sell_story_pizzas.txt";
        Map<String, String> map = stringalization(SellStory.getSellStoryOfPizzas());
        FileSaver.saveMapToFile(path, map);
    }

    public static void autoSave(StringBuilder check) {
        saveIngredients();
        saveAccount();
        saveCheck(check);
        saveSellStoryOfPizzas();
    }

    private static Map<String, String> stringalization(Map<?, ?> map) {
        Map<String, String> result = new TreeMap<>();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            result.put(entry.getKey().toString(), entry.getValue().toString());
        }
        return result;
    }
}
