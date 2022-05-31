package pl.am.projects.JPasswordField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordFieldTest2 extends JFrame implements ActionListener {

    private JTextArea notatnik;
    private JScrollPane scrollPane;
    private JButton bDodajUzytkownika;
    private PanelHasla panelHasla1;

    public PasswordFieldTest2() {
        setTitle("Test Has³a");
        setSize(400, 400);
        setLayout(null);

        notatnik = new JTextArea();
        notatnik.setWrapStyleWord(true);

        scrollPane = new JScrollPane(notatnik);
        scrollPane.setBounds(0, 0, 300, 200);
        add(scrollPane);

        bDodajUzytkownika = new JButton("Dodaj u¿ytkownika");
        bDodajUzytkownika.setBounds(0, 250, 150, 20);
        bDodajUzytkownika.addActionListener(this);
        add(bDodajUzytkownika);
    }

    public static void main(String[] args) {
        PasswordFieldTest2 app = new PasswordFieldTest2();
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (panelHasla1 == null)
            panelHasla1 = new PanelHasla(null);
        panelHasla1.setVisible(true);
        panelHasla1.setFocus();

        if (panelHasla1.isOK()) {
            notatnik.append(panelHasla1.getUser() + ", ");
            notatnik.append(panelHasla1.getPassword() + "\n");
        }
    }
}

class PanelHasla extends JDialog implements ActionListener {

    private JLabel lUser, lHaslo;
    private JTextField tUser;
    private JPasswordField pHaslo;
    private JButton bOK, bCancel;
    private boolean okData;

    //to jest konstruktor!
    public PanelHasla(JFrame owner) {
        super(owner, "Wprowadzenie has³a", true);
        setSize(300, 200);
        setLayout(null);

        lUser = new JLabel("U¿ytkownik", JLabel.RIGHT);
        lUser.setBounds(0, 0, 100, 20);
        add(lUser);

        tUser = new JTextField();
        tUser.setBounds(150, 0, 100, 20);
        add(tUser);

        lHaslo = new JLabel("Has³o", JLabel.RIGHT);
        lHaslo.setBounds(0, 50, 100, 20);
        add(lHaslo);

        pHaslo = new JPasswordField();
        pHaslo.setBounds(150, 50, 100, 20);
        add(pHaslo);

        bOK = new JButton("OK");
        bOK.setBounds(0, 100, 100, 20);
        bOK.addActionListener(this);
        add(bOK);

        bCancel = new JButton("Cancel");
        bCancel.setBounds(150, 100, 100, 20);
        bCancel.addActionListener(this);
        add(bCancel);
    }

    public String getUser() {
        return tUser.getText();
    }

    public String getPassword() {
        return new String(pHaslo.getPassword());
    }

    public boolean isOK() {
        return okData;
    }

    public void setFocus() {
        tUser.requestFocusInWindow();
    }



    @Override

    public void actionPerformed(ActionEvent e) {
        Object z = e.getSource();

        if (z == bOK)
            okData = true;

        else
            okData = false;
           setVisible(false);
    }
}

