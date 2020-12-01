package com.rakovets.course.design.example.solid.isp.before;

public interface OrderService {
    void orderBurger(int quantity);

    void orderFries(int fries);

    void orderCombo(int quantity, int fries);
}
