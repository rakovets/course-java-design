package com.rakovets.course.design.practice.solid.pizza.model;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class Check {
    private final List<String> check;

    public Check(List<String> check) {
        this.check = check;
    }

    public void add(String item) {
        check.add(item);
    }

    public List<String> getItemsInCheck() {
        return check;
    }

    public void checkInFile() throws IOException {
        FileWriter writer = new FileWriter(String.valueOf(Paths.get("src", "main", "resources", "Orders.txt")));
        for (String str : check) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();
    }
}
