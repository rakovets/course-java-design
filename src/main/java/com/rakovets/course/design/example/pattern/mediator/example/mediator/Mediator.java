package com.rakovets.course.design.example.pattern.mediator.example.mediator;

import com.rakovets.course.design.example.pattern.mediator.example.components.Component;

import javax.swing.*;

/**
 * Общий интерфейс посредников.
 */
public interface Mediator {
    void addNewNote(Note note);

    void deleteNote();

    void getInfoFromList(Note note);

    void saveChanges();

    void markNote();

    void clear();

    void sendToFilter(ListModel listModel);

    void setElementsList(ListModel list);

    void registerComponent(Component component);

    void hideElements(boolean flag);

    void createGUI();
}
