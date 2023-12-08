package jx06;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyForm3 extends JFrame implements ActionListener {
    JTextField tf3;
    JButton print, clear;

    MyForm3() {
        setSize(360, 100);
        setResizable(false);
        setTitle("MyForm3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        tf3 = new JTextField("", 12);
        print = new JButton("Print");
        clear = new JButton("Clear");
        
        print.addActionListener(this);
        clear.addActionListener(this);

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout());

        btnPanel.add(print);
        btnPanel.add(clear);

        c.add(tf3, BorderLayout.NORTH);
        c.add(btnPanel, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == print){
            System.out.println(tf3.getText());
        } else if(e.getSource() == clear){
            tf3.setText("");
        }
    }

    public static void main(String[] args) {
        MyForm3 mf3 = new MyForm3();
        mf3.setVisible(true);
    }
}
