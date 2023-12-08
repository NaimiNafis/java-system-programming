package jx08;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalcView extends JFrame implements ActionListener {
    private CalcCtrl ctrl;
    private Container c;
    private JLabel leq, lres; 
    private JTextField tf1, tfop, tf2;
    private JButton b1, b2;

    public CalcView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setTitle("Calculator");

        ctrl = new CalcCtrl();
        
        c = getContentPane();
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        tf1 = new JTextField(5);
        tfop = new JTextField("", 1); 
        tf2 = new JTextField(5);
        leq = new JLabel("=");

        lres = new JLabel(""); 
        lres.setPreferredSize(new Dimension(50, 20)); 

        inputPanel.add(tf1);
        inputPanel.add(tfop);
        inputPanel.add(tf2);
        inputPanel.add(leq);
        inputPanel.add(lres);

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout());

        b1 = new JButton("Calc");
        b2 = new JButton("Clear");

        btnPanel.add(b1);
        btnPanel.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        c.add(inputPanel);
        c.add(btnPanel);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                double num1 = Double.parseDouble(tf1.getText());
                double num2 = Double.parseDouble(tf2.getText());
                String operation = tfop.getText();
                double res = ctrl.calc(operation, num1, num2);
                lres.setText(String.format("%.2f", res));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Enter valid numbers");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        } else if (e.getSource() == b2) {
            tf1.setText("");
            tf2.setText("");
            tfop.setText(""); 
            lres.setText("");
        }
    }

    public static void main(String[] args) {
        CalcView view = new CalcView();
        view.setVisible(true);
    }
}
