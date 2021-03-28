package com.rakovets.course.design.practice.solid.pizza.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class DateFormatUtil {

    private DateFormatUtil() {
    }

    public static String localDatePattern(LocalDateTime localDate) {
        return localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }
}
