package com.rakovets.course.design.example.pattern.factory_method.example.factory;

import com.rakovets.course.design.example.pattern.factory_method.example.buttons.Button;
import com.rakovets.course.design.example.pattern.factory_method.example.buttons.WindowsButton;

/**
 * Диалог на элементах операционной системы.
 */
public class WindowsDialog extends Dialog {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
