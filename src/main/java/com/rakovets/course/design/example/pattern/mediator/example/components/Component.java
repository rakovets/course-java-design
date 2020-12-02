package com.rakovets.course.design.example.pattern.mediator.example.components;

import com.rakovets.course.design.example.pattern.mediator.example.mediator.Mediator;

/**
 * Общий интерфейс компонентов.
 */
public interface Component {
    void setMediator(Mediator mediator);

    String getName();
}
