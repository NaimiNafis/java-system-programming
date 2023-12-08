package jx07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyDraw extends JFrame implements MouseListener{

	private JPanel drawPanel;
	private int x1, y1, x2, y2;

    public MyDraw() {
    	setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("MyDraw2");
        setLocationRelativeTo(null);
    	
    	drawPanel = new JPanel();
        drawPanel.setBackground(Color.WHITE);
        drawPanel.addMouseListener(this);
        add(drawPanel, BorderLayout.CENTER);
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
		Graphics g = getGraphics();
		g.setColor(Color.BLACK);
		g.drawLine(x1, y1, x2, y2);
	}

    public static void main(String[] args) {
        MyDraw md = new MyDraw();
        md.setVisible(true);
    }
}

