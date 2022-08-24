package com.rakovets.course.design.practice.solid.source.util;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class StorageUpgrade {
    private final Logger logger = Logger.getLogger("StorageUpgrade");

    public void setWeight(int weight, @NotNull Collection<Path> paths) {

        for (Path path : paths) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile()));
                 BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {

            } catch (IOException e) {
                e.printStackTrace();
                logger.log(Level.WARNING, e.getMessage());
            }
        }
    }
}