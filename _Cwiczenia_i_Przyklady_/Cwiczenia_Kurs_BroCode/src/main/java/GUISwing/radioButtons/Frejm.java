package GUISwing.radioButtons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frejm extends JFrame implements ActionListener {
    JRadioButton pizzaButton;
    JRadioButton hamburgerButton;
    JRadioButton hotdogButton;
    ImageIcon pizza = new ImageIcon("src/GUISwing/radioButtons/pizza.png");
    ImageIcon hamburger = new ImageIcon("src/GUISwing/radioButtons/hamburger.png");
    ImageIcon hotdog = new ImageIcon("src/GUISwing/radioButtons/hotdog.png");


    Frejm() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());

        pizzaButton = new JRadioButton("pizza");
        pizzaButton.addActionListener(this);
        pizzaButton.setIcon(pizza);

        hamburgerButton = new JRadioButton("hamburger");
        hamburgerButton.addActionListener(this);
        hamburgerButton.setIcon(hamburger);

        hotdogButton = new JRadioButton("hotdog");
        hotdogButton.addActionListener(this);
        hotdogButton.setIcon(hotdog);

        ButtonGroup group = new ButtonGroup();

        group.add(pizzaButton);
        group.add(hamburgerButton);
        group.add(hotdogButton);



        this.add(pizzaButton);
        this.add(hamburgerButton);
        this.add(hotdogButton);


        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pizzaButton) {
            System.out.println("Zamówi³eœ pizzê!");
        } else if (e.getSource() == hamburgerButton) {
            System.out.println("Zamówi³eœ hamburgera!");
        } else if (e.getSource() == hotdogButton) {
            System.out.println("Zamówi³eœ hotdoga!");
        }
    }
}
