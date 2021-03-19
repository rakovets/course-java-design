package com.rakovets.course.design.practice.solid.pizza.service;

import com.rakovets.course.design.practice.solid.pizza.view.EmployeeView;

import java.util.ArrayList;
import java.util.List;

public class EmployeeOperationsService {
    private static final EmployeeView employeeView;
    private static final EmployeeService employeeService;
    private static boolean programOn;
    public int userMenuOption;
    public int employeeID;
    public double amount;
    private static final List<EmployeeService> employeeServiceList;

    static {
        employeeView = new EmployeeView();
        employeeService = new EmployeeService();
        programOn = true;
        employeeServiceList = new ArrayList<>();
    }

    public void start() {
        employeeService.createNewEmployee(employeeServiceList);
        employeeView.selectOption();
        employeeView.operationsMenu();
        while (programOn) {
            employeeView.showMenu();
            userMenuOption = employeeService.checkInt();
            switch (userMenuOption) {
                case 1:
                    employeeService.createNewEmployee(employeeServiceList);
                    break;
                case 2:
                    employeeView.idForChangingSalary();
                    employeeID = employeeService.checkInt();
                    if (employeeID > employeeServiceList.size()) {
                        employeeView.notValidID();
                        break;
                    } else {
                        employeeID -= 1;
                        employeeView.increaseSalary();
                        amount = employeeService.checkDouble();
                    }
                    employeeServiceList.get(employeeID).salaryChange(amount);
                    break;
                case 3:
                    employeeService.getInfo(employeeServiceList);
                    break;
                case 4:
                    employeeService.quitEmployee(employeeServiceList);
                    break;
                case 5:
                    employeeView.operationsMenu();
                    break;
                case 6:
                    employeeView.changeStatus();
                    employeeID = employeeService.checkInt();
                    if (employeeID > employeeServiceList.size()) {
                        employeeView.notValidID();
                        break;
                    } else {
                        employeeID -= 1;
                        employeeServiceList.get(employeeID).changeStatus();
                    }
                    break;
                case 7:
                    employeeView.exitProgram();
                    programOn = false;
                    break;
            }
        }
    }
}
