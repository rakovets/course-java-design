package com.rakovets.course.design.example.solid.ocp;

import com.rakovets.course.design.example.solid.ocp.after.Circle;
import com.rakovets.course.design.example.solid.ocp.after.Rectangle;
import com.rakovets.course.design.example.solid.ocp.after.Shape;

/**
 * O - Открыт для расширение и закрыт для изменения
 */
public class OcpExampleAfter {
    private static Shape shape;

    public static void main(String[] args) {
        shape = new Rectangle(2, 5);
        double rectangleArea = shape.calculateArea();
        System.out.println(rectangleArea);

        shape = new Circle(5);
        double circleArea = shape.calculateArea();
        System.out.println(circleArea);
    }
}

