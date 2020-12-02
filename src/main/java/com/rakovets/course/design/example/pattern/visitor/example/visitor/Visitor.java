package com.rakovets.course.design.example.pattern.visitor.example.visitor;

import com.rakovets.course.design.example.pattern.visitor.example.shapes.Circle;
import com.rakovets.course.design.example.pattern.visitor.example.shapes.CompoundShape;
import com.rakovets.course.design.example.pattern.visitor.example.shapes.Dot;
import com.rakovets.course.design.example.pattern.visitor.example.shapes.Rectangle;
import com.rakovets.course.design.example.pattern.visitor.example.shapes.Shape;

public interface Visitor {
    String export(Shape... shapes);

    String visitDot(Dot dot);

    String visitCircle(Circle circle);

    String visitRectangle(Rectangle rectangle);

    String visitCompoundGraphic(CompoundShape cg);
}
