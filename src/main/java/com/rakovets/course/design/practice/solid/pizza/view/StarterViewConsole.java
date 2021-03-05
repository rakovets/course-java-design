package com.rakovets.course.design.practice.solid.pizza.view;

public class StarterViewConsole implements StarterView {

    public void displayOperations() {
        System.out.println("Choose operation:");
        System.out.println("1. Start 'Pizza Order'");
        System.out.println("2. Start 'Create Pizza'");
        System.out.println("3. Start 'Order Statistics'");
        System.out.println("4. Start 'Storage Utility'");
    }

    public void chooseOtherOperations() {
        System.out.println("\nDo you want to choose another operation? (Type y or n)");
    }
}
