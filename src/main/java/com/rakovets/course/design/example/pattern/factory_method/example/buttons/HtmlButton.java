package com.rakovets.course.design.example.pattern.factory_method.example.buttons;

/**
 * Реализация HTML кнопок.
 */
public class HtmlButton implements Button {

    public void render() {
        System.out.println("<button>Test Button</button>");
        onClick();
    }

    public void onClick() {
        System.out.println("Click! Button says - 'Hello World!'");
    }
}
