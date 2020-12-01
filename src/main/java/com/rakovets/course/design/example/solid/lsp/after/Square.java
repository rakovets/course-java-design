package com.rakovets.course.design.example.solid.lsp.after;

public class Square implements Shape {
    private final int length;

    public Square(int length) {
        this.length = length;
    }

    @Override
    public double calculateArea() {
        return length * length;
    }
}
