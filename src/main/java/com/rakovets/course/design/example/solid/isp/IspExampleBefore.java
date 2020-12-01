package com.rakovets.course.design.example.solid.isp;

import com.rakovets.course.design.example.solid.isp.before.BurgerOrderService;
import com.rakovets.course.design.example.solid.isp.before.OrderService;

/**
 * I - разделяйте интерфейсы
 */
public class IspExampleBefore {
    private static final OrderService orderService = new BurgerOrderService();

    public static void main(String[] args) {
        orderService.orderBurger(2);
        orderService.orderFries(3);
        orderService.orderCombo(2, 3);
    }
}