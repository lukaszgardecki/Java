package pl.am.projects.celciusToFahrenheit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CelsiusToFahrenheit3 extends JFrame implements ActionListener {

    private JLabel lCelsius, lFahrenheit;
    //dodajemy pola tekstowe:
    private JTextField tCelsius, tFahrenheit;
    //dodajemy przycisk"
    private JButton bKonwertuj;
    private JCheckBox chWielkie;
    private double tempCelsius, tempFahrenheit;


    public CelsiusToFahrenheit3() {
        setSize(370,200);
        setTitle("Przeliczanie stopni Celsiusza na Fahrenheita");
        setLayout(null);

        lCelsius = new JLabel("Stopnie Celsiusza:");
        lCelsius.setBounds(20, 20, 150, 20);
        add(lCelsius);

        tCelsius = new JTextField("");
        tCelsius.setBounds(170, 20, 150, 20);
        add(tCelsius);
        tCelsius.addActionListener(this);

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

        chWielkie = new JCheckBox("Wielkie litery");
        chWielkie.setBounds(250, 120, 150, 20);
        add(chWielkie);
        //chWielkie.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object zrodlo = e.getSource();

        if (zrodlo == bKonwertuj || zrodlo == tCelsius) {

            if (chWielkie.isSelected()) {
                tFahrenheit.setFont(new Font("SansSerif", Font.BOLD, 18));
            } else {
                tFahrenheit.setFont(new Font("SansSerif", Font.PLAIN, 12));
            }

            //z pola tekstowego tCelsiusz pobieramy tekst i konwertujemy go na double
            tempCelsius = Double.parseDouble(tCelsius.getText());
            tempFahrenheit = 32.0 + (9.0 / 5) * tempCelsius;
            //PRZEKSZTA£CENIE TEKSTU NA LICZBÊ TYPU DOUBLE. Zawartoœæ pola tFahrenheit ustawiamy metod¹ setText() na ³añcuch powsta³y przez przekonwertowanie liczby stopni Fahrenheita na ³añcuch tekstowy, a tê konwersjê proponujemy metod¹ valueOf() klasy String:
            tFahrenheit.setText(String.valueOf(tempFahrenheit));
        }





    }


    public static void main(String[] args) {
        CelsiusToFahrenheit3 aplikacja = new CelsiusToFahrenheit3();
        aplikacja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aplikacja.setVisible(true);

    }


}
