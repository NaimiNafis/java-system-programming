package jx07;

import javax.swing.*;
import java.awt.*;

public class MyDraw3 extends JFrame {
    private DrawingPanel drawPanel;

    public MyDraw3() {
        setTitle("MyDraw3");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel title = new JLabel("Etch-a-Sketch!");
        title.setHorizontalAlignment(JLabel.CENTER);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(title, BorderLayout.NORTH);

        drawPanel = new DrawingPanel();
        c.add(new ButtonPanel(drawPanel), BorderLayout.WEST);
        c.add(drawPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        MyDraw3 md3 = new MyDraw3();
        md3.setVisible(true);
    }
}
