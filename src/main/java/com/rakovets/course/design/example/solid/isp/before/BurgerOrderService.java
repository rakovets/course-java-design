package com.rakovets.course.design.example.solid.isp.before;

public class BurgerOrderService implements OrderService {
    @Override
    public void orderBurger(int quantity) {
        System.out.println("Received order of " + quantity + " burgers");
    }

    @Override
    public void orderFries(int fries) {
        System.out.println("No fries in burger only order");
    }

    @Override
    public void orderCombo(int quantity, int fries) {
        System.out.println("No combo in burger only order");
    }
}