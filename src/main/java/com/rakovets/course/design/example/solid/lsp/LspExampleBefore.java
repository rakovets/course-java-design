package com.rakovets.course.design.example.solid.lsp;

import com.rakovets.course.design.example.solid.lsp.before.Rectangle;
import com.rakovets.course.design.example.solid.lsp.before.Square;

/**
 * L - выбирайте правильную абстракцию
 */
public class LspExampleBefore {
    public static void main(String[] args) {
        Rectangle rectangle = new Square();
        rectangle.setWidth(2);
        rectangle.setLength(3);
        System.out.println(rectangle.getArea());
    }
}
