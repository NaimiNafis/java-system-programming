package jx07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class ButtonPanel extends JPanel {
    private DrawingPanel drawingPanel;

    public ButtonPanel(DrawingPanel drawingPanel) {
        this.drawingPanel = drawingPanel;
        setLayout(new GridLayout(10, 1));
        String[] buttons = {"Line", "Rect", "Oval", "Black", "Red", "Green", "randomColor", "fillColor", "Clear", "Quit"};
        Color backgroundColor = new Color(102, 191, 191);
        Color textColor = new Color(247, 107, 138);

        for (String buttonText : buttons) {
            JButton button = new JButton(buttonText);
            button.setBackground(backgroundColor);
            button.setForeground(textColor);
            button.addActionListener(this::buttonActionPerformed);
            add(button);
        }
    }

    private void buttonActionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Clear":
                drawingPanel.clearShapes();
                break;
            case "Quit":
                int response = JOptionPane.showConfirmDialog(this,
                        "Are you sure you want to quit?",
                        "Confirm Exit",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
                break;
            default:
                handleShapeColorChange(command);
        }
    }

    private void handleShapeColorChange(String command) {
        switch (command) {
            case "Line":
            case "Rect":
            case "Oval":
                drawingPanel.setCurrentShape(command);
                break;
            case "Black":
                drawingPanel.setCurrentColor(Color.BLACK);
                break;
            case "Red":
                drawingPanel.setCurrentColor(Color.RED);
                break;
            case "Green":
                drawingPanel.setCurrentColor(Color.GREEN);
                break;
            case "randomColor":
                Random rand = new Random();
                float r = rand.nextFloat();
                float g = rand.nextFloat();
                float b = rand.nextFloat();
                drawingPanel.setCurrentColor(new Color(r, g, b));
                break;
            case "fillColor":
                drawingPanel.setCurrentShape(command);
                break;
        }
    }
    
    
}
