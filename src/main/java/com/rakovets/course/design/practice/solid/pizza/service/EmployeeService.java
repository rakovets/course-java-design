package com.rakovets.course.design.practice.solid.pizza.service;

import com.rakovets.course.design.practice.solid.pizza.model.Employee;
import com.rakovets.course.design.practice.solid.pizza.view.EmployeeViewConsole;

import java.util.List;
import java.util.Scanner;

public class EmployeeService {
    public double enteredDouble;
    public int enteredInt;
    public int employeeID;
    private static final Scanner scan;
    private static final EmployeeViewConsole employeeView;
    private final Employee employee = new Employee();

    static {
        scan = new Scanner(System.in);
        employeeView = new EmployeeViewConsole();
    }

    public EmployeeService(String firstName, String lastName, double salary) {
        employee.firstName = firstName;
        employee.lastName = lastName;
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
        employeeID = checkInt();
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
        employeeID = checkInt();
        for (int i = 0; i < employeeID; i++) {
            employeeView.employeeFirstName();
            employee.firstName = scan.next();
            employeeView.employeeLastName();
            employee.lastName = scan.next();
            employeeView.employeeSalary();
            employee.salary = checkDouble();
            employeeList.add(new EmployeeService(employee.firstName, employee.lastName, employee.salary));
        }
    }

    public int checkInt() {
        do {
            while (!scan.hasNextInt()) {
                employeeView.invalidInput();
                scan.next();
            }
            enteredInt = scan.nextInt();
        } while (enteredInt <= 0);
        return enteredInt;
    }

    public double checkDouble() {
        while (!scan.hasNextDouble()) {
            employeeView.invalidInput();
            scan.next();
        }
        enteredDouble = scan.nextDouble();
        return enteredDouble;
    }

    public double getSalary() {
        return employee.salary;
    }

    public String toString() {
        return employee.toString();
    }
}
