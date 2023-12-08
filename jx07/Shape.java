package jx07;

import java.awt.Color;

public class Shape {
    String shapeType;
    Color color;
    int x1, y1, x2, y2;
    boolean isFilled;

    public Shape(String shapeType, Color color, int x1, int y1, int x2, int y2) {
        this.shapeType = shapeType;
        this.color = color;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.isFilled = false;
    }
}
