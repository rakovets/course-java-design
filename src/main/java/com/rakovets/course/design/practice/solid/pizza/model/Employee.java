package com.rakovets.course.design.practice.solid.pizza.model;

public class Employee {
    public String firstName;
    public String lastName;
    public double salary;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    public String toString() {
        return ("Employee Name: " + this.getFirstName() + " " + this.getLastName()
                + "\tSalary: $" + this.getSalary());
    }
}
