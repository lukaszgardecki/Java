package pl.am.projects.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class JMenuTest3 extends JFrame implements ActionListener {

    JMenuBar menuBar;
    JButton bSzukaj;
    JMenu menuPlik, menuNarzedzia, menuOpcje, menuPomoc;
    JMenuItem mOtworz, mZapisz, mWyjscie, mNarz1, mNarz2, mOpcja1, mOProgramie;
    JCheckBoxMenuItem chOpcja2;
    JTextArea notatnik;
    JTextField tSzukany;


    public JMenuTest3() {
        setSize(800, 800);
        setTitle("Demonstracja JMenuBar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        menuPlik = new JMenu("Plik");
        menuBar.add(menuPlik);
            mOtworz = new JMenuItem("Ow�rz", 'O');
            mOtworz.addActionListener(this);
            menuPlik.add(mOtworz);

            mZapisz = new JMenuItem("Zapisz", 'Z');
            mZapisz.addActionListener(this);
            mZapisz.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
            menuPlik.add(mZapisz);

            menuPlik.addSeparator();

            mWyjscie = new JMenuItem("Wyj�cie");
            mWyjscie.addActionListener(this);
            mWyjscie.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));   //mo�na wywo�a� mWyj�cie jakim� skr�tem klawiszowym:
            menuPlik.add(mWyjscie);


        menuNarzedzia = new JMenu("Narz�dzia");
        menuBar.add(menuNarzedzia);
            mNarz1 = new JMenuItem("Narz�dzia 1");
            //Mo�emy wy��czy� dan� pozycj�
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

            //Stworzenie pola edycyjnego
        notatnik = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(notatnik);
        scrollPane.setBounds(50, 50, 500, 500);
        add(scrollPane);

        tSzukany = new JTextField();
        tSzukany.setBounds(50, 700, 140, 20);
        add(tSzukany);

        bSzukaj = new JButton("Szukaj");
        bSzukaj.setBounds(200, 700, 100, 20);
        bSzukaj.addActionListener(this);
        add(bSzukaj);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object z = e.getSource();

        if (z == mOtworz) {
            JFileChooser fc = new JFileChooser();
            if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File plik = fc.getSelectedFile();
                //JOptionPane.showMessageDialog(null,"Wybrany plik to " + plik.getAbsolutePath());
                try {
                    Scanner scaner = new Scanner(plik);
                    while (scaner.hasNext()) {
                        notatnik.append(scaner.nextLine() + "\n");
                    }
                } catch (FileNotFoundException  el) {
                    el.printStackTrace();
                }
            }
        } else if (z == mZapisz) {
            JFileChooser fc = new JFileChooser();
            if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                File plik = fc.getSelectedFile();
                try {
                    PrintWriter pw = new PrintWriter(plik);
                    Scanner scaner = new Scanner(notatnik.getText());
                    while (scaner.hasNext())
                        pw.println(scaner.nextLine() + "\n");
                    pw.close();     //trzeba zamkn�� printWriter! bo si� plik nie zapisze!!!
                } catch (FileNotFoundException el) {
                    el.printStackTrace();
                }
                //JOptionPane.showMessageDialog(null,"Wybrany plik to " + plik);
            }
        } else if (z == mWyjscie) {
            int odp = JOptionPane.showConfirmDialog(null, "Czy na pewno wyj��?", "Pytanie", JOptionPane.YES_NO_OPTION);

            if (odp == JOptionPane.YES_OPTION)
                dispose();
            else if (odp == JOptionPane.NO_OPTION)
                JOptionPane.showMessageDialog(null, "Wiedzia�em...");
            else if (odp == JOptionPane.CANCEL_OPTION)
                JOptionPane.showMessageDialog(null, "Tak nie robimy", "Tytu�", JOptionPane.WARNING_MESSAGE);
        } else if (z == bSzukaj) {
            String tekst = notatnik.getText();
            String szukane = tSzukany.getText();
            String wystapienia = "";
            int i = 0;
            int index;
            int startIndex = 0;

            //p�tla wyszukuj�ca tekst !!!!!
            while ((index = tekst.indexOf(szukane, startIndex)) != -1) {
                startIndex = index + szukane.length();
                i++;
                wystapienia += " " + index;
            }
            JOptionPane.showMessageDialog(null, szukane + " wyst�pi�o " + i + " razy: " + wystapienia);
        }

        if (z == chOpcja2) {
            if (chOpcja2.isSelected()) {
                mNarz1.setEnabled(true);
            } else if (!chOpcja2.isSelected())
                mNarz1.setEnabled(false);
        }

        if (z == mNarz2) {
            String sMetry = JOptionPane.showInputDialog("Podaj d�ugo�� w metrach");
            double metry = Double.parseDouble(sMetry);
            double stopy = metry / 0.3048;
            String sStopy = String.format("%.2f", stopy);
            JOptionPane.showMessageDialog(null, metry + " metr�w =" + sStopy + " st�p");
        }

        if (z == mOProgramie) {
            //wy�wietlenie okna dialogowego
            JOptionPane.showMessageDialog(null, "Program demonstruje wykorzystanie JMenuBar i JMenu \n Wersja 1.0");
        }

    }

    public static void main(String[] args) {
        JMenuTest3 appMenu = new JMenuTest3();
        appMenu.setVisible(true);
    }
}
