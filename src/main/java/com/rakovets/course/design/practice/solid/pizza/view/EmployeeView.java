package com.rakovets.course.design.practice.solid.pizza.view;

import com.rakovets.course.design.practice.solid.pizza.service.EmployeeService;
import com.rakovets.course.design.practice.solid.pizza.service.StaffService;

import java.util.List;

public class EmployeeView {

    public void employeeSalaryChange() {
        System.out.println(EmployeeService.name + " salary has been changed to " + EmployeeService.salary);
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

    public void employeeDisplay(List<EmployeeService> employeeServiceList) {
        int j = 0;
        for (EmployeeService employeeService : employeeServiceList) {
            System.out.println("ID#" + (j + 1) + ": " + employeeService);
            j++;
        }
    }

    public void cantChangeStatus() {
        System.out.println("Employee with entered ID isn't Staff Member");
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

    public void staffSalaryChange() {
        System.out.println(StaffService.name + " salary has been changed to " + StaffService.salary);
    }

    public void staffCategoryChange() {
        System.out.println(StaffService.name + " is currently " + StaffService.category +
                "\nWhat would you like to change his(her) category to?");
    }

    public void changeResult() {
        System.out.println(StaffService.name + " is now " + StaffService.category);
    }

    public void operationsMenu() {
        System.out.println("1. Create New Employee");
        System.out.println("2. Increase Employee Salary");
        System.out.println("3. Display All Information About Employees");
        System.out.println("4. Set Employee Salary to $00.00");
        System.out.println("5. Show Menu Options");
        System.out.println("6. Change Employee Status");
        System.out.println("7. Exit Program");
    }

    public void selectOption() {
        System.out.println("Select a menu option:");
    }

    public void idForChangingSalary() {
        System.out.println("Enter Employee ID whose salary you want to change:");
    }

    public void increaseSalary() {
        System.out.println("Enter amount by which you want to increase Employee salary:");
    }

    public void changeStatus() {
        System.out.println("Enter Employee ID whose status you want to change:");
    }

    public void exitProgram() {
        System.out.println("Program Terminated!");
    }

    public void showMenu() {
        System.out.println("Press 5 to see Menu Options");
    }
}
