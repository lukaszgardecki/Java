package graSnake;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public static JLabel score;

    public MainFrame() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Snake");

        //stworzenie etykiety, która siê wyœwietli po zakoñczeniu gry. SwingConstants.CENTER ustawia napis na œrodku
        score = new JLabel("Score: ", SwingConstants.CENTER);

        //zmiana czcionki:
        score.setFont(new Font(score.getFont().getName(), Font.BOLD, 30));

        //dodanie etykiety do ramki ORAZ zlokalizowanie jej 'na pó³noc' czyli w górnej czêœæ ramki:
        add(score,BorderLayout.NORTH);

        //Do ramki nalezy dodaæ panel:
        add(new MainPanel());

        //metoda pack() dostosowuje odpowiedni¹ minimaln¹ wielkoœæ ramki ¿eby siê wszystko pomieœci³o
        pack();

        //¿eby ramka nie otwiera³a siê w lewym górnym rogu ekranu, tylko na œrodku nale¿y wstawiæ metodê setLocationRelativeTo() i w nawiasie ustawiæ wartoœæ na "null":
        setLocationRelativeTo(null);

        //zablokowanie mo¿liwoœci zmiany wielkoœci ramki przez u¿ytkownika
        setResizable(false);

    }
}
