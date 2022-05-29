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
            menuPlik.add(mWyjscie);
            mWyjscie.addActionListener(this);
            //mo¿na wywo³aæ mWyjœcie jakimœ skrótem klawiszowym:
            mWyjscie.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));


        menuNarzedzia = new JMenu("Narzêdzia");
        menuBar.add(menuNarzedzia);
            mNarz1 = new JMenuItem("Narz1");
            //Mo¿emy wy³¹czyæ dan¹ pozycjê
            //mNarz1.setEnabled(false);
            menuNarzedzia.add(mNarz1);
            mNarz2 = new JMenuItem("Narz2");
            menuNarzedzia.add(mNarz2);
            menuOpcje = new JMenu("Opcje");
            menuNarzedzia.add(menuOpcje);
                mOpcja1 = new JMenuItem("Opcja 1");
                menuOpcje.add(mOpcja1);
                chOpcja2 = new JCheckBoxMenuItem ("Opcja 2");
                menuOpcje.add(chOpcja2);


        menuPomoc = new JMenu("Pomoc");
        menuBar.add(menuPomoc);
            mOProgramie = new JMenuItem("O programie");
            menuPomoc.add(mOProgramie);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object z = e.getSource();
        if (z==mWyjscie)
            dispose();

    }

    public static void main(String[] args) {
        JMenuTest2 appMenu = new JMenuTest2();
        appMenu.setVisible(true);
    }
}
