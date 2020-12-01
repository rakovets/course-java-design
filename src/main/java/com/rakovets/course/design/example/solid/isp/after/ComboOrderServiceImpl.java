package com.rakovets.course.design.example.solid.isp.after;

public class ComboOrderServiceImpl implements ComboOrderService {
    @Override
    public void orderCombo(int quantity, int fries) {
        orderBurger(quantity);
        orderBurger(fries);
    }

    @Override
    public void orderBurger(int quantity) {
        System.out.println("Received order of " + quantity + " burgers");
    }

    @Override
    public void orderFries(int fries) {
        System.out.println("Received order of " + fries + " fries");
    }
}
