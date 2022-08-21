import javax.swing.*;
import java.awt.*;

public class StatsField extends JPanel {
    Font boldFont = new Font("Courier", Font.BOLD, 24);
    Font plainFont = new Font("Courier", Font.PLAIN, 20);

    public StatsField() {
        setBounds(100,20,400,200);
        setLayout(new GridLayout(6, 2, 0, 0));
        setBackground(MyColor.BLUE_LIGHT);

        JLabel s1 = new JLabel("Iloœæ zwrotów: ");
        JLabel t1 = new JLabel("456");
        JLabel s2 = new JLabel("Przegroda 1: ");
        JLabel t2 = new JLabel("45");
        JLabel s3 = new JLabel("Przegroda 2: ");
        JLabel t3 = new JLabel("12");
        JLabel s4 = new JLabel("Przegroda 3: ");
        JLabel t4 = new JLabel("5");
        JLabel s5 = new JLabel("Przegroda 4: ");
        JLabel t5 = new JLabel("5");
        JLabel s6 = new JLabel("Przegroda 5: ");
        JLabel t6 = new JLabel("5");

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

        add(s1);
        add(t1);
        add(s2);
        add(t2);
        add(s3);
        add(t3);
        add(s4);
        add(t4);
        add(s5);
        add(t5);
        add(s6);
        add(t6);
    }

}
