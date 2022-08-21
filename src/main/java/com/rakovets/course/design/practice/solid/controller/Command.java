package com.rakovets.course.design.practice.solid.controller;

import com.rakovets.course.design.practice.solid.model.ingredient.Ingredient;

import java.util.Collection;

public interface Command {
    <T extends Ingredient> Collection<T> selectionsIngredients();
}
