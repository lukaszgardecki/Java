package program.elements.panels.views;

import program.Main;
import program.settings.MyColor;

import javax.swing.*;
import java.awt.*;

public class StatsField extends JPanel {
    Font boldFont = new Font("Courier", Font.BOLD, 24);
    Font plainFont = new Font("Courier", Font.PLAIN, 20);
    JLabel t1;
    static JLabel t2;
    static JLabel t3;
    static JLabel t4;
    static JLabel t5;
    static JLabel t6;

    public StatsField() {
        setBounds(100,30,400,200);
        setLayout(new GridLayout(6, 2, 0, 0));
        setBackground(MyColor.BLUE_LIGHT);

        JLabel s1 = new JLabel("Iloœæ zwrotów: ");
        t1 = new JLabel(String.valueOf(Main.amountOfWords));
        JLabel s2 = new JLabel("Poziom 1: ");
        t2 = new JLabel(String.valueOf(Main.map.get(1).size()));
        JLabel s3 = new JLabel("Poziom 2: ");
        t3 = new JLabel(String.valueOf(Main.map.get(2).size()));
        JLabel s4 = new JLabel("Poziom 3: ");
        t4 = new JLabel(String.valueOf(Main.map.get(3).size()));
        JLabel s5 = new JLabel("Poziom 4: ");
        t5 = new JLabel(String.valueOf(Main.map.get(4).size()));
        JLabel s6 = new JLabel("Poziom 5: ");
        t6 = new JLabel(String.valueOf(Main.map.get(5).size()));

        s1.setFont(plainFont);
        s2.setFont(plainFont);
        s3.setFont(plainFont);
        s4.setFont(plainFont);
        s5.setFont(plainFont);
        s6.setFont(plainFont);

        t1.setFont(boldFont);
        t2.setFont(boldFont);
        t3.setFont(boldFont);
        t4.setFont(boldFont);
        t5.setFont(boldFont);
        t6.setFont(boldFont);


        s2.setForeground(MyColor.RED);
        t2.setForeground(MyColor.RED);
        s3.setForeground(MyColor.ORANGE_DARK);
        t3.setForeground(MyColor.ORANGE_DARK);
        s4.setForeground(MyColor.ORANGE_LIGHT);
        t4.setForeground(MyColor.ORANGE_LIGHT);
        s5.setForeground(MyColor.YELLOW);
        t5.setForeground(MyColor.YELLOW);
        s6.setForeground(MyColor.GREEN);
        t6.setForeground(MyColor.GREEN);

        add(s6);
        add(t6);
        add(s5);
        add(t5);
        add(s4);
        add(t4);
        add(s3);
        add(t3);
        add(s2);
        add(t2);
        add(s1);
        add(t1);
    }

}
