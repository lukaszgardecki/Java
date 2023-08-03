package GUISwing.label;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.image.BufferedImage;

public class Label {
    public static void main(String[] args) {

        ImageIcon image = new ImageIcon("src/GUISwing/label/logo.png");
        Border border = BorderFactory.createLineBorder(Color.GREEN, 3);


        JLabel label = new JLabel();
        label.setText("Bro, do you even code?");
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setForeground(new Color(0,255,0));
        label.setFont(new Font("MV Boli", Font.PLAIN, 20));
        label.setIconTextGap(100);
        label.setBackground(Color.black);

        // przezroczystoœæ
        label.setOpaque(true);

        //ustawienie zielonej ramki
        label.setBorder(border);

        // wyrównanie etykiety do srodka okna (etykiety)
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);




        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        //frame.setLayout(null);


        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.add(label);

        frame.pack();
    }
}
