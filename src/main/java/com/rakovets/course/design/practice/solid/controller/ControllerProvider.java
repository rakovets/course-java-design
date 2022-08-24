package com.rakovets.course.design.practice.solid.controller;

import com.rakovets.course.design.practice.solid.controller.impl.ControllerImpl;
import lombok.Getter;

public final class ControllerProvider {
    @Getter
    public static final ControllerProvider INSTANCE = new ControllerProvider();
    @Getter
    private final Controller controller;

    private ControllerProvider() {
        controller = new ControllerImpl();
    }
}
