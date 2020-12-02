package com.rakovets.course.design.example.pattern.adapter.example.adapters;

import com.rakovets.course.design.example.pattern.adapter.example.round.RoundPeg;
import com.rakovets.course.design.example.pattern.adapter.example.square.SquarePeg;

/**
 * Адаптер позволяет использовать КвадратныеКолышки и КруглыеОтверстия вместе.
 */
public class SquarePegAdapter extends RoundPeg {
    private SquarePeg peg;

    public SquarePegAdapter(SquarePeg peg) {
        this.peg = peg;
    }

    @Override
    public double getRadius() {
        double result;
        // Рассчитываем минимальный радиус, в который пролезет этот колышек.
        result = (Math.sqrt(Math.pow((peg.getWidth() / 2), 2) * 2));
        return result;
    }
}
