package com.rakovets.course.design.example.pattern.abstract_factory.example.buttons;

/**
 * Все семейства продуктов имеют одни и те же вариации (MacOS/Windows).
 * <p>
 * Это вариант кнопки под MacOS.
 */
public class MacOSButton implements Button {

    @Override
    public void paint() {
        System.out.println("You have created MacOSButton.");
    }
}
