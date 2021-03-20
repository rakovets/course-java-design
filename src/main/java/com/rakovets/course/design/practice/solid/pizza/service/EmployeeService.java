package com.rakovets.course.design.practice.solid.pizza.service;

import com.rakovets.course.design.practice.solid.pizza.model.Employee;
import com.rakovets.course.design.practice.solid.pizza.view.EmployeeView;

import java.util.List;
import java.util.Scanner;

public class EmployeeService {
    public double enteredSalary;
    public int enteredNumber;
    public int employeeID;
    private static final Scanner scan;
    private static final EmployeeView employeeView;
    private final Employee employee = new Employee();

    static {
        scan = new Scanner(System.in);
        employeeView = new EmployeeView();
    }

    public EmployeeService(String name, double salary) {
        employee.name = name;
        employee.salary = salary;
    }

    public EmployeeService() {
    }

    public void salaryChange(double amount) {
        employee.salary = getSalary();
        employee.salary += amount;
        employeeView.employeeSalaryChange();
    }

    public void quitEmployee(List<EmployeeService> employeeList) {
        employeeView.quitEmployee();
        employeeID = checkID();
        if (employeeID > employeeList.size())
            employeeView.notValidID();
        else
            employeeID -= 1;
        double amount = -employeeList.get(employeeID).getSalary();
        employeeList.get(employeeID).salaryChange(amount);
    }

    public void getInfo(List<EmployeeService> employeeList) {
        employeeView.employeeInfo();
        employeeView.employeeDisplay(employeeList);
    }

    public void createNewEmployee(List<EmployeeService> employeeList) {
        employeeView.employeeQuantity();
        employeeID = checkID();
        for (int i = 0; i < employeeID; i++) {
            employeeView.employeeName();
            employee.name = scan.next();
            employeeView.employeeSalary();
            employee.salary = checkSalary();
            employeeList.add(new EmployeeService(employee.name, employee.salary));
        }
    }

    public int checkID() {
        do {
            while (!scan.hasNextInt()) {
                employeeView.invalidInput();
                scan.next();
            }
            enteredNumber = scan.nextInt();
        } while (enteredNumber <= 0);
        return enteredNumber;
    }

    public double checkSalary() {
        while (!scan.hasNextDouble()) {
            employeeView.invalidInput();
            scan.next();
        }
        enteredSalary = scan.nextDouble();
        return enteredSalary;
    }

    public double getSalary() {
        return employee.salary;
    }

    public String getName() {
        return employee.name;
    }

    public String toString() {
        return employee.toString();
    }
}
