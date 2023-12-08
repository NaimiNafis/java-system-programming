package jx06;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashMap;

public class Edic2 extends JFrame implements ActionListener {

    JTextField tf;
    JButton translate, clear, quit;
    JLabel translationLabel;
    private HashMap<String, String> text;

    Edic2() {
        this.setSize(360, 120);
        this.setResizable(false);
        this.setTitle("Edic");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

        text = new HashMap<>();
        loadDictionary();
    }

    private void loadDictionary() {
        try (BufferedReader br = new BufferedReader(new FileReader("dic.txt"))) {
            String eng;
            while ((eng = br.readLine()) != null) {
                String jp = br.readLine();
                if (jp != null) {
                    text.put(eng.toLowerCase(), jp);
                    text.put(jp, eng.toLowerCase());
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private String getTranslation(String word) {
        return text.getOrDefault(word.toLowerCase(), "Translation not found");
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

    public static void main(String[] args) {
        Edic2 ed = new Edic2();
        ed.setVisible(true);
    }
}
