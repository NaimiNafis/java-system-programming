package jx07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class DrawingPanel extends JPanel {
    private int x1, y1, x2, y2;
    private Color currentColor = Color.BLACK;
    private String currentShape = "";
    private HashMap<Integer, Shape> shapes = new HashMap<>();
    private int shapeCounter = 0;
    private boolean isDrawing = false;

    public DrawingPanel() {
        setBackground(Color.WHITE);
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if ("fillColor".equals(currentShape)) {
                    fillShapeIfClicked(e.getX(), e.getY());
                } else {
                    x1 = e.getX();
                    y1 = e.getY();
                }
            }

            public void mouseReleased(MouseEvent e) {
                if (!"fillColor".equals(currentShape)) {
                    x2 = e.getX();
                    y2 = e.getY();
                    shapes.put(shapeCounter++, new Shape(currentShape, currentColor, x1, y1, x2, y2));
                    isDrawing = false;
                    repaint();
                }
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (!"fillColor".equals(currentShape)) {
                    x2 = e.getX();
                    y2 = e.getY();
                    isDrawing = true;
                    repaint();
                }
            }
        });
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        shapes.values().forEach(shape -> drawShape(g, shape));
        if (isDrawing) {
            drawShape(g, new Shape(currentShape, currentColor, x1, y1, x2, y2));
        }
    }

    private void drawShape(Graphics g, Shape shape) {
        g.setColor(shape.color);
        int x = Math.min(shape.x1, shape.x2);
        int y = Math.min(shape.y1, shape.y2);
        int width = Math.abs(shape.x1 - shape.x2);
        int height = Math.abs(shape.y1 - shape.y2);

        switch (shape.shapeType) {
            case "Line":
                g.drawLine(shape.x1, shape.y1, shape.x2, shape.y2);
                break;
            case "Rect":
                if (shape.isFilled) {
                    g.fillRect(x, y, width, height);
                } else {
                    g.drawRect(x, y, width, height);
                }
                break;
            case "Oval":
                if (shape.isFilled) {
                    g.fillOval(x, y, width, height);
                } else {
                    g.drawOval(x, y, width, height);
                }
                break;
        }
    }

    private void fillShapeIfClicked(int clickX, int clickY) {
        for (Shape shape : shapes.values()) {
            if ("Rect".equals(shape.shapeType) || "Oval".equals(shape.shapeType)) {
                int x = Math.min(shape.x1, shape.x2);
                int y = Math.min(shape.y1, shape.y2);
                int width = Math.abs(shape.x1 - shape.x2);
                int height = Math.abs(shape.y1 - shape.y2);

                if (clickX >= x && clickX <= x + width && clickY >= y && clickY <= y + height) {
                    shape.isFilled = !shape.isFilled; //undo
                    repaint();
                    break; // stop once the first shape is filled
                }
            }
        }
    }

    public void setCurrentColor(Color color) {
        this.currentColor = color;
    }

    public void setCurrentShape(String shape) {
        this.currentShape = shape;
    }

    public void clearShapes() {
        shapes.clear();
        repaint();
    }
}
