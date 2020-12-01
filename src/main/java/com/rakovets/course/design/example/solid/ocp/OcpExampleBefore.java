package com.rakovets.course.design.example.solid.ocp;

import com.rakovets.course.design.example.solid.ocp.before.AreaCalculator;
import com.rakovets.course.design.example.solid.ocp.before.Circle;
import com.rakovets.course.design.example.solid.ocp.before.Rectangle;

/**
 * O - Открыт для расширение и закрыт для изменения
 */
public class OcpExampleBefore {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5, 2);
        double rectangleArea = AreaCalculator.calculateArea(rectangle);
        System.out.println(rectangleArea);

        Circle circle = new Circle(5);
        double circleArea = AreaCalculator.calculateArea(circle);
        System.out.println(circleArea);
    }
}

