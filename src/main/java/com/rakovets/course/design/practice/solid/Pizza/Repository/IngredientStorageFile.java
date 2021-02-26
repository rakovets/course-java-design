package com.rakovets.course.design.practice.solid.Pizza.Repository;

import java.io.*;
import java.nio.file.Path;
import java.util.Map;

public class IngredientStorageFile implements IngredientStorage {

    public static void writeStorageInFile(Path filePath) {
        Storage storage = new Storage();
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(String.valueOf(filePath)))) {
            for (Map.Entry<Ingredient, Integer> entry : storage.entrySet()) {
                bf.write(entry.getKey() + " : " + entry.getValue());
                bf.newLine();
            }
            bf.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}