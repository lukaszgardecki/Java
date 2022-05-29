import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CelsiusToFahrenheit4 extends JFrame implements ActionListener {

    private JLabel lCelsius, lFahrenheit;
    //dodajemy pola tekstowe:
    private JTextField tCelsius, tFahrenheit;
    //dodajemy przycisk"
    private JButton bKonwertuj;
    private JRadioButton rbCtoF;
    private JRadioButton rbFtoC;
    private ButtonGroup radioPanel;
    private double tempCelsius, tempFahrenheit;


    public CelsiusToFahrenheit4() {
        setSize(370,270);
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
        tFahrenheit.addActionListener(this);

        bKonwertuj = new JButton("Konwertuj");
        bKonwertuj.setBounds(110, 120, 100, 20);
        add(bKonwertuj);
        bKonwertuj.addActionListener(this);

        //Utwórz grupê radiobuttonów:
        radioPanel = new ButtonGroup();
        //Utwórz radioButton 1:
        rbCtoF = new JRadioButton("Celsiusz -> Fahrenheit");
        rbCtoF.setBounds(50,150,150,20);
        rbCtoF.setSelected(true);
        //Utwórz radioButton 2:
        rbFtoC = new JRadioButton("Fahrenheit -> Celsiusz");
        rbFtoC.setBounds(200,150,150,20);
        //Przypisz te radioButtony do radioPanelu:
        radioPanel.add(rbCtoF);
        radioPanel.add(rbFtoC);
        //Dodaj te radioButtony do ramki:
        add(rbCtoF);
        add(rbFtoC);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object zrodlo = e.getSource();

        if (zrodlo == bKonwertuj) {

            if (rbCtoF.isSelected()) {
                //z pola tekstowego tCelsiusz pobieramy tekst i konwertujemy go na double
                tempCelsius = Double.parseDouble(tCelsius.getText());
                tempFahrenheit = 32.0 + (9.0 / 5) * tempCelsius;
                //PRZEKSZTA£CENIE TEKSTU NA LICZBÊ TYPU DOUBLE. Zawartoœæ pola tFahrenheit ustawiamy metod¹ setText() na ³añcuch powsta³y przez przekonwertowanie liczby stopni Fahrenheita na ³añcuch tekstowy, a tê konwersjê proponujemy metod¹ valueOf() klasy String:
                tFahrenheit.setText(String.valueOf(tempFahrenheit));
            } else if (rbFtoC.isSelected()) {
                tempFahrenheit = Double.parseDouble(tFahrenheit.getText());
                tempCelsius = (tempFahrenheit - 32.0) * (5.0 / 9.0);
                tCelsius.setText(String.valueOf(tempCelsius));
            }
        }
        if (zrodlo == tCelsius) {
            tempCelsius = Double.parseDouble(tCelsius.getText());
            tempFahrenheit = 32.0 + (9.0 / 5) * tempCelsius;
            tFahrenheit.setText(String.valueOf(tempFahrenheit));
        } else if (zrodlo == tFahrenheit) {
            tempFahrenheit = Double.parseDouble(tFahrenheit.getText());
            tempCelsius = (tempFahrenheit - 32.0) * (5.0 / 9.0);
            tCelsius.setText(String.valueOf(tempCelsius));
        }
    }

    public static void main(String[] args) {
        CelsiusToFahrenheit4 aplikacja = new CelsiusToFahrenheit4();
        aplikacja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aplikacja.setVisible(true);

    }


}
