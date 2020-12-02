package com.rakovets.course.design.example.pattern.observer.example.listeners;

import java.io.File;

public interface EventListener {
    void update(String eventType, File file);
}
