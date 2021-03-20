package com.rakovets.course.design.practice.solid.pizza.controller;

import com.rakovets.course.design.practice.solid.pizza.service.EmployeeOperationsService;

public class EmployeeControllerStarter {
    public static void main(String[] args) {
        EmployeeOperationsService employeeOperationsService = new EmployeeOperationsService();
        employeeOperationsService.start();
    }
}
