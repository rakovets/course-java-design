package com.rakovets.course.design.practice.solid.pizza.view;

import com.rakovets.course.design.practice.solid.pizza.model.Employee;

import java.util.List;

public interface EmployeeView {

    void employeeDisplay(List<Employee> employeeList);

    void employeeQuantity();

    void employeeTypes();

    void employeeName();

    void employeeSalary();

    void staffName();

    void staffSalary();

    void staffCategory();

    void invalidInput();

}
