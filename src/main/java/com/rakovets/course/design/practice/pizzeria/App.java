package com.rakovets.course.design.practice.pizzeria;

import com.rakovets.course.design.practice.pizzeria.repository.Starter;
import com.rakovets.course.design.practice.pizzeria.view.Console;

public class App {
    public static void main(String[] args) {
        Starter.start();
        Console.start();
    }
}
