package com.rakovets.course.design.practice.solid.controller.impl;

import com.rakovets.course.design.practice.solid.controller.Command;
import com.rakovets.course.design.practice.solid.model.payment.Payment;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

public final class CardPayment implements Command {
    @Contract(pure = true)
    @Override
    @SuppressWarnings("unchecked")
    public @Nullable Payment execute() {
        return null;
    }
}
