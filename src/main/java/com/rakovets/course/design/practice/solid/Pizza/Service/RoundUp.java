package com.rakovets.course.design.practice.solid.Pizza.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RoundUp {

    public static double roundUp(double value) {
        return BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}