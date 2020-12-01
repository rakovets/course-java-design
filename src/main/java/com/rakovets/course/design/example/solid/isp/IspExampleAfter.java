package com.rakovets.course.design.example.solid.isp;


import com.rakovets.course.design.example.solid.isp.after.BurgerOrderService;
import com.rakovets.course.design.example.solid.isp.after.BurgerOrderServiceImpl;
import com.rakovets.course.design.example.solid.isp.after.ComboOrderService;
import com.rakovets.course.design.example.solid.isp.after.ComboOrderServiceImpl;

/**
 * I - разделяйте интерфейсы
 */
public class IspExampleAfter {
    public static void main(String[] args) {
        BurgerOrderService burgerOrderService = new BurgerOrderServiceImpl();
        burgerOrderService.orderBurger(2);

        ComboOrderService comboOrderService = new ComboOrderServiceImpl();
        comboOrderService.orderBurger(2);
        comboOrderService.orderFries(3);
        comboOrderService.orderCombo(2, 3);
    }
}