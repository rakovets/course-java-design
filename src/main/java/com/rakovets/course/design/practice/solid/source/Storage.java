package com.rakovets.course.design.practice.solid.source;

import com.rakovets.course.design.practice.solid.source.impl.CheeseStorageImpl;
import com.rakovets.course.design.practice.solid.source.impl.MeatStorageImpl;
import com.rakovets.course.design.practice.solid.source.impl.SauceStorageImpl;
import com.rakovets.course.design.practice.solid.source.impl.VegetablesStorageImpl;
import lombok.Getter;

public class Storage {
    @Getter
    private static final Storage INSTANCE = new Storage();

    @Getter
    private final IngredientsStorage cheeseStorage;
    @Getter
    private final IngredientsStorage meatStorage;
    @Getter
    private final IngredientsStorage sauceStorage;
    @Getter
    private final IngredientsStorage vegetablesStorage;

    private Storage() {
        cheeseStorage = new CheeseStorageImpl();
        meatStorage = new MeatStorageImpl();
        sauceStorage = new SauceStorageImpl();
        vegetablesStorage = new VegetablesStorageImpl();
    }
}