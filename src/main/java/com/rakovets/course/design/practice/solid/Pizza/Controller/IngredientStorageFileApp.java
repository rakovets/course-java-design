package com.rakovets.course.design.practice.solid.Pizza.Controller;

import com.rakovets.course.design.practice.solid.Pizza.Repository.IngredientStorage;
import com.rakovets.course.design.practice.solid.Pizza.Repository.IngredientStorageFile;

import java.nio.file.Paths;

public class IngredientStorageFileApp implements IngredientStorage {
    public static void main(String[] args) {
        IngredientStorageFile.writeStorageInFile(Paths.get("src", "main", "resources", "Storage.txt"));
    }
}