package com.rakovets.course.design.example.pattern.abstract_factory.example.factories;

import com.rakovets.course.design.example.pattern.abstract_factory.example.buttons.Button;
import com.rakovets.course.design.example.pattern.abstract_factory.example.checkboxes.Checkbox;

/**
 * Абстрактная фабрика знает обо всех (абстрактных) типах продуктов.
 */
public interface GUIFactory {
    Button createButton();

    Checkbox createCheckbox();
}
