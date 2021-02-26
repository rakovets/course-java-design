package com.rakovets.course.design.practice.solid.Pizza.Service;

public class Discount {

    public static double discountForTwoItems(double totalOrder) { return totalOrder * 0.9; }

    public static double discountForThreeAndMoreItems(double totalOrder) { return totalOrder * 0.8; }

    public static double discountForOrderOnSpecificDay (double totalOrder) { return totalOrder * 0.85; }

}