package com.rakovets.course.design.example.pattern.mediator.example;

import com.rakovets.course.design.example.pattern.mediator.example.components.AddButton;
import com.rakovets.course.design.example.pattern.mediator.example.components.DeleteButton;
import com.rakovets.course.design.example.pattern.mediator.example.components.Filter;
import com.rakovets.course.design.example.pattern.mediator.example.components.List;
import com.rakovets.course.design.example.pattern.mediator.example.components.SaveButton;
import com.rakovets.course.design.example.pattern.mediator.example.components.TextBox;
import com.rakovets.course.design.example.pattern.mediator.example.components.Title;
import com.rakovets.course.design.example.pattern.mediator.example.mediator.Editor;
import com.rakovets.course.design.example.pattern.mediator.example.mediator.Mediator;

import javax.swing.*;

/**
 * Демо-класс. Здесь всё сводится воедино.
 */
public class Demo {
    public static void main(String[] args) {
        Mediator mediator = new Editor();

        mediator.registerComponent(new Title());
        mediator.registerComponent(new TextBox());
        mediator.registerComponent(new AddButton());
        mediator.registerComponent(new DeleteButton());
        mediator.registerComponent(new SaveButton());
        mediator.registerComponent(new List(new DefaultListModel()));
        mediator.registerComponent(new Filter());

        mediator.createGUI();
    }
}
