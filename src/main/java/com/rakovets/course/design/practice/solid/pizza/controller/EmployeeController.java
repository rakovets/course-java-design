package com.rakovets.course.design.practice.solid.pizza.controller;

import com.rakovets.course.design.practice.solid.pizza.service.EmployeeService;
import com.rakovets.course.design.practice.solid.pizza.view.EmployeeViewConsole;

import java.util.ArrayList;
import java.util.List;

public class EmployeeController {
    private static final EmployeeViewConsole employeeView;
    private static final EmployeeService employeeService;
    private static boolean programOn;
    public int userMenuOption;
    public int employeeID;
    public double amount;
    private static final List<EmployeeService> employeeList;

    static {
        employeeView = new EmployeeViewConsole();
        employeeService = new EmployeeService();
        programOn = true;
        employeeList = new ArrayList<>();
    }

    public void start() {
        employeeService.createNewEmployee(employeeList);
        employeeView.selectOption();
        employeeView.operationsMenu();
        while (programOn) {
            employeeView.showMenu();
            userMenuOption = employeeService.checkInt();
            switch (userMenuOption) {
                case 1:
                    employeeService.createNewEmployee(employeeList);
                    break;
                case 2:
                    employeeView.idForChangingSalary();
                    employeeID = employeeService.checkInt();
                    if (employeeID > employeeList.size()) {
                        employeeView.notValidID();
                        break;
                    } else {
                        employeeID -= 1;
                        employeeView.changeSalary();
                        amount = employeeService.checkDouble();
                    }
                    employeeList.get(employeeID).salaryChange(amount);
                    break;
                case 3:
                    employeeService.getInfo(employeeList);
                    break;
                case 4:
                    employeeService.quitEmployee(employeeList);
                    break;
                case 5:
                    employeeView.operationsMenu();
                    break;
                case 6:
                    employeeView.exitProgram();
                    programOn = false;
                    break;
            }
        }
    }
}
