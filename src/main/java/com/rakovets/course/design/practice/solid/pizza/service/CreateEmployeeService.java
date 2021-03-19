package com.rakovets.course.design.practice.solid.pizza.service;

import com.rakovets.course.design.practice.solid.pizza.model.Employee;
import com.rakovets.course.design.practice.solid.pizza.model.EmployeeType;
import com.rakovets.course.design.practice.solid.pizza.model.Staff;
import com.rakovets.course.design.practice.solid.pizza.view.EmployeeViewConsole;

import java.util.*;

public class CreateEmployeeService {
    public EmployeeViewConsole employeeViewConsole = new EmployeeViewConsole();
    private final Scanner scan = new Scanner(System.in);
    public int enteredNumber;
    public int employeeID;
    public String name;
    public double salary;
    public double enteredSalary;
    private static final Map<Integer, EmployeeType> employeeType;
    public int employeeCategory;
    public static List<Employee> employeeList;

    static {
        employeeType = new HashMap<>();
        employeeType.put(1, EmployeeType.MANAGEMENT);
        employeeType.put(2, EmployeeType.STAFF);
        employeeList = new ArrayList<>();
    }

    public void createNewEmployee() {
        employeeViewConsole.employeeQuantity();
        employeeID = checkID();
        for (int i = 0; i < employeeID; i++) {
            employeeViewConsole.employeeTypes();
            switch (employeeType.get(checkIntRange())) {
                case MANAGEMENT:
                    employeeViewConsole.employeeName();
                    name = scan.next();
                    employeeViewConsole.employeeSalary();
                    salary = checkSalary();
                    employeeList.add(new Employee(name, salary));
                    break;
                case STAFF:
                    employeeViewConsole.staffName();
                    name = scan.next();
                    employeeViewConsole.staffSalary();
                    salary = checkSalary();
                    employeeViewConsole.staffCategory();
                    employeeCategory = checkIntRange2();
                    employeeList.add(new Staff(name, salary, employeeCategory));
                    break;
            }
            employeeViewConsole.employeeDisplay(employeeList);
        }
    }

    public int checkID() {
        do {
            while (!scan.hasNextInt()) {
                employeeViewConsole.invalidInput();
                scan.next();
            }
            enteredNumber = scan.nextInt();
        } while (enteredNumber <= 0);
        return enteredNumber;
    }

    public int checkIntRange() {
        do {
            while (!scan.hasNextInt()) {
                employeeViewConsole.invalidInput();
                scan.next();
            }
            enteredNumber = scan.nextInt();
        } while (enteredNumber < 1 || enteredNumber > 3);
        return enteredNumber;
    }

    public double checkSalary() {
        do {
            while (!scan.hasNextDouble()) {
                employeeViewConsole.invalidInput();
                scan.next();
            }
            enteredSalary = scan.nextDouble();
        } while (enteredSalary <= 0);
        return enteredSalary;
    }

    public int checkIntRange2() {
        do {
            while (!scan.hasNextInt()) {
                employeeViewConsole.invalidInput();
                scan.next();
            }
            enteredNumber = scan.nextInt();
        } while (enteredNumber < 1 || enteredNumber > 2);
        return enteredNumber;
    }
}
