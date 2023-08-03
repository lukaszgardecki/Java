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
    JButton bSzukaj, bWybierzKolor;
    JPopupMenu popup;
    JMenu menuPlik, menuNarzedzia, menuOpcje, menuLookAndFeel, menuPomoc;
    JMenuItem mOtworz, mZapisz, mWyjscie, mNarz1, mNarz2, mOpcja1, mpCopy, mpPaste, mpAdd, mMetal, mNimbus, mWindows, mOProgramie;
    JCheckBoxMenuItem chOpcja2;
    JTextArea notepad;
    JTextField tSzukany;
    String wybranyTekst;
    JComboBox colorCombo;


    public JMenuTest3() {
        setSize(800, 800);
        setTitle("Notatnik");
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
            mZapisz.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
            menuPlik.add(mZapisz);

            menuPlik.addSeparator();

            mWyjscie = new JMenuItem("Wyjœcie");
            mWyjscie.addActionListener(this);
            mWyjscie.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));   //mo¿na wywo³aæ mWyjœcie jakimœ skrótem klawiszowym:
            menuPlik.add(mWyjscie);


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
                chOpcja2 = new JCheckBoxMenuItem("Opcja 2");
                chOpcja2.addActionListener(this);
                menuOpcje.add(chOpcja2);

        menuLookAndFeel = new JMenu("Look And Feel");
        menuBar.add(menuLookAndFeel);
            mMetal = new JMenuItem("Metal");
            mMetal.addActionListener(this);
            menuLookAndFeel.add(mMetal);
            mNimbus = new JMenuItem("Nimbus");
            mNimbus.addActionListener(this);
            menuLookAndFeel.add(mNimbus);
            mWindows = new JMenuItem("Windows");
            mWindows.addActionListener(this);
            menuLookAndFeel.add(mWindows);

        menuPomoc = new JMenu("Pomoc");
        menuBar.add(menuPomoc);
        mOProgramie = new JMenuItem("O programie");
        mOProgramie.addActionListener(this);
        menuPomoc.add(mOProgramie);

        //Stworzenie pola edycyjnego
        notepad = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(notepad);
        scrollPane.setBounds(50, 50, 500, 500);
        add(scrollPane);

        //Stworzenie pola wyszukuj¹cego
        tSzukany = new JTextField();
        tSzukany.setBounds(50, 700, 140, 20);
        add(tSzukany);

        //przycisk Szukaj:
        bSzukaj = new JButton("Szukaj");
        bSzukaj.setBounds(200, 700, 100, 20);
        bSzukaj.addActionListener(this);
        add(bSzukaj);

        //przycisk Wybierz Kolor
        bWybierzKolor = new JButton("Wybierz Kolor");
        bWybierzKolor.setBounds(350, 700, 150, 20);
        bWybierzKolor.addActionListener(this);
        add(bWybierzKolor);

        //Menu kontekstowe
        popup = new JPopupMenu();
        mpCopy = new JMenuItem("Kopiuj");
        mpCopy.addActionListener(this);
        popup.add(mpCopy);

        mpPaste = new JMenuItem("Wklej");
        mpPaste.addActionListener(this);
        popup.add(mpPaste);

        mpAdd = new JMenuItem("Dodaj");
        mpAdd.addActionListener(this);
        popup.add(mpAdd);

        notepad.setComponentPopupMenu(popup);

        //Stworzenie ComboBoxa z nazwami kolorów:
        colorCombo = new JComboBox();
        colorCombo.setBounds(600, 50, 100, 20);
        colorCombo.addItem("czarny");
        colorCombo.addItem("czerwony");
        colorCombo.addItem("zielony");
        colorCombo.addItem("niebieski");
        colorCombo.addItem("ró¿owy");
        colorCombo.addActionListener(this);
        add(colorCombo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object z = e.getSource();


            //Menu Otwórz:
        if (z == mOtworz) {
            JFileChooser fc = new JFileChooser();
            if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File plik = fc.getSelectedFile();
                //JOptionPane.showMessageDialog(null,"Wybrany plik to " + plik.getAbsolutePath());
                try {
                    Scanner scaner = new Scanner(plik);
                    while (scaner.hasNext()) {
                        notepad.append(scaner.nextLine() + "\n");
                    }
                } catch (FileNotFoundException  el) {
                    el.printStackTrace();
                }
            }

            //Menu Zapisz:
        } else if (z == mZapisz) {
            JFileChooser fc = new JFileChooser();
            if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                File plik = fc.getSelectedFile();
                try {
                    PrintWriter pw = new PrintWriter(plik);
                    Scanner scaner = new Scanner(notepad.getText());
                    while (scaner.hasNext())
                        pw.println(scaner.nextLine() + "\n");
                    pw.close();     //trzeba zamkn¹æ printWriter! bo siê plik nie zapisze!!!
                } catch (FileNotFoundException el) {
                    el.printStackTrace();
                }
                //JOptionPane.showMessageDialog(null,"Wybrany plik to " + plik);
            }


            //Menu Wyjœcie:
        } else if (z == mWyjscie) {
            int odp = JOptionPane.showConfirmDialog(null, "Czy na pewno wyjœæ?", "Pytanie", JOptionPane.YES_NO_OPTION);

            if (odp == JOptionPane.YES_OPTION)
                dispose();
            else if (odp == JOptionPane.NO_OPTION)
                JOptionPane.showMessageDialog(null, "Wiedzia³em...");
            else if (odp == JOptionPane.CANCEL_OPTION)
                JOptionPane.showMessageDialog(null, "Tak nie robimy", "Tytu³", JOptionPane.WARNING_MESSAGE);


            //Pole wyszukiwania i przycisk Szukaj:
        } else if (z == bSzukaj) {
            String tekst = notepad.getText();
            String szukane = tSzukany.getText();
            String wystapienia = "";
            int i = 0;
            int index;
            int startIndex = 0;

            //pêtla wyszukuj¹ca tekst !!!!!
            while ((index = tekst.indexOf(szukane, startIndex)) != -1) {
                startIndex = index + szukane.length();
                i++;
                wystapienia += " " + index;
            }
            JOptionPane.showMessageDialog(null, szukane + " wyst¹pi³o " + i + " razy: " + wystapienia);


            //Przycisk Wybieranie koloru czcionki:
        } else if (z == bWybierzKolor) {
            Color wybranyKolor = JColorChooser.showDialog(null, "Wybór koloru", Color.GREEN);
            notepad.setForeground(wybranyKolor);

            //Popup, menu kontekstowe: Kopiuj, Wklej, Do³¹cz:
        } else if (z == mpCopy) {
            wybranyTekst = notepad.getSelectedText();
        } else if (z == mpPaste) {
            notepad.insert(wybranyTekst, notepad.getCaretPosition());
        } else if (z == mpAdd) {
            notepad.append("\n" + wybranyTekst);

            //Combobox:
        } else if (z == colorCombo) {
            String color = colorCombo.getSelectedItem().toString();
            if (color.equals("zielony")) {
                notepad.setForeground(Color.GREEN);
            } else if (color.equals("czarny")) {
                notepad.setForeground(Color.BLACK);
            } else if (color.equals("czerwony")) {
                notepad.setForeground(Color.RED);
            } else if (color.equals("niebieski")) {
                notepad.setForeground(Color.BLUE);
            } else if (color.equals("ró¿owy")) {
                notepad.setForeground(Color.PINK);

                //zmiana Look and Feel na ró¿ne style:
            }
            else if (z == mMetal) {
                try {
                    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e1) {
                    e1.printStackTrace();
                    //throw new RuntimeException(e1);
                }
                SwingUtilities.updateComponentTreeUI(this);
            } else if (z == mNimbus) {
                try {
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e1) {
                    e1.printStackTrace();
                    //throw new RuntimeException(e1);
                }
                SwingUtilities.updateComponentTreeUI(this);
            }
            else if (z == mWindows) {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e1) {
                    e1.printStackTrace();
                    //throw new RuntimeException(e1);
                }
                SwingUtilities.updateComponentTreeUI(this);

            }


        }

        //
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

            //O programie:
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
