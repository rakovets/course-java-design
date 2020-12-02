package com.rakovets.course.design.example.pattern.visitor.example.shapes;

import com.rakovets.course.design.example.pattern.visitor.example.visitor.Visitor;

public interface Shape {
    void move(int x, int y);

    void draw();

    String accept(Visitor visitor);
}
