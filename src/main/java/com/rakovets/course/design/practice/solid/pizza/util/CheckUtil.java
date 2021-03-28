package com.rakovets.course.design.practice.solid.pizza.util;

import java.util.Scanner;

public final class CheckUtil {

    private CheckUtil() {
    }

    public static int checkInt() {
        Scanner scanner = new Scanner(System.in);
        int enteredInt;
        do {
            while (!scanner.hasNextInt()) {
                invalidInput();
                scanner.next();
            }
            enteredInt = scanner.nextInt();
        } while (enteredInt <= 0);
        return enteredInt;
    }

    public static double checkDouble() {
        Scanner scanner = new Scanner(System.in);
        double enteredDouble;
        while (!scanner.hasNextDouble()) {
            invalidInput();
            scanner.next();
        }
        enteredDouble = scanner.nextDouble();
        return enteredDouble;
    }

    public static void invalidInput() {
        System.out.println("Your input is invalid. You must enter a digit");
    }
}
