package com.rakovets.course.design.example.pattern.decorator.example.decorators;

public interface DataSource {
    void writeData(String data);

    String readData();
}
