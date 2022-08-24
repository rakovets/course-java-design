package com.rakovets.course.design.practice.solid.source.impl;

import com.rakovets.course.design.practice.solid.model.payment.Card;
import com.rakovets.course.design.practice.solid.model.payment.Cash;
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

public final class CashPaymentStorageImpl implements PaymentStorage {
    private static final Path PATH = Path.of("src", "main", "java", "com", "rakovets", "course", "design",
            "practice", "solid", "source", "storage", "cash_payment_storage.txt");

    private final Logger logger = Logger.getLogger("CardPaymentStorageImpl");
    private final Collection<Cash> cardsPayment;

    public CashPaymentStorageImpl() {
        cardsPayment = new ArrayList<>();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> Collection<T> showAllStorage() {
        PaymentDataParser parser = PaymentDataParser.getINSTANCE();
        Cash payment;
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH.toFile(), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                payment = new Cash(
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
