package com.rakovets.course.design.practice.solid.service;

import com.rakovets.course.design.practice.solid.model.ingredient.Ingredient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

public interface SearchForIngredients {
    <T extends Ingredient> @Nullable Ingredient getIngredient
            (String nameIngredient, @NotNull Collection<Collection<T>> collectionCollection, double weight);
}
