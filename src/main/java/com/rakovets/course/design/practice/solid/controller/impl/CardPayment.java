package com.rakovets.course.design.practice.solid.controller.impl;

import com.rakovets.course.design.practice.solid.controller.Command;
import com.rakovets.course.design.practice.solid.model.payment.Card;
import com.rakovets.course.design.practice.solid.model.payment.Cash;
import com.rakovets.course.design.practice.solid.model.payment.Online;
import com.rakovets.course.design.practice.solid.model.payment.Payment;
import com.rakovets.course.design.practice.solid.source.PaymentStorage;
import com.rakovets.course.design.practice.solid.source.Storage;

import java.util.Collection;

public final class CardPayment implements Command {
    private final Collection<Card> cards;
    private final Collection<Cash> cash;
    private final Collection<Online> online;

    public CardPayment() {
        Storage storage = Storage.getINSTANCE();

        PaymentStorage cardPaymentStorage = storage.getCardPaymentStorage();
        PaymentStorage cashPaymentStorage = storage.getCashPaymentStorage();
        PaymentStorage onlinePaymentStorage = storage.getOnlinePaymentStorage();

        cards = cardPaymentStorage.showAllStorage();
        cash = cashPaymentStorage.showAllStorage();
        online = cashPaymentStorage.showAllStorage();
    }


    @Override
    @SuppressWarnings("unchecked")
    public Payment execute() {
        return null;
    }
}
