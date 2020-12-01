package com.rakovets.course.design.example.solid.dip.before;

public class Mailer {
    private final SmtpProtocol smtpProtocol = new SmtpProtocol();

    public void sendMessage(String message) {
        smtpProtocol.send(message);
    }
}
