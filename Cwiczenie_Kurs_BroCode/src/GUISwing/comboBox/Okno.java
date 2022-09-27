package GUISwing.comboBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Okno extends JFrame implements ActionListener {

    JComboBox<String> comboBox;

    Okno() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());

        String[] animals = {"dog", "cat", "bird"};
        comboBox = new JComboBox<>(animals);
        comboBox.addActionListener(this);
        comboBox.addItem("horse");
        comboBox.insertItemAt("pig", 0);
        //comboBox.setEditable(true);
        System.out.println(comboBox.getItemCount());
        comboBox.setSelectedIndex(0);
        comboBox.remove(0);


        this.add(comboBox);

        this.pack();
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == comboBox) {
            System.out.println(comboBox.getSelectedItem());
            System.out.println(comboBox.getSelectedIndex());
        }
    }
}
