package com.rakovets.course.design.practice.solid.source;

import com.rakovets.course.design.practice.solid.source.impl.CardPaymentStorageImpl;
import com.rakovets.course.design.practice.solid.source.impl.CashPaymentStorageImpl;
import com.rakovets.course.design.practice.solid.source.impl.CheeseStorageImpl;
import com.rakovets.course.design.practice.solid.source.impl.MeatStorageImpl;
import com.rakovets.course.design.practice.solid.source.impl.OnlinePaymentStorageImpl;
import com.rakovets.course.design.practice.solid.source.impl.SauceStorageImpl;
import com.rakovets.course.design.practice.solid.source.impl.VegetablesStorageImpl;
import lombok.Getter;

public final class Storage {
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
    @Getter
    private final PaymentStorage cardPaymentStorage;
    @Getter
    private final PaymentStorage cashPaymentStorage;
    @Getter
    private final PaymentStorage onlinePaymentStorage;

    private Storage() {
        cheeseStorage = new CheeseStorageImpl();
        meatStorage = new MeatStorageImpl();
        sauceStorage = new SauceStorageImpl();
        vegetablesStorage = new VegetablesStorageImpl();
        cardPaymentStorage = new CardPaymentStorageImpl();
        cashPaymentStorage = new CashPaymentStorageImpl();
        onlinePaymentStorage = new OnlinePaymentStorageImpl();
    }
}
