package com.rakovets.course.design.example.solid.isp.after;

public class BurgerOrderServiceImpl implements BurgerOrderService {
    @Override
    public void orderBurger(int quantity) {
        System.out.println("Received order of " + quantity + " burgers");
    }
}
