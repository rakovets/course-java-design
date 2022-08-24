package com.rakovets.course.design.practice.solid.service.impl;

import com.rakovets.course.design.practice.solid.model.ingredient.Ingredient;
import com.rakovets.course.design.practice.solid.service.SearchForIngredients;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

public final class SearchForIngredientsImpl implements SearchForIngredients {
    @Override
    public @Nullable <T extends Ingredient> Ingredient getIngredient(String nameIngredient,
                                                                     @NotNull Collection<Collection<T>> collections,
                                                                     double weight) {
        int oneKilogram = 1000;
        Ingredient result = null;

        for (Collection<T> collection : collections) {
            for (T ingredient : collection) {
                if (ingredient.getName().equals(nameIngredient) && ingredient.getWeight() >= weight) {
                    result = ingredient;
                    result.setPrice((weight * ingredient.getPrice()) / oneKilogram);
                    result.setWeight(weight);
                    break;
                }
            }
        }
        return result;
    }
}
