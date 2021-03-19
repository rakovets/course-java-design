package com.rakovets.course.design.practice.solid.pizza.service;

import com.rakovets.course.design.practice.solid.pizza.view.EmployeeView;

import java.util.List;
import java.util.Scanner;

public class EmployeeService {
    public static String name;
    public static double salary;
    public double enteredSalary;
    private int enteredNumber;
    public int employeeID;
    private final Scanner scan = new Scanner(System.in);
    public EmployeeView employeeView = new EmployeeView();

    public EmployeeService(String name, double salary) {
        EmployeeService.name = name;
        EmployeeService.salary = salary;
    }

    public EmployeeService() {
    }

    public void salaryChange(double amount) {
        salary = getSalary();
        salary += amount;
        employeeView.employeeSalaryChange();
    }

    public void quitEmployee(List<EmployeeService> employeeServiceList) {
        employeeView.quitEmployee();
        employeeID = checkInt();
        if (employeeID > employeeServiceList.size())
            employeeView.notValidID();
        else
            employeeID -= 1;
        double amount = -employeeServiceList.get(employeeID).getSalary();
        employeeServiceList.get(employeeID).salaryChange(amount);
    }

    public void getInfo(List<EmployeeService> employeeServiceList) {
        employeeView.employeeInfo();
        employeeView.employeeDisplay(employeeServiceList);
    }

    public void changeStatus() {
        employeeView.cantChangeStatus();
    }

    public void createNewEmployee(List<EmployeeService> employeeServiceList) {
        int employeeID, employeeCategory, employeeType;
        double salary;
        String name;
        employeeView.employeeQuantity();
        employeeID = checkInt();
        for (int i = 0; i < employeeID; i++) {
            employeeView.employeeTypes();
            employeeType = checkIntRange();
            switch (employeeType) {
                case 1:
                    employeeView.employeeName();
                    name = scan.next();
                    employeeView.employeeSalary();
                    salary = checkDouble();
                    employeeServiceList.add(new EmployeeService(name, salary));
                    break;
                case 2:
                    employeeView.staffName();
                    name = scan.next();
                    employeeView.staffSalary();
                    salary = checkDouble();
                    employeeView.staffCategory();
                    employeeCategory = checkIntRange2();
                    employeeServiceList.add(new StaffService(name, salary, employeeCategory));
                    break;
            }
        }
    }

    public int checkInt() {
        do {
            while (!scan.hasNextInt()) {
                employeeView.invalidInput();
                scan.next();
            }
            enteredNumber = scan.nextInt();
        } while (enteredNumber <= 0);
        return enteredNumber;
    }

    public int checkIntRange() {
        do {
            while (!scan.hasNextInt()) {
                employeeView.invalidInput();
                scan.next();
            }
            enteredNumber = scan.nextInt();
        } while (enteredNumber < 1 || enteredNumber > 3);
        return enteredNumber;
    }

    public int checkIntRange2() {
        do {
            while (!scan.hasNextInt()) {
                employeeView.invalidInput();
                scan.next();
            }
            enteredNumber = scan.nextInt();
        } while (enteredNumber < 1 || enteredNumber > 2);
        return enteredNumber;
    }

    public double checkDouble() {
        do {
            while (!scan.hasNextDouble()) {
                employeeView.invalidInput();
                scan.next();
            }
            enteredSalary = scan.nextDouble();
        } while (enteredSalary <= 0);
        return enteredSalary;
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return ("Employee Name: " + this.getName() + "\tSalary: $" + this.getSalary());
    }
}
