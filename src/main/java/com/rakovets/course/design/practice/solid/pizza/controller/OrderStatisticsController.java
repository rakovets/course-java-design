package com.rakovets.course.design.practice.solid.pizza.controller;

import com.rakovets.course.design.practice.solid.pizza.exceptions.OrderStatisticsException;
import com.rakovets.course.design.practice.solid.pizza.view.OrderStatisticsViewConsole;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderStatisticsController {
    public static int numberOfFourCheeseSold;
    public static int numberOfMargheritaSold;
    public static int numberOfMeatDelightSold;
    public static int numberOfPepperoniSold;
    public static int numberOfVegetarianSold;
    private static final OrderStatisticsViewConsole orderStatisticsView;

    static {
        orderStatisticsView = new OrderStatisticsViewConsole();
    }

    public void start() {
        try {
            Scanner scan = new Scanner(System.in);
            orderStatisticsView.enterFourCheese();
            numberOfFourCheeseSold = scan.nextInt();
            orderStatisticsView.enterMargherita();
            numberOfMargheritaSold = scan.nextInt();
            orderStatisticsView.enterMeatDelight();
            numberOfMeatDelightSold = scan.nextInt();
            orderStatisticsView.enterPepperoni();
            numberOfPepperoniSold = scan.nextInt();
            orderStatisticsView.enterVegetarian();
            numberOfVegetarianSold = scan.nextInt();
            orderStatisticsView.displayFourCheese();
            orderStatisticsView.displayMargherita();
            orderStatisticsView.displayMeatDelight();
            orderStatisticsView.displayPepperoni();
            orderStatisticsView.displayVegetarian();
        } catch (InputMismatchException e) {
            try {
                throw new OrderStatisticsException();
            } catch (OrderStatisticsException ex) {
                ex.printStackTrace();
                start();
            }
        }
    }
}
