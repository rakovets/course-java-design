package com.rakovets.course.design.practice.solid.service;

import com.rakovets.course.design.practice.solid.model.ingredient.Cheese;
import com.rakovets.course.design.practice.solid.model.ingredient.Ingredient;
import com.rakovets.course.design.practice.solid.model.ingredient.Meat;
import com.rakovets.course.design.practice.solid.model.ingredient.Sauce;
import com.rakovets.course.design.practice.solid.model.ingredient.Vegetables;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public interface MakeCollectionsIngredients {
    <T extends Ingredient> @NotNull Collection<Collection<T>> makeCollections(
            Collection<Cheese> cheeses, Collection<Meat> meats, Collection<Sauce> sauces,
            Collection<Vegetables> vegetables);
}
