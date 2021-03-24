package com.rakovets.course.design.practice.solid.pizza.view;

public class StarterViewConsole implements StarterView {

    public void displayOperations() {
        System.out.println("Choose operation:");
        System.out.println("1. Start 'Pizza Order'");
        System.out.println("2. Start 'Create Pizza'");
        System.out.println("3. Start 'Order Statistics'");
        System.out.println("4. Start 'Storage Utility'");
        System.out.println("5. Start 'Suppliers' Delivery'");
        System.out.println("6. Start 'Employee Operations'");
        System.out.println("7. Exit program");
    }

    public void chooseOtherOperations() {
        System.out.println("\nDo you want to choose another operation? (Type y or n)");
    }

    public void noSuchOperation() {
        System.out.println("No operation under entered number. Check Operation List");
    }

    public void invalidInput() {
        System.out.println("Your input is invalid. You must enter a digit");
    }

    public void exitProgram() {
        System.out.println("Program Terminated!");
    }
}
