package GUISwing.colorChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MojaKolorowaRamka extends JFrame implements ActionListener {

    JButton button;
    JLabel label;

    MojaKolorowaRamka() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());

        button = new JButton("Wybierz kolor");

        button.addActionListener(this);

        label = new JLabel();
        label.setBackground(Color.white);
        label.setText("To jest test");
        label.setFont(new Font("MV Boli", Font.PLAIN, 100));
        label.setOpaque(true);

        this.add(button);
        this.add(label);

        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            JColorChooser colorChooser = new JColorChooser();

            Color color = JColorChooser.showDialog(null, "Wybierz kolor", Color.black);

            label.setForeground(color);
        }
    }
}
