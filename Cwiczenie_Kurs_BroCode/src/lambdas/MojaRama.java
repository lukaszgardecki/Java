package lambdas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MojaRama extends JFrame {

    JButton myButton = new JButton("MY BUTTON");
    JButton myButton2 = new JButton("MY BUTTON2");


    MojaRama() {

        myButton.setBounds(100, 100, 200, 100);
        myButton.addActionListener((e) -> System.out.println("naciœniêto button1"));

        myButton2.setBounds(100, 200, 200, 100);
        myButton2.addActionListener((e) -> System.out.println("naciœniêto button2"));

        this.add(myButton);
        this.add(myButton2);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(420, 420);
        this.setLayout(null);
        this.setVisible(true);
    }
}
