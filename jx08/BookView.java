package jx08;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookView extends JFrame implements ActionListener {
    private BookCtrl ctrl;
    private final JTextField tftitle, tfauthor, tfpublisher, tfisbn;
    private final JTextArea tflist;

    public BookView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setTitle("Book Search");

        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        EmptyBorder margin = new EmptyBorder(10, 10, 10, 10);

        JLabel ltitle = new JLabel("Title: ");
        JLabel lauthor = new JLabel("Author: ");
        JLabel lpublisher = new JLabel("Publisher: ");
        JLabel lisbn = new JLabel("ISBN: ");

        tftitle = new JTextField(20);
        tfauthor = new JTextField(20);
        tfpublisher = new JTextField(20);
        tfisbn = new JTextField(20);

        tflist = new JTextArea();
        JScrollPane sp = new JScrollPane(tflist);
        sp.setPreferredSize(new Dimension(40, 360));
        sp.setBorder(margin);

        JPanel inputPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        inputPanel.setBorder(margin);
        inputPanel.add(ltitle);
        inputPanel.add(tftitle);
        inputPanel.add(lauthor);
        inputPanel.add(tfauthor);
        inputPanel.add(lpublisher);
        inputPanel.add(tfpublisher);
        inputPanel.add(lisbn);
        inputPanel.add(tfisbn);

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout());
        btnPanel.setBorder(margin);

        JButton registerBtn = new JButton("Register");
        JButton searchBtn = new JButton("Search");
        JButton listBtn = new JButton("List");

        registerBtn.addActionListener(this);
        searchBtn.addActionListener(this);
        listBtn.addActionListener(this);

        btnPanel.add(registerBtn);
        btnPanel.add(searchBtn);
        btnPanel.add(listBtn);

        c.add(inputPanel, BorderLayout.NORTH);
        c.add(btnPanel, BorderLayout.CENTER);
        c.add(sp, BorderLayout.SOUTH);

    }

    public void setController(BookCtrl ctrl) {
        this.ctrl = ctrl;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Register":
                ctrl.registerBook(tftitle.getText(), tfauthor.getText(), tfpublisher.getText(), tfisbn.getText());
                JOptionPane.showMessageDialog(this, "Book Registered");
                break;
            case "Search":
                tflist.setText(ctrl.searchBook(tftitle.getText()));
                break;
            case "List":
                tflist.setText(ctrl.listBooks());
                break;
        }
        clearInputFields();
    }

    private void clearInputFields() {
        tftitle.setText("");
        tfauthor.setText("");
        tfpublisher.setText("");
        tfisbn.setText("");
    }
    
    public static void main(String[] args) {
        BookModel model = new BookModel();
        BookView view = new BookView();
        BookCtrl ctrl = new BookCtrl(model);

        view.setController(ctrl);
        view.setVisible(true);
    }
}
