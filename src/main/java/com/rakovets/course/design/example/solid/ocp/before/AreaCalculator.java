package com.rakovets.course.design.example.solid.ocp.before;

public class AreaCalculator {
    public static double calculateArea(Rectangle rectangle) {
        return rectangle.getLength() * rectangle.getWidth();
    }

    public static double calculateArea(Circle circle) {
        return Math.PI * circle.getRadius() * circle.getRadius();
    }
}
