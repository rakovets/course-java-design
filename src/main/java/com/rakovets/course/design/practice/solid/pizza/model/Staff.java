package com.rakovets.course.design.practice.solid.pizza.model;

public class Staff extends Employee {
    public String name;
    public double salary;
    public StaffCategory category;

    public Staff(String name, double salary, int category) {
        super(name, salary);
        this.name = name;
        this.salary = salary;
        switch (category) {
            case 1:
                this.category = StaffCategory.FULL_TIME;
                break;
            case 2:
                this.category = StaffCategory.PART_TIME;
                break;
        }
    }
}
