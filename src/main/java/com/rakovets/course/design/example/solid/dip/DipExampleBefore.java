package com.rakovets.course.design.example.solid.dip;

import com.rakovets.course.design.example.solid.dip.before.MailClient;

/**
 * D- инверсия контроля, зависеть надо от абстракций
 */
public class DipExampleBefore {
    private static MailClient mailClient;

    public static void main(String[] args) {
        mailClient = new MailClient();
        mailClient.sendMessage("test message");
    }
}

