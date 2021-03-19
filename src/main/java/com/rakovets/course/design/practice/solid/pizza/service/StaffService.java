package com.rakovets.course.design.practice.solid.pizza.service;

import com.rakovets.course.design.practice.solid.pizza.model.StaffCategory;

import java.util.List;

public class StaffService extends EmployeeService {
    public static String name;
    public static double salary;
    public static StaffCategory category;

    public StaffService(String name, double salary, int category) {
        StaffService.name = name;
        StaffService.salary = salary;

        switch (category) {
            case 1:
                StaffService.category = StaffCategory.FULL_TIME;
                break;
            case 2:
                StaffService.category = StaffCategory.PART_TIME;
                break;
        }
    }

    public void salaryChange(double amount) {
        salary = getSalary();
        salary += amount;
        employeeView.staffSalaryChange();
    }

    public void quitEmployee(List<EmployeeService> employeeServiceList) {
        int employeeID;
        employeeView.quitEmployee();
        employeeID = checkInt();
        if (employeeID > employeeServiceList.size())
            employeeView.notValidID();
        else
            employeeID -= 1;
        double amount = -employeeServiceList.get(employeeID).getSalary();
        employeeServiceList.get(employeeID).salaryChange(amount);
    }

    public void changeStatus() {
        employeeView.staffCategoryChange();
        employeeView.staffCategory();
        int category = checkIntRange();
        switch (category) {
            case 1:
                StaffService.category = StaffCategory.FULL_TIME;
                break;
            case 2:
                StaffService.category = StaffCategory.PART_TIME;
                break;
        }
        employeeView.changeResult();
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return ("Staff Member Name: " + this.getName() + "\tSalary: $" + this.getSalary());
    }
}
