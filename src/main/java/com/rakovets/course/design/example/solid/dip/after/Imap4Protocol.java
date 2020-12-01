package com.rakovets.course.design.example.solid.dip.after;

public class Imap4Protocol implements MailProtocol {
    private final String name = "IMAP4";

    public void send(String message) {
        System.out.printf("Send by %s: %s", name, message);
    }
}
