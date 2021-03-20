package com.rakovets.course.design.practice.solid.pizza.view;

import com.rakovets.course.design.practice.solid.pizza.service.EmployeeService;

import java.util.List;

public class EmployeeView {

    public void employeeSalaryChange() {
        System.out.println("Employee salary has been changed. Press 3 to see Employee List");
    }

    public void quitEmployee() {
        System.out.println("Enter Employee ID whose salary you want to set to $00.00:");
    }

    public void notValidID() {
        System.out.println("Not a Valid Employee ID! Press 3 to see Employee List");
    }

    public void employeeInfo() {
        System.out.println("All the employee information is:");
    }

    public void employeeDisplay(List<EmployeeService> employeeList) {
        int i = 0;
        for (EmployeeService employee : employeeList) {
            System.out.println("ID#" + (i + 1) + ": " + employee);
            i++;
        }
    }

    public void employeeQuantity() {
        System.out.println("How many Employees would you like to create?");
    }

    public void employeeName() {
        System.out.println("Enter Employee Name:");
    }

    public void employeeSalary() {
        System.out.println("Enter Employee salary:");
    }

    public void invalidInput() {
        System.out.println("Your input is invalid");
    }

    public void operationsMenu() {
        System.out.println("1. Create New Employee");
        System.out.println("2. Change Employee Salary");
        System.out.println("3. Display All Information About Employees");
        System.out.println("4. Set Employee Salary to $00.00");
        System.out.println("5. Show Menu Options");
        System.out.println("6. Exit Program");
    }

    public void selectOption() {
        System.out.println("Select menu option:");
    }

    public void idForChangingSalary() {
        System.out.println("Enter Employee ID whose salary you want to change:");
    }

    public void changeSalary() {
        System.out.println("Enter amount to adjust Employee salary: " +
                "ex. (-100) to decrease and (100) to increase:");
    }

    public void exitProgram() {
        System.out.println("Program Terminated!");
    }

    public void showMenu() {
        System.out.println("Press 5 to see Menu Options");
    }
}
