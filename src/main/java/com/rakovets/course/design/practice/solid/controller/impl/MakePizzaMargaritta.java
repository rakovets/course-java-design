package com.rakovets.course.design.practice.solid.controller.impl;

import com.rakovets.course.design.practice.solid.controller.Command;
import com.rakovets.course.design.practice.solid.model.Pizza;
import com.rakovets.course.design.practice.solid.model.ingredient.Cheese;
import com.rakovets.course.design.practice.solid.model.ingredient.Ingredient;
import com.rakovets.course.design.practice.solid.model.ingredient.Meat;
import com.rakovets.course.design.practice.solid.model.ingredient.Sauce;
import com.rakovets.course.design.practice.solid.model.ingredient.Vegetables;
import com.rakovets.course.design.practice.solid.service.MakeCollectionsIngredients;
import com.rakovets.course.design.practice.solid.service.SearchForIngredients;
import com.rakovets.course.design.practice.solid.service.ShopService;
import com.rakovets.course.design.practice.solid.service.impl.MakeCollectionsIngredientsImpl;
import com.rakovets.course.design.practice.solid.service.impl.SearchForIngredientsImpl;
import com.rakovets.course.design.practice.solid.service.impl.ShopServiceImpl;
import com.rakovets.course.design.practice.solid.source.IngredientsStorage;
import com.rakovets.course.design.practice.solid.source.Storage;

import java.util.Collection;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class MakePizzaMargaritta<T extends Ingredient> implements Command {
    private final MakeCollectionsIngredients makeCollectionsIngredients;
    private final SearchForIngredients searchForIngredients;
    private final Collection<Cheese> cheeses;
    private final Collection<Meat> meats;
    private final Collection<Sauce> sauces;
    private final Collection<Vegetables> vegetables;
    private final ShopService shopService;

    public MakePizzaMargaritta() {
        Storage storage = Storage.getINSTANCE();

        IngredientsStorage cheeseStorage = storage.getCheeseStorage();
        IngredientsStorage meatStorage = storage.getMeatStorage();
        IngredientsStorage sauceStorage = storage.getSauceStorage();
        IngredientsStorage vegetablesStorage = storage.getVegetablesStorage();

        cheeses = cheeseStorage.showAllStorage();
        meats = meatStorage.showAllStorage();
        sauces = sauceStorage.showAllStorage();
        vegetables = vegetablesStorage.showAllStorage();

        searchForIngredients = new SearchForIngredientsImpl();
        makeCollectionsIngredients = new MakeCollectionsIngredientsImpl();

        shopService = new ShopServiceImpl();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Pizza execute() {
        Collection<Collection<T>> collection =
                makeCollectionsIngredients.makeCollections(cheeses, meats, sauces, vegetables);

        LinkedList<T> list = Stream.of(
                        searchForIngredients.getIngredient("PARMESAN", collection, 180.00),
                        searchForIngredients.getIngredient("BEEF", collection, 250.00),
                        searchForIngredients.getIngredient("KETCHUP", collection, 130.00),
                        searchForIngredients.getIngredient("CUCUMBER", collection, 350.00),
                        searchForIngredients.getIngredient("TOMATO", collection, 250.00))
                .map(ingredient -> (T) ingredient)
                .collect(Collectors.toCollection(LinkedList::new));

        return shopService.makePizzaMargaritta("Margaritta", (Collection<Ingredient>) list);
    }
}
