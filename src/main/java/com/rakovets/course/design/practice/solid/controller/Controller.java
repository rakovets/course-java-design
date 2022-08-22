package com.rakovets.course.design.practice.solid.controller;

import com.rakovets.course.design.practice.solid.model.ingredient.Ingredient;

import java.util.Collection;

public interface Controller {
    <T extends Ingredient> Collection<T> doOperations(String operation);
}
