package GUISwing.progressBar;

import javax.swing.*;
import java.awt.*;

public class ProgressBarDemo {

    int maxValue = 100;
    JFrame frame = new JFrame();
    JProgressBar bar = new JProgressBar(0, maxValue);

    ProgressBarDemo() {

        bar.setValue(0);
        bar.setBounds(0, 0, 420, 50);
        bar.setStringPainted(true);
        bar.setFont(new Font("MV Boli", Font.BOLD, 25));
        bar.setForeground(Color.red);
        bar.setBackground(Color.black);

        frame.add(bar);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);


        fill();
    }

    private void fill() {
        int counter = 0;

        while (counter <= maxValue) {
            bar.setValue(counter);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter++;
        }
        bar.setString("Zrobione!");
    }
}
