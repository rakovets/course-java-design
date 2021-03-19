package com.rakovets.course.design.practice.solid.pizza.controller;

import com.rakovets.course.design.practice.solid.pizza.service.CreateEmployeeService;

public class EmployeeControllerStarter {
    public static void main(String[] args) {
        CreateEmployeeService createEmployeeService = new CreateEmployeeService();
        createEmployeeService.createNewEmployee();
    }
}
