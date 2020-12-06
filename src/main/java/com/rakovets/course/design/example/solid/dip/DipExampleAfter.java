package com.rakovets.course.design.example.solid.dip;

import com.rakovets.course.design.example.solid.dip.after.Imap4Protocol;
import com.rakovets.course.design.example.solid.dip.after.MailClient;
import com.rakovets.course.design.example.solid.dip.after.SmtpProtocol;

/**
 * D- инверсия контроля, зависеть надо от абстракций
 */
public class DipExampleAfter {
    private static MailClient mailClient;

    public static void main(String[] args) {
        mailClient = new MailClient(new SmtpProtocol());
        mailClient.send("message");

        mailClient = new MailClient(new Imap4Protocol());
        mailClient.send("message");
    }
}

