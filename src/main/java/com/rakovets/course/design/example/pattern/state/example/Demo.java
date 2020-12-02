package com.rakovets.course.design.example.pattern.state.example;

import com.rakovets.course.design.example.pattern.state.example.ui.Player;
import com.rakovets.course.design.example.pattern.state.example.ui.UI;

/**
 * Демо-класс. Здесь всё сводится воедино.
 */
public class Demo {
    public static void main(String[] args) {
        Player player = new Player();
        UI ui = new UI(player);
        ui.init();
    }
}
