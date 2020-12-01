package com.rakovets.course.design.example.solid.isp.after;

public interface ComboOrderService extends BurgerOrderService, FriesOrderService {
    void orderCombo(int quantity, int fries);
}
