package com.rakovets.course.design.example.pattern.observer.example;

import com.rakovets.course.design.example.pattern.observer.example.editor.Editor;
import com.rakovets.course.design.example.pattern.observer.example.listeners.EmailNotificationListener;
import com.rakovets.course.design.example.pattern.observer.example.listeners.LogOpenListener;

public class Demo {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.events.subscribe("open", new LogOpenListener("/path/to/log/file.txt"));
        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));

        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
