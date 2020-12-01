package com.rakovets.course.design.example.solid.dip;

import com.rakovets.course.design.example.solid.dip.before.Mailer;

/**
 * D- инверсия контроля, зависеть надо от абстракций
 */
public class DipExampleBefore {
    public static void main(String[] args) {
        Mailer mailer = new Mailer();
        mailer.sendMessage("test message");
    }
}

