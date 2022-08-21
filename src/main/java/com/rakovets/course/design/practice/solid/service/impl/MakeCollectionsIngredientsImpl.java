package com.rakovets.course.design.practice.solid.service.impl;

import com.rakovets.course.design.practice.solid.model.ingredient.Cheese;
import com.rakovets.course.design.practice.solid.model.ingredient.Ingredient;
import com.rakovets.course.design.practice.solid.model.ingredient.Meat;
import com.rakovets.course.design.practice.solid.model.ingredient.Sauce;
import com.rakovets.course.design.practice.solid.model.ingredient.Vegetables;
import com.rakovets.course.design.practice.solid.service.MakeCollectionsIngredients;

import java.util.Collection;
import java.util.HashSet;

public final class MakeCollectionsIngredientsImpl implements MakeCollectionsIngredients {
    @Override
    @SuppressWarnings("unchecked")
    public <T extends Ingredient> Collection<Collection<T>> makeCollections(Collection<Cheese> cheeses,
                                                                            Collection<Meat> meats,
                                                                            Collection<Sauce> sauces,
                                                                            Collection<Vegetables> vegetables) {
        Collection<Collection<T>> collection = new HashSet<>();

        collection.add((Collection<T>) cheeses);
        collection.add((Collection<T>) meats);
        collection.add((Collection<T>) sauces);
        collection.add((Collection<T>) vegetables);
        return collection;
    }
}
