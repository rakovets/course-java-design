package com.rakovets.course.design.example.pattern.factory_method.example.factory;

import com.rakovets.course.design.example.pattern.factory_method.example.buttons.Button;
import com.rakovets.course.design.example.pattern.factory_method.example.buttons.HtmlButton;

/**
 * HTML-диалог.
 */
public class HtmlDialog extends Dialog {

    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
