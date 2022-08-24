package com.rakovets.course.design.practice.solid.source.impl;

import com.rakovets.course.design.practice.solid.model.payment.Card;
import com.rakovets.course.design.practice.solid.source.PaymentStorage;
import com.rakovets.course.design.practice.solid.source.util.PaymentDataParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class CardPaymentStorageImpl implements PaymentStorage {
    private static final Path PATH = Path.of("src", "main", "java", "com", "rakovets", "course", "design",
            "practice", "solid", "source", "storage", "card_payment_storage.txt");

    private final Logger logger = java.util.logging.Logger.getLogger("CardPaymentStorageImpl");
    private final Collection<Card> cardsPayment;

    public CardPaymentStorageImpl() {
        cardsPayment = new ArrayList<>();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> Collection<T> showAllStorage() {
        PaymentDataParser parser = PaymentDataParser.getINSTANCE();
        Card payment;
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH.toFile(), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                payment = new Card(
                        parser.getName(line),
                        parser.getAmount(line));
                cardsPayment.add(payment);
            }
        } catch (IOException e) {
            e.printStackTrace();
            logger.log(Level.WARNING, e.getMessage());
        }
        return (Collection<T>) cardsPayment;
    }
}
