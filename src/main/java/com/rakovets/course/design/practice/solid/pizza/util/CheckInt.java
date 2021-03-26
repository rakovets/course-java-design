package com.rakovets.course.design.practice.solid.pizza.util;

import java.util.Scanner;

public class CheckInt {
    public static final Scanner SCANNER;
    public int enteredInt;

    static {
        SCANNER = new Scanner(System.in);
    }

    public int checkInt() {
        do {
            while (!SCANNER.hasNextInt()) {
                invalidInput();
                SCANNER.next();
            }
            enteredInt = SCANNER.nextInt();
        } while (enteredInt <= 0);
        return enteredInt;
    }

    public void invalidInput() {
        System.out.println("Your input is invalid. You must enter a digit");
    }
}
