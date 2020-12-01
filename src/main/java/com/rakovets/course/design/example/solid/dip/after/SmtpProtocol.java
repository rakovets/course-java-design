package com.rakovets.course.design.example.solid.dip.after;

public class SmtpProtocol implements MailProtocol {
    private final String name = "SMTP";

    public void send(String message) {
        System.out.printf("Send by %s: %s%n", name, message);
    }
}
