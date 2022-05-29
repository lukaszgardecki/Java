import javax.swing.*;

public class CelsiusToFahrenheit extends JFrame {

    public CelsiusToFahrenheit() {
        JLabel lCelsius, lFahrenheit;
        //dodajemy pola tekstowe:
        JTextField tCelsius, tFahrenheit;
        //dodajemy przycisk"
        JButton bKonwertuj;

        setSize(370,200);
        setTitle("Przeliczanie stopni Celsiusza na Fahrenheita");
        setLayout(null);

        lCelsius = new JLabel("Stopnie Celsiusza:");
        lCelsius.setBounds(20, 20, 150, 20);
        add(lCelsius);

        tCelsius = new JTextField("");
        tCelsius.setBounds(170, 20, 150, 20);
        add(tCelsius);

        lFahrenheit = new JLabel("Stopnie Fahrenheita:");
        lFahrenheit.setBounds(20,70,150,20);
        add(lFahrenheit);

        tFahrenheit = new JTextField("");
        tFahrenheit.setBounds(170,70,150,20);
        add(tFahrenheit);

        bKonwertuj = new JButton("Konwertuj");
        bKonwertuj.setBounds(110, 120, 100, 20);
        add(bKonwertuj);
    }

    public static void main(String[] args) {
        CelsiusToFahrenheit aplikacja = new CelsiusToFahrenheit();
        aplikacja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aplikacja.setVisible(true);

    }
}
