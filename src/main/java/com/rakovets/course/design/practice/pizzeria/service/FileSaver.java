package com.rakovets.course.design.practice.pizzeria.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class FileSaver {

    public static void saveMapToFile(String path, Map<String, String> map) {
        try {
            FileWriter writer = new FileWriter(path);
            StringBuilder data = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                data.append(entry.getKey() + "=" + entry.getValue() + "\n");
            }
            writer.write(String.valueOf(data));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addTextToFile(String path, StringBuilder text) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            StringBuilder data = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                data.append(line).append("\n");
            }
            reader.close();

            data.append(text);

            FileWriter writer = new FileWriter(path);
            writer.write(String.valueOf(data));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
