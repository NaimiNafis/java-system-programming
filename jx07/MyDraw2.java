package jx07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyDraw2 extends JFrame implements ActionListener, MouseListener {

	private JPanel drawPanel;
    private int x1, y1, x2, y2;
    private JButton line, rect, oval, black, red, green, clear, quit;
    private Color currentColor = Color.BLACK;
    private String currentShape = "";

    public MyDraw2() {
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("MyDraw2");
        setLocationRelativeTo(null);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        line = new JButton("Line");
        rect = new JButton("Rect");
        oval = new JButton("Oval");
        black = new JButton("Black");
        red = new JButton("Red");
        green = new JButton("Green");
        clear = new JButton("Clear");
        quit = new JButton("Quit");

        line.addActionListener(this);
        rect.addActionListener(this);
        oval.addActionListener(this);
        black.addActionListener(this);
        red.addActionListener(this);
        green.addActionListener(this);
        clear.addActionListener(this);
        quit.addActionListener(this);

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout());
        btnPanel.add(line);
        btnPanel.add(rect);
        btnPanel.add(oval);
        btnPanel.add(black);
        btnPanel.add(red);
        btnPanel.add(green);
        btnPanel.add(clear);
        btnPanel.add(quit);

        drawPanel = new JPanel();
        drawPanel.setBackground(Color.WHITE);
        drawPanel.addMouseListener(this);

        c.add(btnPanel, BorderLayout.SOUTH);
        c.add(drawPanel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clear) {
            drawPanel.repaint();
        } else if (e.getSource() == quit) {
            System.exit(0);
        } else if (e.getSource() == line) {
            currentShape = "Line";
        } else if (e.getSource() == rect) {
            currentShape = "Rect";
        } else if (e.getSource() == oval) {
            currentShape = "Oval";
        } else if (e.getSource() == black) {
            currentColor = Color.BLACK;
        } else if (e.getSource() == red) {
            currentColor = Color.RED;
        } else if (e.getSource() == green) {
            currentColor = Color.GREEN;
        }
    }

    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
    }

    public void mouseReleased(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();
        paint();
    }

    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public void paint() {
    	Graphics g = drawPanel.getGraphics();
        g.setColor(currentColor);
        if (currentShape.equals("Line")) {
            g.drawLine(x1, y1, x2, y2);
        } else if (currentShape.equals("Rect")) {
            g.drawRect(Math.min(x1, x2), Math.min(y1, y2),
                       Math.abs(x1 - x2), Math.abs(y1 - y2));
        } else if (currentShape.equals("Oval")) {
            g.drawOval(Math.min(x1, x2), Math.min(y1, y2),
                       Math.abs(x1 - x2), Math.abs(y1 - y2));
        }
    }
    
    public static void main(String[] args) {
        MyDraw2 md2 = new MyDraw2();
        md2.setVisible(true);
    }
}

