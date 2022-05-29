package pl.am.projects.celciusToFahrenheit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CelsiusToFahrenheit2 extends JFrame implements ActionListener {

    private JLabel lCelsius, lFahrenheit;
    //dodajemy pola tekstowe:
    private JTextField tCelsius, tFahrenheit;
    //dodajemy przycisk"
    private JButton bKonwertuj;
    private ButtonGroup bgRozmiar;
    private JRadioButton rbMaly, rbSredni, rbDuzy;
    private double tempCelsius, tempFahrenheit;


    public CelsiusToFahrenheit2() {
        setSize(370,250);
        setTitle("Przeliczanie stopni Celsiusza na Fahrenheita");
        setLayout(null);

        lCelsius = new JLabel("Stopnie Celsiusza:");
        lCelsius.setBounds(20, 20, 150, 20);
        add(lCelsius);

        tCelsius = new JTextField("");
        tCelsius.setBounds(170, 20, 150, 20);
        add(tCelsius);
        tCelsius.addActionListener(this);
        tCelsius.setToolTipText("Podaj tempereaturê w stopniach Celsiusza"); //<--po najechaniu myszk¹ na pole pojawi siê informacja

        lFahrenheit = new JLabel("Stopnie Fahrenheita:");
        lFahrenheit.setBounds(20,70,150,20);
        add(lFahrenheit);

        tFahrenheit = new JTextField("");
        tFahrenheit.setBounds(170,70,150,20);
        add(tFahrenheit);

        bKonwertuj = new JButton("Konwertuj");
        bKonwertuj.setBounds(110, 120, 100, 20);
        add(bKonwertuj);
        bKonwertuj.addActionListener(this);

        bgRozmiar = new ButtonGroup();

        rbMaly = new JRadioButton("Ma³y", true);
        rbMaly.setBounds(50, 150, 100, 20);
        bgRozmiar.add(rbMaly);
        add(rbMaly);
        rbMaly.addActionListener(this);

        rbSredni = new JRadioButton("Œredni", false);
        rbSredni.setBounds(150, 150, 100, 20);
        bgRozmiar.add(rbSredni);
        add(rbSredni);
        rbSredni.addActionListener(this);

        rbDuzy = new JRadioButton("Du¿y", false);
        rbDuzy.setBounds(250, 150, 100, 20);
        bgRozmiar.add(rbDuzy);
        add(rbDuzy);
        rbDuzy.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object zrodlo = e.getSource();

        if (zrodlo == bKonwertuj || zrodlo == tCelsius) {
            //z pola tekstowego tCelsiusz pobieramy tekst i konwertujemy go na double
            tempCelsius = Double.parseDouble(tCelsius.getText());
            tempFahrenheit = 32.0 + (9.0 / 5) * tempCelsius;
            //PRZEKSZTA£CENIE TEKSTU NA LICZBÊ TYPU DOUBLE. Zawartoœæ pola tFahrenheit ustawiamy metod¹ setText() na ³añcuch powsta³y przez przekonwertowanie liczby stopni Fahrenheita na ³añcuch tekstowy, a tê konwersjê proponujemy metod¹ valueOf() klasy String:
            tFahrenheit.setText(String.valueOf(tempFahrenheit));
        } else if (zrodlo == rbMaly) {
            tFahrenheit.setFont(new Font("SansSerif", Font.PLAIN, 12));

        } else if (zrodlo == rbSredni) {
            tFahrenheit.setFont(new Font("SansSerif", Font.PLAIN, 16));

        } else if (zrodlo == rbDuzy) {
            tFahrenheit.setFont(new Font("SansSerif", Font.PLAIN, 20));

        }



    }


    public static void main(String[] args) {
        CelsiusToFahrenheit2 aplikacja = new CelsiusToFahrenheit2();
        aplikacja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aplikacja.setVisible(true);

    }


}
