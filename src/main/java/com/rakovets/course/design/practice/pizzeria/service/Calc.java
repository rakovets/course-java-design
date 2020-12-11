package com.rakovets.course.design.practice.pizzeria.service;

public class Calc {
    public static double round(double value) {
        return Math.round(value * 100) * 0.01;
    }
}
