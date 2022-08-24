package com.rakovets.course.design.practice.solid;

import com.rakovets.course.design.practice.solid.model.payment.Card;
import com.rakovets.course.design.practice.solid.source.impl.OnlinePaymentStorageImpl;

import java.util.Collection;

public class Test {
    public static void main(String[] args) {
        OnlinePaymentStorageImpl cardPaymentStorage = new OnlinePaymentStorageImpl();
        Collection<Card> objects = cardPaymentStorage.showAllStorage();
        System.out.println(objects);
    }
}
