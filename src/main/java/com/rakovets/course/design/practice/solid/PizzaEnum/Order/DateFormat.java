package com.rakovets.course.design.practice.solid.PizzaEnum.Order;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormat {

    public static String localDatePattern(LocalDateTime localDate) {
        return localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }
}
