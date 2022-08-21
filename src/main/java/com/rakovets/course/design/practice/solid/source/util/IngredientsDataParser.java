package com.rakovets.course.design.practice.solid.source.util;

import lombok.Getter;
import org.jetbrains.annotations.Nullable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class IngredientsDataParser {
    private static final String REGEX = ".+?: (\\w+).+?(\\d+\\.\\d+).+?(\\d+\\.\\d+)";
    @Getter
    private static final IngredientsDataParser INSTANCE = new IngredientsDataParser();

    private final Pattern pattern;
    private Matcher matcher;

    private IngredientsDataParser() {
        pattern = Pattern.compile(REGEX);
    }

    public @Nullable String getName(String line) {
        matcher = pattern.matcher(line);
        return matcher.matches()
                ? matcher.group(1)
                : null;
    }

    public double getPrice(String line) {
        matcher = pattern.matcher(line);
        return matcher.matches()
                ? Double.parseDouble(matcher.group(2))
                : 0.0;
    }

    public double getWeight(String line) {
        matcher = pattern.matcher(line);
        return matcher.matches()
                ? Double.parseDouble(matcher.group(3))
                : 0.0;
    }
}
