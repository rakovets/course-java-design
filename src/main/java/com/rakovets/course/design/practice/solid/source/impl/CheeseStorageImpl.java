package com.rakovets.course.design.practice.solid.source.impl;

import com.rakovets.course.design.practice.solid.model.ingredient.Cheese;
import com.rakovets.course.design.practice.solid.source.IngredientsStorage;
import com.rakovets.course.design.practice.solid.source.util.IngredientsDataParser;
import lombok.Getter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class CheeseStorageImpl implements IngredientsStorage {
    @Getter
    private static final Path PATH = Path.of("src", "main", "java", "com", "rakovets", "course", "design",
            "practice", "solid", "source", "storage", "cheese_storage.txt");

    private final Logger logger = Logger.getLogger("CheeseStorageImpl");
    private final Collection<Cheese> cheeses;

    public CheeseStorageImpl() {
        cheeses = new ArrayList<>();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> Collection<T> showAllStorage() {
        IngredientsDataParser parser = IngredientsDataParser.getINSTANCE();
        Cheese ingredient;
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH.toFile(), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                ingredient = new Cheese(parser.getName(line),
                        parser.getPrice(line),
                        parser.getWeight(line));
                cheeses.add(ingredient);
            }
        } catch (IOException e) {
            e.printStackTrace();
            logger.log(Level.WARNING, e.getMessage());
        }
        return (Collection<T>) cheeses;
    }
}
