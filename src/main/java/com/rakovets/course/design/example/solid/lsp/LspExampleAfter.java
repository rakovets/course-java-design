package com.rakovets.course.design.example.solid.lsp;

import com.rakovets.course.design.example.solid.lsp.after.Rectangle;
import com.rakovets.course.design.example.solid.lsp.after.Shape;
import com.rakovets.course.design.example.solid.lsp.after.Square;

/**
 * L - выбирайте правильную абстракцию
 */
public class LspExampleAfter {
    private static Shape shape;

    public static void main(String[] args) {
        shape = new Square(5);
        System.out.println(shape.calculateArea());

        shape = new Rectangle(5, 2);
        System.out.println(shape.calculateArea());
    }
}