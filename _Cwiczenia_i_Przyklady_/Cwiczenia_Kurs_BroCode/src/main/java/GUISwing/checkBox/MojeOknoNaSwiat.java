package GUISwing.checkBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MojeOknoNaSwiat extends JFrame implements ActionListener {
    JButton button;
    JCheckBox checkBox;

    MojeOknoNaSwiat() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());

        button = new JButton();
        button.setText("submit");
        button.addActionListener(this);

        checkBox = new JCheckBox();
        checkBox.setText("Nie jestem robotem");
        checkBox.setFocusable(false); //--> nie ma tej ramki dooko³a tekstu
        checkBox.setFont(new Font("Consolas", Font.PLAIN, 35));

        this.add(button);
        this.add(checkBox);

        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button) {
            checkBox.isSelected();
        }
    }
}
