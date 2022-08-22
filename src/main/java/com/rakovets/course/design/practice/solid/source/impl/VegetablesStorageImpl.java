package com.rakovets.course.design.practice.solid.source.impl;

import com.rakovets.course.design.practice.solid.model.ingredient.Vegetables;
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

public final class VegetablesStorageImpl implements IngredientsStorage {
    private static final Logger LOGGER = Logger.getLogger("VegetablesStorageImpl");
    @Getter
    private static final Path PATH = Path.of("src", "main", "java", "com", "rakovets", "course", "design",
            "practice", "solid", "source", "storage", "vegetables_storage.txt");

    private final Collection<Vegetables> vegetables;

    public VegetablesStorageImpl() {
        vegetables = new ArrayList<>();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> Collection<T> showAllStorage() {
        IngredientsDataParser parser = IngredientsDataParser.getINSTANCE();
        Vegetables ingredient;
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH.toFile(), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                ingredient = new Vegetables(parser.getName(line),
                        parser.getPrice(line),
                        parser.getWeight(line));
                vegetables.add(ingredient);
            }
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.log(Level.WARNING, e.getMessage());
        }
        return (Collection<T>) vegetables;
    }
}