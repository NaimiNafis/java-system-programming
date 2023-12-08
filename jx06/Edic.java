package jx06;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Edic extends JFrame implements ActionListener {

    JTextField tf;
    JButton translate, clear, quit;
    JLabel translationLabel;

    Edic() {
        setSize(360, 120);
        setResizable(false);
        setTitle("Edic");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        tf = new JTextField("", 12);
        translate = new JButton("Translate");
        clear = new JButton("Clear");
        quit = new JButton("Quit");

        translationLabel = new JLabel();
        translationLabel.setHorizontalAlignment(JLabel.CENTER);

        translate.addActionListener(this);
        clear.addActionListener(this);
        quit.addActionListener(this);

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout());

        btnPanel.add(translate);
        btnPanel.add(clear);
        btnPanel.add(quit);

        c.add(tf, BorderLayout.NORTH);
        c.add(btnPanel, BorderLayout.CENTER);
        c.add(translationLabel, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == translate) {
            String translation = getTranslation(tf.getText());
            translationLabel.setText(translation);
        } else if (e.getSource() == clear) {
            tf.setText("");
            translationLabel.setText(" ");
        } else if (e.getSource() == quit) {
            System.exit(0);
        }
    }

    private String getTranslation(String word) {
        try (BufferedReader br = new BufferedReader(new FileReader("dic.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.equalsIgnoreCase(word)) {
                    if ((line = br.readLine()) != null) { // assume next line is the translation
                        return line;
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "Translation not found";
    }

    public static void main(String[] args) {
        Edic ed = new Edic();
        ed.setVisible(true);
    }
}
