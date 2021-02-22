package com.rakovets.course.design.practice.solid.Pizza.Finance;

public class Discount {

    public double discountForTwoItems(double totalOrder) { return totalOrder * 0.9; }

    public double discountForThreeAndMoreItems(double totalOrder) { return totalOrder * 0.8; }

    public double discountForOrderOnMonday(double totalOrder) { return totalOrder * 0.85; }
}