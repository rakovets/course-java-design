package com.rakovets.course.design.practice.solid.pizza.view;

import com.rakovets.course.design.practice.solid.pizza.service.EmployeeService;

import java.util.List;

public interface EmployeeView {

    void employeeSalaryChange();

    void quitEmployee();

    void notValidID();

    void employeeInfo();

    void employeeDisplay(List<EmployeeService> employeeList);

    void employeeQuantity();

    void employeeName();

    void employeeSalary();

    void invalidInput();

    void operationsMenu();

    void selectOption();

    void idForChangingSalary();

    void changeSalary();

    void exitProgram();

    void showMenu();

}
