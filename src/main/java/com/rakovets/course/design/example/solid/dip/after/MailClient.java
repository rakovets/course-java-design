package com.rakovets.course.design.example.solid.dip.after;

public class MailClient {
    private MailProtocol mailProtocol;

    public MailClient(MailProtocol mailProtocol) {
        this.mailProtocol = mailProtocol;
    }

    public void send(String message) {
        mailProtocol.send(message);
    }
}
