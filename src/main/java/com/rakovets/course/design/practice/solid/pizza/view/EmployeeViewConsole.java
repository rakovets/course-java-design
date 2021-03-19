package com.rakovets.course.design.practice.solid.pizza.view;

import com.rakovets.course.design.practice.solid.pizza.model.Employee;

import java.util.List;

public class EmployeeViewConsole implements EmployeeView {

    public void employeeDisplay(List<Employee> employeeList) {
        int j = 0;
        for (Employee employee : employeeList) {
            System.out.println("ID#" + (j + 1) + ": " + employee);
            j++;
        }
    }

    public void employeeQuantity() {
        System.out.println("How many Employee's would you like to create?");
    }

    public void employeeTypes() {
        System.out.println("What type of Employee would you like to create?");
        System.out.println("1. Management");
        System.out.println("2. Staff");
    }

    public void employeeName() {
        System.out.println("Enter Employee Name:");
    }

    public void employeeSalary() {
        System.out.println("Enter Employee salary:");
    }

    public void staffName() {
        System.out.println("Enter Staff Member Name:");
    }

    public void staffSalary() {
        System.out.println("Enter Staff Member Salary:");
    }

    public void staffCategory() {
        System.out.println("Select Staff Category:");
        System.out.println("1. Full-time");
        System.out.println("2. Part-time");
    }

    public void invalidInput() {
        System.out.println("Your input is invalid");
    }
}
