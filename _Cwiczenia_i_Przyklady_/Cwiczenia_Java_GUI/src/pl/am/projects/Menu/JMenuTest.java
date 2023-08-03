package pl.am.projects.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JMenuTest extends JFrame implements ActionListener {

    JMenuBar menuBar;
    JMenu menuPlik, menuNarzedzia, menuOpcje, menuPomoc;
    JMenuItem mOtworz, mZapisz, mWyjscie, mNarz1, mNarz2, mOpcja1, mOpcja2, mOProgramie;

    public JMenuTest() {
        setSize(800, 800);
        setTitle("Demonstracja JMenuBar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        menuPlik = new JMenu("Plik");
        menuBar.add(menuPlik);
            mOtworz = new JMenuItem("Owórz");
            menuPlik.add(mOtworz);
            mZapisz = new JMenuItem("Zapisz");
            menuPlik.add(mZapisz);
            menuPlik.addSeparator();
            mWyjscie = new JMenuItem("Wyjœcie");
            menuPlik.add(mWyjscie);


        menuNarzedzia = new JMenu("Narzêdzia");
        menuBar.add(menuNarzedzia);
            mNarz1 = new JMenuItem("Narz1");
            menuNarzedzia.add(mNarz1);
            mNarz2 = new JMenuItem("Narz2");
            menuNarzedzia.add(mNarz2);
            menuOpcje = new JMenu("Opcje");
            menuNarzedzia.add(menuOpcje);
                mOpcja1 = new JMenuItem("Opcja 1");
                menuOpcje.add(mOpcja1);
                mOpcja2 = new JMenuItem("Opcja 2");
                menuOpcje.add(mOpcja2);


        menuPomoc = new JMenu("Pomoc");
        menuBar.add(menuPomoc);
            mOProgramie = new JMenuItem("O programie");
            menuPomoc.add(mOProgramie);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        JMenuTest appMenu = new JMenuTest();
        appMenu.setVisible(true);
    }
}
