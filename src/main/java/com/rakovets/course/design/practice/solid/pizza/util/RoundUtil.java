package com.rakovets.course.design.practice.solid.pizza.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class RoundUtil {

    private RoundUtil() {
    }

    public static double up(double value) {
        return BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}