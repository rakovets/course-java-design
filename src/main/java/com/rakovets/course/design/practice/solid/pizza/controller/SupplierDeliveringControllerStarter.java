package com.rakovets.course.design.practice.solid.pizza.controller;

import com.rakovets.course.design.practice.solid.pizza.service.SupplyService;

public class SupplierDeliveringControllerStarter {
    public static void main(String[] args) {
        SupplyService supplyService = new SupplyService();
        supplyService.start();
    }
}
