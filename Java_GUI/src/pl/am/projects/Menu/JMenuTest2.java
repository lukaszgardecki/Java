package pl.am.projects.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JMenuTest2 extends JFrame implements ActionListener {

    JMenuBar menuBar;
    JMenu menuPlik, menuNarzedzia, menuOpcje, menuPomoc;
    JMenuItem mOtworz, mZapisz, mWyjscie, mNarz1, mNarz2, mOpcja1, mOProgramie;
    JCheckBoxMenuItem chOpcja2;


    public JMenuTest2() {
        setSize(800, 800);
        setTitle("Demonstracja JMenuBar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        menuPlik = new JMenu("Plik");
        menuBar.add(menuPlik);
            mOtworz = new JMenuItem("Owórz", 'O');
            menuPlik.add(mOtworz);
            mZapisz = new JMenuItem("Zapisz", 'Z');
            menuPlik.add(mZapisz);
            menuPlik.addSeparator();
            mWyjscie = new JMenuItem("Wyjœcie");
            mWyjscie.addActionListener(this);
            menuPlik.add(mWyjscie);
            //mo¿na wywo³aæ mWyjœcie jakimœ skrótem klawiszowym:
            mWyjscie.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));


        menuNarzedzia = new JMenu("Narzêdzia");
        menuBar.add(menuNarzedzia);
            mNarz1 = new JMenuItem("Narzêdzia 1");
            //Mo¿emy wy³¹czyæ dan¹ pozycjê
            //mNarz1.setEnabled(false);
            menuNarzedzia.add(mNarz1);
            mNarz2 = new JMenuItem("Narzêdzia 2");
            menuNarzedzia.add(mNarz2);
            menuOpcje = new JMenu("Opcje");
            menuNarzedzia.add(menuOpcje);
                mOpcja1 = new JMenuItem("Opcja 1");
                menuOpcje.add(mOpcja1);
                chOpcja2 = new JCheckBoxMenuItem ("Opcja 2");
                chOpcja2.addActionListener(this);
                menuOpcje.add(chOpcja2);


        menuPomoc = new JMenu("Pomoc");
        menuBar.add(menuPomoc);
            mOProgramie = new JMenuItem("O programie");
            mOProgramie.addActionListener(this);
            menuPomoc.add(mOProgramie);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object z = e.getSource();
        if (z==mWyjscie)
            dispose();
        if (z == chOpcja2) {
            if (chOpcja2.isSelected()) {
                mNarz1.setEnabled(true);
            } else if (!chOpcja2.isSelected())
                mNarz1.setEnabled(false);
        }
        if (z == mOProgramie) {
            //wyœwietlenie okna dialogowego
            JOptionPane.showMessageDialog(this, "Program demonstruje wykorzystanie JMenuBar i JMenu \n Wersja 1.0");
        }

    }

    public static void main(String[] args) {
        JMenuTest2 appMenu = new JMenuTest2();
        appMenu.setVisible(true);
    }
}
