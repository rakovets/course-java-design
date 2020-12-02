package com.rakovets.course.design.example.pattern.state.example.states;

import com.rakovets.course.design.example.pattern.state.example.ui.Player;

/**
 * Общий интерфейс всех состояний.
 */
public abstract class State {
    Player player;

    /**
     * Контекст передаёт себя в конструктор состояния, чтобы состояние могло
     * обращаться к его данным и методам в будущем, если потребуется.
     */
    State(Player player) {
        this.player = player;
    }

    public abstract String onLock();

    public abstract String onPlay();

    public abstract String onNext();

    public abstract String onPrevious();
}
