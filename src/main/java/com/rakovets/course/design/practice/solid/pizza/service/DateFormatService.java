package com.rakovets.course.design.practice.solid.pizza.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatService {

    public static String localDatePattern(LocalDateTime localDate) {
        return localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }
}
