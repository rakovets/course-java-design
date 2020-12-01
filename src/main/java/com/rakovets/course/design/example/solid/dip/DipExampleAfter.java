package com.rakovets.course.design.example.solid.dip;

import com.rakovets.course.design.example.solid.dip.after.Imap4Protocol;
import com.rakovets.course.design.example.solid.dip.after.MailProtocol;
import com.rakovets.course.design.example.solid.dip.after.SmtpProtocol;

/**
 * D- инверсия контроля, зависеть надо от абстракций
 */
public class DipExampleAfter {
    private static MailProtocol mailProtocol;

    public static void main(String[] args) {
        mailProtocol = new SmtpProtocol();
        mailProtocol.send("message");

        mailProtocol = new Imap4Protocol();
        mailProtocol.send("message");
    }
}

