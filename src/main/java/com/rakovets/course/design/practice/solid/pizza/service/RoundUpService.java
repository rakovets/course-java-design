package com.rakovets.course.design.practice.solid.pizza.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RoundUpService {

    public static double roundUp(double value) {
        return BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}