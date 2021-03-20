package com.rakovets.course.design.practice.solid.pizza.model;

public class Employee {
    public String name;
    public double salary;

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String toString() {
        return ("Employee Name: " + this.getName() + "\tSalary: $" + this.getSalary());
    }
}
