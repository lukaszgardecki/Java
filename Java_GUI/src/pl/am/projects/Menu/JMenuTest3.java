package pl.am.projects.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class JMenuTest3 extends JFrame implements ActionListener {

    JMenuBar menuBar;
    JMenu menuPlik, menuNarzedzia, menuOpcje, menuPomoc;
    JMenuItem mOtworz, mZapisz, mWyjscie, mNarz1, mNarz2, mOpcja1, mOProgramie;
    JCheckBoxMenuItem chOpcja2;


    public JMenuTest3() {
        setSize(800, 800);
        setTitle("Demonstracja JMenuBar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        menuPlik = new JMenu("Plik");
        menuBar.add(menuPlik);
            mOtworz = new JMenuItem("Owórz", 'O');
            mOtworz.addActionListener(this);
            menuPlik.add(mOtworz);
            mZapisz = new JMenuItem("Zapisz", 'Z');
            mZapisz.addActionListener(this);
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
            mNarz2 = new JMenuItem("Metry na Stopy");
            mNarz2.addActionListener(this);
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

        if (z == mOtworz) {
            JFileChooser fc = new JFileChooser();
            if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File plik = fc.getSelectedFile();
                JOptionPane.showMessageDialog(null,"Wybrany plik to " + plik.getAbsolutePath());
            }
        } else if (z == mZapisz) {
            JFileChooser fc = new JFileChooser();
            if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                File plik = fc.getSelectedFile();
                JOptionPane.showMessageDialog(null,"Wybrany plik to " + plik);
            }
        } else if (z == mWyjscie) {
            int odp = JOptionPane.showConfirmDialog(null, "Czy na pewno wyjœæ?", "Pytanie", JOptionPane.YES_NO_OPTION);

            if (odp == JOptionPane.YES_OPTION)
                dispose();
            else if (odp == JOptionPane.NO_OPTION)
                JOptionPane.showMessageDialog(null, "Wiedzia³em...");
            else if (odp == JOptionPane.CANCEL_OPTION)
                JOptionPane.showMessageDialog(null, "Tak nie robimy", "Tytu³", JOptionPane.WARNING_MESSAGE);
        }

        if (z == chOpcja2) {
            if (chOpcja2.isSelected()) {
                mNarz1.setEnabled(true);
            } else if (!chOpcja2.isSelected())
                mNarz1.setEnabled(false);
        }

        if (z == mNarz2) {
            String sMetry = JOptionPane.showInputDialog("Podaj d³ugoœæ w metrach");
            double metry = Double.parseDouble(sMetry);
            double stopy = metry / 0.3048;
            String sStopy = String.format("%.2f", stopy);
            JOptionPane.showMessageDialog(null, metry + " metrów =" + sStopy + " stóp");
        }

        if (z == mOProgramie) {
            //wyœwietlenie okna dialogowego
            JOptionPane.showMessageDialog(null, "Program demonstruje wykorzystanie JMenuBar i JMenu \n Wersja 1.0");
        }

    }

    public static void main(String[] args) {
        JMenuTest3 appMenu = new JMenuTest3();
        appMenu.setVisible(true);
    }
}
