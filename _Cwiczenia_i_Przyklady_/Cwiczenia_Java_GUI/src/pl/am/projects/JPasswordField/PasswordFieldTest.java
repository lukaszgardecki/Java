package pl.am.projects.JPasswordField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordFieldTest extends JFrame implements ActionListener {

    JPasswordField pHaslo;

    public PasswordFieldTest() {
        setTitle("Test Has³a");
        setSize(400, 400);
        setLayout(null);

        pHaslo = new JPasswordField();
        pHaslo.setBounds(50, 50, 150, 20);
        pHaslo.setEchoChar('$'); //zmiana symbolu wyœwietlania
        pHaslo.addActionListener(this);
        add(pHaslo);

    }

    public static void main(String[] args) {
        PasswordFieldTest app = new PasswordFieldTest();
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null,  new String(pHaslo.getPassword()));
    }
}
