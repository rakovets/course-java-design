package com.rakovets.course.design.practice.solid.source.util;

import lombok.Getter;
import org.jetbrains.annotations.Nullable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class PaymentDataParser {
    @Getter
    private static final PaymentDataParser INSTANCE = new PaymentDataParser();

    private final Pattern pattern;
    private Matcher matcher;

    private PaymentDataParser() {
        String regx = ".+?: (\\w+).+?(\\d+\\.\\d+)";
        pattern = Pattern.compile(regx);
    }

    public @Nullable String getName(String line) {
        matcher = pattern.matcher(line);
        return matcher.matches()
                ? matcher.group(1)
                : null;
    }

    public double getAmount(String line) {
        matcher = pattern.matcher(line);
        return matcher.matches()
                ? Double.parseDouble(matcher.group(2))
                : 0.0;
    }
}
