package com.rakovets.course.design.practice.solid.source;

import java.util.Collection;

public interface PaymentStorage {
    <T> Collection<T> showAllStorage();
}